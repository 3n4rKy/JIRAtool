package gui;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class InstancesDialog {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InstancesDialog window = new InstancesDialog();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(720, 480);
		shell.setText("SWT Application");
		
		final AddInstancesDialog addInstancesDialog = new AddInstancesDialog(shell, 0);
		List list = new List(shell, SWT.BORDER);
		list.setBounds(10, 10, 692, 400);
		
		Button addInstanceButton = new Button(shell, SWT.NONE);
		addInstanceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addInstancesDialog.open();
			}
		});
		addInstanceButton.setBounds(10, 416, 24, 24);
		addInstanceButton.setText("+");
		
		Button deleteInstanceButton = new Button(shell, SWT.NONE);
		deleteInstanceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		deleteInstanceButton.setText("-");
		deleteInstanceButton.setBounds(40, 416, 24, 24);

	}
}
