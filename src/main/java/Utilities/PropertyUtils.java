package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Properties;

public class PropertyUtils {
	private static Properties properties = new Properties();
	
	static {
		try{
		 FileInputStream inputFileInputStream = new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+
					"resources"+File.separator+"AllURLs.properties");
			
			properties.load(inputFileInputStream);	
			
		}catch (IOException e) {
			System.out.println("Could not load properties file "+e.getMessage());
		}
}
	public static String getProperties(String property) {
		
		return properties.getProperty(property);
	}
}
