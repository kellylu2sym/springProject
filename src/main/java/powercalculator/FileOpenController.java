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
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileOpenController {
	private static final Logger logger = LogManager.getLogger(FileOpenController.class.getName());

	@Autowired
	private StorageProperties pro;
	@GetMapping("/reader")
	public String FileReader(@RequestParam String filename) throws FileNotFoundException {
		String rootPath = pro.getLocation();
		String target = Paths.get(rootPath).resolve(filename).toString();
		FileInputStream fileInputStream = new FileInputStream(target);
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

	@PostMapping("/writer")
	public void FileWriter(@RequestParam String filename, @RequestParam String content) throws IOException {
		String target = Paths.get(pro.getLocation()).resolve(filename).toString();
		File file = new File(target);
		if(!file.exists()){
			file.createNewFile();
			}
		
		try 
		{
			FileOutputStream outputStream = new FileOutputStream(target,true);
			OutputStreamWriter tempWriter = new OutputStreamWriter(outputStream);
			BufferedWriter writer = new BufferedWriter(tempWriter);
			writer.write(content);
			//writer.write(content);
			writer.close();
			
		}
		catch(FileNotFoundException e)
        {
			
			logger.error("error in writer file", e);
		}
	}

}
