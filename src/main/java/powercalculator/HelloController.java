package powercalculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private static final Logger logger = LogManager.getLogger(HelloController.class.getName());
	@Value("autosupport.mongodb.username")
	private String DBUserName;
	@Value("autosupport.mongodb.path")
	private String DBPasswd;
	@RequestMapping("/hello")
	public String hello() {
		
		logger.info("this is a test");
		
		return DBUserName + DBPasswd;
	}
	
	
}
