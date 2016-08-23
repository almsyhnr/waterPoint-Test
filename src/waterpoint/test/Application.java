/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package waterpoint.test;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.OrderedJSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 *
 * @author Noor Alamsyah
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private static final String URL = "https://raw.githubusercontent.com/onaio/ona-tech/master/data/water_points.json";    
    

    public static void main(String args[]) throws IOException {
        org.springframework.context.ConfigurableApplicationContext run = SpringApplication.run(Application.class, URL);    	  	
    }
    @Override
    public void run(String... strings) throws Exception {
        if (this.makeOnline()) {
            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            List<MediaType> supportedMediaTypes = new LinkedList<>(converter.getSupportedMediaTypes());
            MediaType mediaType = new MediaType("text", "plain", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET);

            supportedMediaTypes.add(mediaType);
            converter.setSupportedMediaTypes(supportedMediaTypes);
            restTemplate.getMessageConverters().add(converter);
            // Set the Accept header
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAccept(Collections.singletonList(mediaType));
            HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
            // Make the HTTP GET request, marshalling the response from JSON to an array of WaterPoint
            ResponseEntity<WaterPointTest[]> re = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, WaterPointTest[].class);
            WaterPointTest[] wp = re.getBody();

            this.processWaterPointTest(Arrays.asList(wp));
        } else {
            LOG.info("Internet not connected");
            throw new IllegalStateException("Please provide a connection!");
        }
    }
    private void processWaterPointTest(List<WaterPointTest> wp) throws IOException, JSONException {
        if (wp.isEmpty()) {
            LOG.info("No results found for the water point");
        } else {
            Double functioningYes = 0D, functioningNo = 0D;
            Set<String> villageNames = new HashSet<>();
            Multimap<String, String> waterFunctioningYes = new ArrayListMultimap<>();
            Multimap<String, String> waterFunctioningNo = new ArrayListMultimap<>();
            Map<String, Integer> percentageMap = new HashMap<>();
            OrderedJSONObject waterPointJson = new OrderedJSONObject();
            OrderedJSONObject villageCountJson = new OrderedJSONObject();
            OrderedJSONObject percentageJson = new OrderedJSONObject();
            DecimalFormat decimalFormat = new DecimalFormat("####0");
            // Process the water points
            for (int i = 0; i < wp.size(); i++) {
                villageNames.add(wp.get(i).getCommunities_villages().toString());

                String isWaterFunctioning = wp.get(i).getWater_functioning();
                switch (isWaterFunctioning) {
                    case "yes":
                        waterFunctioningYes.put(wp.get(i).getCommunities_villages().toString(), "yes");
                        functioningYes++;
                        break;
                    case "no":
                        waterFunctioningNo.put(wp.get(i).getCommunities_villages().toString(), "no");
                        functioningNo++;
                        break;
                }
            }
            waterPointJson.put("number_functional:", decimalFormat.format(functioningYes));
            Iterator<String> villageNameItr = villageNames.iterator();

            for (; villageNameItr.hasNext();) {
                String villageName = villageNameItr.next();
                Collection<String> villagesYes = waterFunctioningYes.get(villageName);
                Collection<String> villagesNO = waterFunctioningNo.get(villageName);

                // get the number of functional water points in each village
                villageCountJson.put(villageName, villagesYes.size());
                
                // calculate the percentage of non-functional water points in each village
                percentageMap.put(villageName, Integer.valueOf(decimalFormat.format((villagesNO.size() / functioningNo) * 100)));
            }

            waterPointJson.put("number_water_points:", villageCountJson);

            Iterator<String> percentageMapItr = this.sortByValues(percentageMap).keySet().iterator();

            while (percentageMapItr.hasNext()) {
                String key = percentageMapItr.next();
                Integer value = percentageMap.get(key);
                percentageJson.put(key, value.toString().concat("%"));
            }

            waterPointJson.put("community_ranking:", percentageJson);

            LOG.info(waterPointJson.toString());
            LOG.info("results found and processed for the water point");
        }
    }
    

    private void percentWaterFunctioningByKey(List<WaterPointTest> wp, String splitKey) throws IOException, JSONException {
        if (wp.isEmpty()) {
            LOG.info("No results found for the water point!");
        } else {
            Set<String> arbitraryKeys = new HashSet<>();

            // Add the arbitrary keys to the hash set
            for (int i = 0; i < 1; i++) {
                arbitraryKeys.add("water_pay");
                arbitraryKeys.add("respondent");
                arbitraryKeys.add("research_asst_name");
                arbitraryKeys.add("water_used_season");
                arbitraryKeys.add("_bamboo_dataset_id");
                arbitraryKeys.add("_deleted_at");
                arbitraryKeys.add("water_point_condition");
                arbitraryKeys.add("_xform_id_string");
                arbitraryKeys.add("other_point_1km");
                arbitraryKeys.add("_attachments");
                arbitraryKeys.add("communities_villages");
                arbitraryKeys.add("end");
                arbitraryKeys.add("animal_number");
                arbitraryKeys.add("water_point_id");
                arbitraryKeys.add("start");
                arbitraryKeys.add("water_connected");
                arbitraryKeys.add("water_manager_name");
                arbitraryKeys.add("_status");
                arbitraryKeys.add("enum_id_1");
                arbitraryKeys.add("water_lift_mechanism");
                arbitraryKeys.add("districts_divisions");
                arbitraryKeys.add("_uuid");
                arbitraryKeys.add("grid");
                arbitraryKeys.add("date");
                arbitraryKeys.add("formhub/uuid");
                arbitraryKeys.add("road_available");
                arbitraryKeys.add("water_functioning");
                arbitraryKeys.add("_submission_time");
                arbitraryKeys.add("signal");
                arbitraryKeys.add("water_source_type");
                arbitraryKeys.add("_geolocation");
                arbitraryKeys.add("water_point_image");
                arbitraryKeys.add("water_point_geocode");
                arbitraryKeys.add("deviceid");
                arbitraryKeys.add("locations_wards");
                arbitraryKeys.add("water_manager");
                arbitraryKeys.add("water_developer");
                arbitraryKeys.add("_id");
                arbitraryKeys.add("animal_point");
            }
            if (splitKey == null || splitKey.isEmpty() || !arbitraryKeys.contains(splitKey)) {
                LOG.info("Provide the correct arbitrary key");
                throw new IllegalArgumentException("Provide the correct arbitrary key");
            }
            Double functioningYes = 0D, functioningNo = 0D, totalYesAndNo = 0D;

            OrderedJSONObject waterPointJson = new OrderedJSONObject();

            DecimalFormat decimalFormat = new DecimalFormat("####0");

            // Process the water points
            for (int i = 0; i < wp.size(); i++) {
                String isWaterFunctioning = wp.get(i).getWater_functioning();
                switch (isWaterFunctioning) {
                    case "yes":
                        functioningYes++;
                        break;
                    case "no":
                        functioningNo++;
                        break;
                }
            }
            totalYesAndNo = functioningYes + functioningNo;
            Integer percentYes = Integer.valueOf(decimalFormat.format((functioningYes / totalYesAndNo) * 100));
            Integer percentNo = Integer.valueOf(decimalFormat.format((functioningNo / totalYesAndNo) * 100));

            waterPointJson.put("yes", percentYes.toString().concat("%"));
            waterPointJson.put("no", percentNo.toString().concat("%"));

            LOG.info(waterPointJson.toString());
            LOG.info("Results found and processed for the water point");
        }
    }

    private void percentBooleanByKey(List<WaterPointTest> wp, String booleanKey, String splitKey) throws IOException, JSONException {
        if (wp.isEmpty()) {
            LOG.info("No results found for the water point");
        } else {
            Set<String> arbitraryKeys = new HashSet<>();

            // Add the arbitrary keys to the hash set
            for (int i = 0; i < 1; i++) {
                arbitraryKeys.add("water_pay");
                arbitraryKeys.add("respondent");
                arbitraryKeys.add("research_asst_name");
                arbitraryKeys.add("water_used_season");
                arbitraryKeys.add("_bamboo_dataset_id");
                arbitraryKeys.add("_deleted_at");
                arbitraryKeys.add("water_point_condition");
                arbitraryKeys.add("_xform_id_string");
                arbitraryKeys.add("other_point_1km");
                arbitraryKeys.add("_attachments");
                arbitraryKeys.add("communities_villages");
                arbitraryKeys.add("end");
                arbitraryKeys.add("animal_number");
                arbitraryKeys.add("water_point_id");
                arbitraryKeys.add("start");
                arbitraryKeys.add("water_connected");
                arbitraryKeys.add("water_manager_name");
                arbitraryKeys.add("_status");
                arbitraryKeys.add("enum_id_1");
                arbitraryKeys.add("water_lift_mechanism");
                arbitraryKeys.add("districts_divisions");
                arbitraryKeys.add("_uuid");
                arbitraryKeys.add("grid");
                arbitraryKeys.add("date");
                arbitraryKeys.add("formhub/uuid");
                arbitraryKeys.add("road_available");
                arbitraryKeys.add("water_functioning");
                arbitraryKeys.add("_submission_time");
                arbitraryKeys.add("signal");
                arbitraryKeys.add("water_source_type");
                arbitraryKeys.add("_geolocation");
                arbitraryKeys.add("water_point_image");
                arbitraryKeys.add("water_point_geocode");
                arbitraryKeys.add("deviceid");
                arbitraryKeys.add("locations_wards");
                arbitraryKeys.add("water_manager");
                arbitraryKeys.add("water_developer");
                arbitraryKeys.add("_id");
                arbitraryKeys.add("animal_point");
            }

            if (splitKey == null || splitKey.isEmpty() || booleanKey == null || booleanKey.isEmpty() || !arbitraryKeys.contains(splitKey)
                || !arbitraryKeys.contains(booleanKey)) {
                LOG.info("Provide the correct arbitrary key!");
                throw new IllegalArgumentException("Provide the correct arbitrary and boolean keys!");
            }

            Double functioningYes = 0D, functioningNo = 0D, totalYesAndNo = 0D;

            OrderedJSONObject waterPointJson = new OrderedJSONObject();

            DecimalFormat decimalFormat = new DecimalFormat("####0");

            // Process the water points
            for (int i = 0; i < wp.size(); i++) {
                String isWaterFunctioning = wp.get(i).getWater_functioning();
                switch (isWaterFunctioning) {
                    case "yes":
                        functioningYes++;
                        break;
                    case "no":
                        functioningNo++;
                        break;
                }
            }

            totalYesAndNo = functioningYes + functioningNo;
            Integer percentYes = Integer.valueOf(decimalFormat.format((functioningYes / totalYesAndNo) * 100));
            Integer percentNo = Integer.valueOf(decimalFormat.format((functioningNo / totalYesAndNo) * 100));

            waterPointJson.put("yes", percentYes.toString().concat("%"));
            waterPointJson.put("no", percentNo.toString().concat("%"));

            LOG.info(waterPointJson.toString());
            LOG.info("matching results found and processed for the water point!");
        }
    }


    @SuppressWarnings("unchecked")
    private <K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map) {
        final List<Map.Entry<K,V>> entries = new LinkedList<>(map.entrySet());

        final Comparator<Map.Entry<K,V>> COMPARE_PERCENTAGE = new Comparator<Map.Entry<K,V>>() {
            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
    	};
    	
        Collections.sort(entries, COMPARE_PERCENTAGE);
  
        // LinkedHashMap will keep keys in the order they are inserted as it is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<>();
  
        for(Map.Entry<K,V> entry: entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }  
        return sortedMap;
    }

    /**
     *  Do we have an Internet connection?
     * @return TRUE if we're online
     */
    private boolean makeOnline() {
        boolean online = true;
        try {
            // test online connection with google.com
            new URL("http://www.google.com/").getContent();
        } catch (IOException ex) {
            online = false;
        }
        return online;
    }


}
