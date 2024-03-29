package datatypes;

public class Instance {
	private int instanceID; 
	private String instanceName;
	private String databaseURL;
	private String databaseUser;
	private String databasePassword;
	private String webURL;
	private String webUser;
	private String webPassword;
	
	
	public Instance() {
	}

	public String getDatabaseURL() {
		return databaseURL;
	}

	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}

	public String getDatabaseUser() {
		return databaseUser;
	}

	public void setDatabaseUser(String databaseUser) {
		this.databaseUser = databaseUser;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	public void setDatabasePassword(String datbasePassword) {
		this.databasePassword = datbasePassword;
	}

	public String getWebURL() {
		return webURL;
	}

	public void setWebURL(String webURL) {
		this.webURL = webURL;
	}

	public String getWebUser() {
		return webUser;
	}

	public void setWebUser(String webUser) {
		this.webUser = webUser;
	}

	public String getWebPassword() {
		return webPassword;
	}

	public void setWebPassword(String webPassword) {
		this.webPassword = webPassword;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	
}
