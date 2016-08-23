

package waterpoint.test;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Noor Alamsyah
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPosition {

    private Double latitude;
    private Double longitude;

    /**
     * Public default constructor
     */
    public GeoPosition() {		
    }

    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition{" + "latitude='" + latitude + '\'' + ", longitude=" + longitude + '}';
    }
}

