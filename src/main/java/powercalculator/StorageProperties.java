package powercalculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	@Value("${app.log.localtion}")
	private String location;
	@Value("${autosupport.mongodb.username}")
	private String DBUserName;
	@Value("${autsupport.mongodb.path}")
	private String DBPasswd;

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDBName() {
		return this.DBUserName;
	}

	public String getDBPasswd() {
		return this.DBPasswd;
	}

}
