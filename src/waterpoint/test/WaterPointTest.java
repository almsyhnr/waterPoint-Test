/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package waterpoint.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 *
 * @author Noor Alamsyah
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterPointTest {

    private String water_pay;

    private String respondent;

    private String research_asst_name;

    private String water_used_season;

    private String _xform_id_string;

    private String _bamboo_dataset_id;

    private String _deleted_at;

    private String water_point_condition;

    private String water_mechanism_plate;

    private String other_point_1km;

    @JsonIgnore
    private String _attachments;

    private String water_lift_mechanism_type;

    @JsonIgnore
    private String water_point_image;

    private String end;

    private String animal_number;

    private String water_point_id;

    private String start;

    private String water_connected;

    private String water_manager_name;

    private String _status;

    private Long enum_id_1;

    private String water_lift_mechanism;

    private String districts_divisions;

    private String _uuid;

    private String road_type;

    private String grid;

    private String date;

    private String communities_villages;

    private String formhub_uuid;

    private String road_available;

    private String water_functioning;

    private String _submission_time;

    private String signal;

    private String water_source_type;

    private GeoPosition geo_position;

    private String water_point_geocode;

    private String deviceid;

    private String locations_wards;

    private String water_manager;

    private String water_developer;

    private Long _id;

    private String animal_point;

    /**
     * Public default constructor
     */
    public WaterPointTest() {		
    }

    /**
     * @return the water_pay
     */
    public String getWater_pay() {
        return water_pay;
    }

    /**
     * @param waterPay the water_pay to set
     */
    public void setWater_pay(String waterPay) {
        water_pay = waterPay;
    }

    /**
     * @return the respondent
     */
    public String getRespondent() {
        return respondent;
    }

    /**
     * @param respondent the respondent to set
     */
    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    /**
     * @return the research_asst_name
     */
    public String getResearch_asst_name() {
        return research_asst_name;
    }

    /**
     * @param researchAsstName the research_asst_name to set
     */
    public void setResearch_asst_name(String researchAsstName) {
        research_asst_name = researchAsstName;
    }

    /**
     * @return the water_used_season
     */
    public String getWater_used_season() {
        return water_used_season;
    }

    /**
     * @param waterUsedSeason the water_used_season to set
     */
    public void setWater_used_season(String waterUsedSeason) {
        water_used_season = waterUsedSeason;
    }

    /**
     * @return the _xform_id_string
     */
    public String get_xform_id_string() {
        return _xform_id_string;
    }

    /**
     * @param xformIdString the _xform_id_string to set
     */
    public void set_xform_id_string(String xformIdString) {
        _xform_id_string = xformIdString;
    }

    /**
     * @return the _bamboo_dataset_id
     */
    public String get_bamboo_dataset_id() {
        return _bamboo_dataset_id;
    }

    /**
     * @param bambooDatasetId the _bamboo_dataset_id to set
     */
    public void set_bamboo_dataset_id(String bambooDatasetId) {
        _bamboo_dataset_id = bambooDatasetId;
    }

    /**
     * @return the _deleted_at
     */
    public String get_deleted_at() {
        return _deleted_at;
    }

    /**
     * @param deletedAt the _deleted_at to set
     */
    public void set_deleted_at(String deletedAt) {
        _deleted_at = deletedAt;
    }

    /**
     * @return the water_point_condition
     */
    public String getWater_point_condition() {
        return water_point_condition;
    }

    /**
     * @param waterPointCondition the water_point_condition to set
     */
    public void setWater_point_condition(String waterPointCondition) {
        water_point_condition = waterPointCondition;
    }

    /**
     * @return the water_mechanism_plate
     */
    public String getWater_mechanism_plate() {
        return water_mechanism_plate;
    }

    /**
     * @param waterMechanismPlate the water_mechanism_plate to set
     */
    public void setWater_mechanism_plate(String waterMechanismPlate) {
        water_mechanism_plate = waterMechanismPlate;
    }

    /**
     * @return the other_point_1km
     */
    public String getOther_point_1km() {
        return other_point_1km;
    }

    /**
     * @param otherPoint_1km the other_point_1km to set
     */
    public void setOther_point_1km(String otherPoint_1km) {
        other_point_1km = otherPoint_1km;
    }

    /**
     * @return the _attachments
     */
    public String get_attachments() {
        return _attachments;
    }

    /**
     * @param attachments the _attachments to set
     */
    public void set_attachments(String attachments) {
        _attachments = attachments;
    }

    /**
     * @return the water_lift_mechanism_type
     */
    public String getWater_lift_mechanism_type() {
        return water_lift_mechanism_type;
    }

    /**
     * @param waterLiftMechanismType the water_lift_mechanism_type to set
     */
    public void setWater_lift_mechanism_type(String waterLiftMechanismType) {
        water_lift_mechanism_type = waterLiftMechanismType;
    }

    /**
     * @return the water_point_image
     */
    public String getWater_point_image() {
        return water_point_image;
    }

    /**
     * @param waterPointImage the water_point_image to set
     */
    public void setWater_point_image(String waterPointImage) {
        water_point_image = waterPointImage;
    }

    /**
     * @return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return the animal_number
     */
    public String getAnimal_number() {
        return animal_number;
    }

    /**
     * @param animalNumber the animal_number to set
     */
    public void setAnimal_number(String animalNumber) {
        animal_number = animalNumber;
    }

    /**
     * @return the water_point_id
     */
    public String getWater_point_id() {
        return water_point_id;
    }

    /**
     * @param waterPointId the water_point_id to set
     */
    public void setWater_point_id(String waterPointId) {
        water_point_id = waterPointId;
    }

    /**
     * @return the start
     */
    public String getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * @return the water_connected
     */
    public String getWater_connected() {
        return water_connected;
    }

    /**
     * @param waterConnected the water_connected to set
     */
    public void setWater_connected(String waterConnected) {
        water_connected = waterConnected;
    }

    /**
     * @return the water_manager_name
     */
    public String getWater_manager_name() {
        return water_manager_name;
    }

    /**
     * @param waterManagerName the water_manager_name to set
     */
    public void setWater_manager_name(String waterManagerName) {
        water_manager_name = waterManagerName;
    }

    /**
     * @return the _status
     */
    public String get_status() {
        return _status;
    }

    /**
     * @param status the _status to set
     */
    public void set_status(String status) {
        _status = status;
    }

    /**
     * @return the enum_id_1
     */
    public Long getEnum_id_1() {
        return enum_id_1;
    }

    /**
     * @param enumId_1 the enum_id_1 to set
     */
    public void setEnum_id_1(Long enumId_1) {
        enum_id_1 = enumId_1;
    }

    /**
     * @return the water_lift_mechanism
     */
    public String getWater_lift_mechanism() {
        return water_lift_mechanism;
    }

    /**
     * @param waterLiftMechanism the water_lift_mechanism to set
     */
    public void setWater_lift_mechanism(String waterLiftMechanism) {
        water_lift_mechanism = waterLiftMechanism;
    }

    /**
     * @return the districts_divisions
     */
    public String getDistricts_divisions() {
        return districts_divisions;
    }

    /**
     * @param districtsDivisions the districts_divisions to set
     */
    public void setDistricts_divisions(String districtsDivisions) {
        districts_divisions = districtsDivisions;
    }

    /**
     * @return the _uuid
     */
    public String get_uuid() {
        return _uuid;
    }

    /**
     * @param uuid the _uuid to set
     */
    public void set_uuid(String uuid) {
        _uuid = uuid;
    }

    /**
     * @return the road_type
     */
    public String getRoad_type() {
        return road_type;
    }

    /**
     * @param roadType the road_type to set
     */
    public void setRoad_type(String roadType) {
        road_type = roadType;
    }

    /**
     * @return the grid
     */
    public String getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(String grid) {
        this.grid = grid;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the communities_villages
     */
    public String getCommunities_villages() {
        return communities_villages;
    }

    /**
     * @param communitiesVillages the communities_villages to set
     */
    public void setCommunities_villages(String communitiesVillages) {
        communities_villages = communitiesVillages;
    }

    /**
     * @return the formhub_uuid
     */
    public String getFormhub_uuid() {
        return formhub_uuid;
    }

    /**
     * @param formhubUuid the formhub_uuid to set
     */
    public void setFormhub_uuid(String formhubUuid) {
        formhub_uuid = formhubUuid;
    }

    /**
     * @return the road_available
     */
    public String getRoad_available() {
        return road_available;
    }

    /**
     * @param roadAvailable the road_available to set
     */
    public void setRoad_available(String roadAvailable) {
        road_available = roadAvailable;
    }

    /**
     * @return the water_functioning
     */
    public String getWater_functioning() {
        return water_functioning;
    }

    /**
     * @param waterFunctioning the water_functioning to set
     */
    public void setWater_functioning(String waterFunctioning) {
        water_functioning = waterFunctioning;
    }

    /**
     * @return the _submission_time
     */
    public String get_submission_time() {
        return _submission_time;
    }

    /**
     * @param submissionTime the _submission_time to set
     */
    public void set_submission_time(String submissionTime) {
        _submission_time = submissionTime;
    }

    /**
     * @return the signal
     */
    public String getSignal() {
        return signal;
    }

    /**
     * @param signal the signal to set
     */
    public void setSignal(String signal) {
        this.signal = signal;
    }

    /**
     * @return the water_source_type
     */
    public String getWater_source_type() {
        return water_source_type;
    }

    /**
     * @param waterSourceType the water_source_type to set
     */
    public void setWater_source_type(String waterSourceType) {
        water_source_type = waterSourceType;
    }

    /**
     * @return the geo_position
     */
    public GeoPosition getGeo_position() {
        return geo_position;
    }

    /**
     * @param geoPosition the geo_position to set
     */
    public void setGeo_position(GeoPosition geoPosition) {
        geo_position = geoPosition;
    }

    /**
     * @return the water_point_geocode
     */
    public String getWater_point_geocode() {
        return water_point_geocode;
    }

    /**
     * @param waterPointGeocode the water_point_geocode to set
     */
    public void setWater_point_geocode(String waterPointGeocode) {
        water_point_geocode = waterPointGeocode;
    }

    /**
     * @return the deviceid
     */
    public String getDeviceid() {
        return deviceid;
    }

    /**
     * @param deviceid the deviceid to set
     */
    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    /**
     * @return the locations_wards
     */
    public String getLocations_wards() {
        return locations_wards;
    }

    /**
     * @param locationsWards the locations_wards to set
     */
    public void setLocations_wards(String locationsWards) {
        locations_wards = locationsWards;
    }

    /**
     * @return the water_manager
     */
    public String getWater_manager() {
        return water_manager;
    }

    /**
     * @param waterManager the water_manager to set
     */
    public void setWater_manager(String waterManager) {
        water_manager = waterManager;
    }

    /**
     * @return the water_developer
     */
    public String getWater_developer() {
        return water_developer;
    }

    /**
     * @param waterDeveloper the water_developer to set
     */
    public void setWater_developer(String waterDeveloper) {
        water_developer = waterDeveloper;
    }

    /**
     * @return the _id
     */
    public Long get_id() {
        return _id;
    }

    /**
     * @param id the _id to set
     */
    public void set_id(Long id) {
        _id = id;
    }

    /**
     * @return the animal_point
     */
    public String getAnimal_point() {
        return animal_point;
    }

    /**
     * @param animalPoint the animal_point to set
     */
    public void setAnimal_point(String animalPoint) {
        animal_point = animalPoint;
    }    
    
}
