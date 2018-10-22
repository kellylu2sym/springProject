package powercalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileOperController {
	private static final Logger logger = LogManager.getLogger(FileOperController.class.getName());

	@GetMapping("/")
	public String FileReader(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		BufferedReader reader = null;
		StringBuffer buf = new StringBuffer();
		
		try {

			InputStreamReader tempReader = new InputStreamReader(fileInputStream);
			reader = new BufferedReader(tempReader);
			String tempString;
			while((tempString = reader.readLine()) != null)
			{
				buf.append(tempString);
			}
			reader.close();
			
			return buf.toString();
			
						
		} catch (Exception e) {

			logger.error("error in reader file", e);
		}
		return null;
	}

	@PostMapping("/")
	public void FileWriter(String filePath, String content) throws IOException {
		File file = new File(filePath);
		
		try 
		{
			FileOutputStream outputStream = new FileOutputStream(file);
			OutputStreamWriter tempWriter = new OutputStreamWriter(outputStream);
			BufferedWriter writer = new BufferedWriter(tempWriter);
			writer.write(content);
			
		}
		catch(FileNotFoundException e)
        {
			
			logger.error("error in writer file", e);
		}
	}

}
