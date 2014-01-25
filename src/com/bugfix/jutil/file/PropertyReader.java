package com.bugfix.jutil.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import com.bugfix.jutil.validation.Validator;

public class PropertyReader {
	private static Properties properties;
	private static boolean isLoaded = false;
	private static String resourceLocation;

	private static void loadProperty() {
		try{
		File propertyFile = new File(resourceLocation);
		if (!propertyFile.exists() || !propertyFile.isFile()) {
			new FileNotFoundException("Invalid property location::"+ resourceLocation);
		}
		properties = new Properties();
		properties.load(new FileInputStream(propertyFile));
		if(properties.isEmpty()){
			System.err.println("Property file::"+resourceLocation+" is empty");
		}else{
			isLoaded = true;
		}
		}catch(IOException ioe){
			new Exception("Failed loading properties from location::"+resourceLocation+", Reaon::"+ioe.getMessage());
		}
	}

	public static String getProperty(String propertyKey, String defaultValue) {
		if(Validator.isEmpty(propertyKey)){
			System.err.println("Invalid Property::"+propertyKey);
			return null;
		}
		if(!isLoaded){
			loadProperty();
		}
		if(!properties.contains(propertyKey)){
			System.err.println("Property::"+propertyKey+" doesnot exist.");
			return defaultValue;
		}
		return properties.getProperty(propertyKey);
	}
	
	public static HashMap<String, String> getProperties(){
		if(!isLoaded){
			loadProperty();
		}
		Enumeration<Object> keys = properties.keys();
		HashMap<String, String> propertiesMap = new HashMap<>();
		while(keys.hasMoreElements()){
			String key = (String) keys.nextElement();
			propertiesMap.put(key, properties.getProperty(key));
		}
		if(propertiesMap.isEmpty()){
			System.out.println("Properties file at location::"+resourceLocation+" is empty.");
		}
		return propertiesMap;
	}
	
}
