package powercalculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
	@Value("app.log.localtion")
    private String location;
    public String getLocation() {
    	return this.location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

}
