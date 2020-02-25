package dataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider{
	
Properties pro;
	
	public ConfigDataProvider(){
		
		try {
			pro = new Properties();
			pro.load(new FileInputStream(new File(System.getProperty("user.dir") + "/configs/config.properties")));
		}catch(IOException e){
			
			System.out.println("Unable to load Properties file " + e.getMessage());
		}
		
	}
	
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("stagingURL");
	}
	
	public String getValueFromProperties(String key)
	{ 
		return pro.getProperty(key);
	}

}
