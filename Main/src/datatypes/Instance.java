package datatypes;

public class Instance {
	private String databaseURL;
	private String databaseUser;
	private String datbasePassword;
	private String webURL;
	private String webUser;
	private String webPassword;
	
	
	public Instance(String databaseURL, String databaseUser, String datbasePassword, String webURL, String webUser,
			String webPassword) {
		super();
		this.databaseURL = databaseURL;
		this.databaseUser = databaseUser;
		this.datbasePassword = datbasePassword;
		this.webURL = webURL;
		this.webUser = webUser;
		this.webPassword = webPassword;
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

	public String getDatbasePassword() {
		return datbasePassword;
	}

	public void setDatbasePassword(String datbasePassword) {
		this.datbasePassword = datbasePassword;
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

	
}
