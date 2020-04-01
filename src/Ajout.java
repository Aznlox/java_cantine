import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Ajout {

	protected Shell shell;
	private Text textNom;
	private Text textPrenom;
	private Text textRegime;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Ajout window = new Ajout();
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
		shell.setSize(587, 384);
		
		Label lblTitre = new Label(shell, SWT.NONE);
		lblTitre.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblTitre.setBounds(30, 10, 126, 36);
		lblTitre.setText("Ajouter un \u00E9l\u00E8ve");
		
		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(68, 63, 55, 15);
		lblNom.setText("Nom");
		
		Label lblPrenom = new Label(shell, SWT.NONE);
		lblPrenom.setBounds(68, 92, 55, 15);
		lblPrenom.setText("Pr\u00E9nom");
		
		Label lblClasse = new Label(shell, SWT.NONE);
		lblClasse.setBounds(67, 122, 55, 15);
		lblClasse.setText("Classe");
		
		Label lblCantine = new Label(shell, SWT.NONE);
		lblCantine.setBounds(68, 151, 55, 15);
		lblCantine.setText("Cantine");
		
		Label lblJours = new Label(shell, SWT.NONE);
		lblJours.setBounds(68, 178, 55, 15);
		lblJours.setText("Jours");
		
		Label lblRegimeAlimentaire = new Label(shell, SWT.NONE);
		lblRegimeAlimentaire.setBounds(68, 209, 117, 15);
		lblRegimeAlimentaire.setText("R\u00E9gime Alimentaire");
		
		textNom = new Text(shell, SWT.BORDER);
		textNom.setBounds(207, 60, 91, 21);
		
		textPrenom = new Text(shell, SWT.BORDER);
		textPrenom.setBounds(207, 89, 91, 21);
		
		Combo comboClasse = new Combo(shell, SWT.READ_ONLY);
		comboClasse.setBounds(207, 118, 91, 23);
		
		Button btnOui = new Button(shell, SWT.RADIO);
		btnOui.setBounds(207, 152, 49, 16);
		btnOui.setText("Oui");
		
		Button btnNon = new Button(shell, SWT.RADIO);
		btnNon.setBounds(262, 152, 49, 16);
		btnNon.setText("Non");
		
		Button btnLundi = new Button(shell, SWT.CHECK);
		btnLundi.setBounds(207, 178, 55, 16);
		btnLundi.setText("Lundi");
		
		Button btnMardi = new Button(shell, SWT.CHECK);
		btnMardi.setBounds(272, 177, 55, 16);
		btnMardi.setText("Mardi");
		
		Button btnMercredi = new Button(shell, SWT.CHECK);
		btnMercredi.setBounds(334, 177, 72, 16);
		btnMercredi.setText("Mercredi");
		
		Button btnJeudi = new Button(shell, SWT.CHECK);
		btnJeudi.setBounds(412, 177, 56, 16);
		btnJeudi.setText("Jeudi");
		
		Button btnVendredi = new Button(shell, SWT.CHECK);
		btnVendredi.setBounds(468, 177, 72, 16);
		btnVendredi.setText("Vendredi");
		
		textRegime = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		textRegime.setBounds(207, 209, 178, 67);
		
		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnValider.setBounds(363, 296, 75, 25);
		btnValider.setText("Ajouter");
		
		Button btnAnnuler = new Button(shell, SWT.NONE);
		btnAnnuler.setBounds(465, 296, 75, 25);
		btnAnnuler.setText("Annuler");

	}
}
