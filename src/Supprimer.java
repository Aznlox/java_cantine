import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Supprimer {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Supprimer window = new Supprimer();
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
		shell.setSize(440, 294);
		shell.setText("SWT Application");
		
		Label lblSupprimer = new Label(shell, SWT.NONE);
		lblSupprimer.setBounds(28, 10, 55, 15);
		lblSupprimer.setText("Supprimer");
		
		Label lblEntrezLeNom = new Label(shell, SWT.WRAP);
		lblEntrezLeNom.setBounds(28, 52, 360, 28);
		lblEntrezLeNom.setText("Entrez le nom et le pr\u00E9nom de l'\u00E9tudiant que vous voulez suprimmer");
		
		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(62, 106, 55, 15);
		lblNom.setText("Nom :");
		
		Label lblPrnom = new Label(shell, SWT.NONE);
		lblPrnom.setBounds(191, 106, 55, 15);
		lblPrnom.setText("Pr\u00E9nom :");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(99, 100, 76, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(242, 100, 76, 21);
		
		Button btnConfimer = new Button(shell, SWT.NONE);
		btnConfimer.setBounds(243, 203, 75, 25);
		btnConfimer.setText("Confimer");
		
		Button btnAnnuler = new Button(shell, SWT.NONE);
		btnAnnuler.setBounds(324, 203, 75, 25);
		btnAnnuler.setText("Annuler");

	}
}
