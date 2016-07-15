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

import datatypes.Instance;
import properties.ManageProperties;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AddInstancesDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text txtDatabaseURL;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Label lblDatabaseUser;
	private Text txtDatabaseUser;
	private Label lblDatabasePassword;
	private Text txtDatabasePassword;
	private Label lblInstanceName;
	private Text txtInstanceName;
	private Label lblWebUrl;
	private Text txtWebURL;
	private Label lblWebUser;
	private Text txtWebUser;
	private Label lblWebPassword;
	private Text txtWebPassword;
	

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
		
		txtDatabaseURL = new Text(shell, SWT.BORDER);
		txtDatabaseURL.setBounds(176, 60, 528, 21);
		
		Label lblDatabaseUrl = new Label(shell, SWT.CENTER);
		lblDatabaseUrl.setAlignment(SWT.LEFT);
		lblDatabaseUrl.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblDatabaseUrl.setBounds(10, 60, 135, 21);
		formToolkit.adapt(lblDatabaseUrl, true, true);
		lblDatabaseUrl.setText("Database URL:");
		
		lblDatabaseUser = new Label(shell, SWT.CENTER);
		lblDatabaseUser.setAlignment(SWT.LEFT);
		lblDatabaseUser.setText("Database User:");
		lblDatabaseUser.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblDatabaseUser.setBounds(10, 87, 135, 21);
		formToolkit.adapt(lblDatabaseUser, true, true);
		
		txtDatabaseUser = new Text(shell, SWT.BORDER);
		txtDatabaseUser.setBounds(176, 87, 528, 21);
		formToolkit.adapt(txtDatabaseUser, true, true);
		
		lblDatabasePassword = new Label(shell, SWT.CENTER);
		lblDatabasePassword.setAlignment(SWT.LEFT);
		lblDatabasePassword.setText("Database Password:");
		lblDatabasePassword.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblDatabasePassword.setBounds(10, 114, 135, 21);
		formToolkit.adapt(lblDatabasePassword, true, true);
		
		txtDatabasePassword = new Text(shell, SWT.BORDER);
		txtDatabasePassword.setBounds(176, 114, 528, 21);
		formToolkit.adapt(txtDatabasePassword, true, true);
		
		lblInstanceName = new Label(shell, SWT.CENTER);
		lblInstanceName.setText("Instance Name:");
		lblInstanceName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblInstanceName.setAlignment(SWT.LEFT);
		lblInstanceName.setBounds(10, 10, 135, 21);
		formToolkit.adapt(lblInstanceName, true, true);
		
		txtInstanceName = new Text(shell, SWT.BORDER);
		txtInstanceName.setBounds(176, 10, 528, 21);
		formToolkit.adapt(txtInstanceName, true, true);
		
		lblWebUrl = new Label(shell, SWT.CENTER);
		lblWebUrl.setText("Web URL:");
		lblWebUrl.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblWebUrl.setAlignment(SWT.LEFT);
		lblWebUrl.setBounds(10, 167, 135, 21);
		formToolkit.adapt(lblWebUrl, true, true);
		
		txtWebURL = new Text(shell, SWT.BORDER);
		txtWebURL.setBounds(176, 167, 528, 21);
		formToolkit.adapt(txtWebURL, true, true);
		
		lblWebUser = new Label(shell, SWT.CENTER);
		lblWebUser.setText("Web User:");
		lblWebUser.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblWebUser.setAlignment(SWT.LEFT);
		lblWebUser.setBounds(10, 194, 135, 21);
		formToolkit.adapt(lblWebUser, true, true);
		
		txtWebUser = new Text(shell, SWT.BORDER);
		txtWebUser.setBounds(176, 194, 528, 21);
		formToolkit.adapt(txtWebUser, true, true);
		
		lblWebPassword = new Label(shell, SWT.CENTER);
		lblWebPassword.setText("Web Password:");
		lblWebPassword.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblWebPassword.setAlignment(SWT.LEFT);
		lblWebPassword.setBounds(10, 221, 135, 21);
		formToolkit.adapt(lblWebPassword, true, true);
		
		txtWebPassword = new Text(shell, SWT.BORDER);
		txtWebPassword.setBounds(176, 221, 528, 21);
		formToolkit.adapt(txtWebPassword, true, true);
		
		Button btnAdd = new Button(shell, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saveProperties();
			}
		});
		btnAdd.setBounds(10, 417, 75, 25);
		formToolkit.adapt(btnAdd, true, true);
		btnAdd.setText("Add");
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnCancel.setBounds(91, 417, 75, 25);
		formToolkit.adapt(btnCancel, true, true);
		btnCancel.setText("Cancel");

	}
	
	private void saveProperties() {
		
		String instanceName = txtInstanceName.getText();
		String databaseURL = txtDatabaseURL.getText();
		String databaseUser = txtDatabaseUser.getText();
		String databasePassword = txtDatabasePassword.getText();
		String webURL = txtWebURL.getText();
		String webUser = txtWebUser.getText();
		String webPassword = txtWebPassword.getText();
		Instance instance = new Instance();
		
		if (instanceName != null) {
			instance.setInstanceName(instanceName);
			instance.setDatabaseURL(databaseURL);
			instance.setDatabaseUser(databaseUser);
			instance.setDatabasePassword(databasePassword);
			instance.setWebURL(webURL);
			instance.setWebUser(webUser);
			instance.setWebPassword(webPassword);
		}
		ManageProperties manageProperties = new ManageProperties();
		manageProperties.saveProperties(instance);
	}
}
