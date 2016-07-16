package properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
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
	
	private Instance readFile() {
		Instance instance;
		try(BufferedReader br = new BufferedReader(new FileReader(CONFIG_FILE))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        
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
