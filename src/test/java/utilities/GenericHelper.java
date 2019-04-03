package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

	public String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MM_yy-HH_mm_ss");
		return df.format(date);
	}
	
	public String getScreenshot(String folderName, String fileName, WebDriver driver) {
		 File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 File desImg = new File(getFilePath(folderName, fileName)+getDate()+".png");
		 try {
			FileUtils.copyFile(img, desImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 System.out.println(desImg.getAbsolutePath());
		 return desImg.getAbsolutePath();
	}

}
