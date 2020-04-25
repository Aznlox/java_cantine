import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Accueil {

	protected Shell shlAccueil;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Accueil window = new Accueil();
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
		shlAccueil.open();
		shlAccueil.layout();
		while (!shlAccueil.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		//Création de la fenêtre
		shlAccueil = new Shell();
		shlAccueil.setSize(450, 363);
		shlAccueil.setText("Accueil");
		
		//Création des boutons
		Button btnEtudiant = new Button(shlAccueil, SWT.NONE);
		btnEtudiant.setBounds(108, 93, 204, 35);
		btnEtudiant.setText("Tableau \u00E9tudiant");
		
		Button btnProf = new Button(shlAccueil, SWT.NONE);
		btnProf.setBounds(108, 179, 204, 35);
		btnProf.setText("Tableau professeur");
		
		//event bouton tableau étudiant
		btnEtudiant.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   
				   cantine_etudiant Tableau = new cantine_etudiant();
				   Tableau.open();
				   
			   }
		});
		
		//event bouton tableau prof
		btnProf.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   
				   cantine_prof Tableau = new cantine_prof();
				   Tableau.open();
				   
			   }
		});
	}
}
