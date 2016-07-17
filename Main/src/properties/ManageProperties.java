package properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

import datatypes.Instance;

public class ManageProperties {

	Properties prop = new Properties();
	OutputStream output = null;
	private static String CONFIG_FILE = "config.properties";
	
	 

	public void saveProperties(Instance instance) {

		try {

			output = new FileOutputStream(CONFIG_FILE);

			// set the properties value
			prop.setProperty(instance.getInstanceName() + "DatabaseURL", instance.getDatabaseURL());
			prop.setProperty(instance.getInstanceName() + "DatabaseUser", instance.getDatabaseUser());
			prop.setProperty(instance.getInstanceName() + "DatabasePassword", instance.getDatabasePassword());
			prop.setProperty(instance.getInstanceName() + "WebURL", instance.getWebURL());
			prop.setProperty(instance.getInstanceName() + "WebUser", instance.getWebUser());
			prop.setProperty(instance.getInstanceName() + "WebPassword", instance.getWebPassword());
			

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean checkExistingInstances(Instance instance) {
		boolean instanceExists = false;
		
		return instanceExists;
		
	}
	
	private Instance[] readFile() {
		Instance instance = null;
		ArrayList<Instance> instances[];
		String tempInstanceName = "";
		int i = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(CONFIG_FILE))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	int posKeyVal = line.indexOf('=');
		    	
		        String instanceAndKey = line.substring(0, posKeyVal).trim();
		        String value = line.substring(posKeyVal + 1).trim();
		        int posInstKey = instanceAndKey.indexOf('.');
		        String instanceName = instanceAndKey.substring(0, posInstKey).trim();
		        String key = instanceAndKey.substring(posInstKey+1).trim();
		        if (!tempInstanceName.equals(instanceName)) {
		        	
		        	instance.setInstanceName(instanceName);
		        		
		        	}
		        switch (key) {
	        	case "databaseURL": instance.setDatabaseURL(value);
		        }
		   
		        tempInstanceName = instanceName;
		        
		        
		    }
		    // line is not visible here.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
