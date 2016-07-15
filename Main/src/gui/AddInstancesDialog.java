package gui;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class AddInstancesDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private static String CONFIG_FILE = "config.properties";
	private Label lblDatabaseUser;
	private Text text_1;
	private Label lblDatabasePassword;
	private Text text_2;
	

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public AddInstancesDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(720, 480);
		shell.setText(getText());
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(176, 10, 528, 21);
		
		Label lblDatabaseUrl = new Label(shell, SWT.CENTER);
		lblDatabaseUrl.setAlignment(SWT.LEFT);
		lblDatabaseUrl.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblDatabaseUrl.setBounds(10, 10, 135, 21);
		formToolkit.adapt(lblDatabaseUrl, true, true);
		lblDatabaseUrl.setText("Database URL:");
		
		lblDatabaseUser = new Label(shell, SWT.CENTER);
		lblDatabaseUser.setAlignment(SWT.LEFT);
		lblDatabaseUser.setText("Database User:");
		lblDatabaseUser.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblDatabaseUser.setBounds(10, 37, 135, 21);
		formToolkit.adapt(lblDatabaseUser, true, true);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(176, 37, 528, 21);
		formToolkit.adapt(text_1, true, true);
		
		lblDatabasePassword = new Label(shell, SWT.CENTER);
		lblDatabasePassword.setAlignment(SWT.LEFT);
		lblDatabasePassword.setText("Database Password:");
		lblDatabasePassword.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblDatabasePassword.setBounds(10, 64, 135, 21);
		formToolkit.adapt(lblDatabasePassword, true, true);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(176, 64, 528, 21);
		formToolkit.adapt(text_2, true, true);

	}
	
	private void saveProperties() {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream(CONFIG_FILE);

			// set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "mkyong");
			prop.setProperty("dbpassword", "password");

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
	
}
