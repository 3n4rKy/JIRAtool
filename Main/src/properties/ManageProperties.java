package properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import datatypes.Instance;

public class ManageProperties {

	Properties prop = new Properties();
	OutputStream output = null;
	private static String CONFIG_FILE = "config.properties";
	int instanceID = 0; 

	public void saveProperties(Instance instance) {

		try {

			output = new FileOutputStream(CONFIG_FILE);

			// set the properties value
			prop.setProperty(instanceID + "InstanceName", instance.getInstanceName());
			prop.setProperty(instanceID + "DatabaseURL", instance.getDatabaseURL());
			prop.setProperty(instanceID + "DatabaseUser", instance.getDatabaseUser());
			prop.setProperty(instanceID + "DatabasePassword", instance.getDatabasePassword());
			prop.setProperty(instanceID + "WebURL", instance.getWebURL());
			prop.setProperty(instanceID + "WebUser", instance.getWebUser());
			prop.setProperty(instanceID + "WebPassword", instance.getWebPassword());
			

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
}
