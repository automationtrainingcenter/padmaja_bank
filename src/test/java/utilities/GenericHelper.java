package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class GenericHelper {

	public String readProperty(String key) {
		String value = null;
		try {
			FileInputStream fis = new FileInputStream(getFilePath("", "config.properties"));
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
	public String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir")+File.separator+folderName+File.separator+fileName;
	}

}
