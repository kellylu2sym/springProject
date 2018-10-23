package powercalculator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.SERVICE_UNAVAILABLE, reason= "db mongoDB could not be reached")
public class StorageException extends RuntimeException {

	  public StorageException(String message) {
	        super(message);
	    }
	  
	  public StorageException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
