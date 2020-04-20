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
		shlAccueil = new Shell();
		shlAccueil.setSize(449, 445);
		shlAccueil.setText("Accueil");
		
		Button btnEtudiant = new Button(shlAccueil, SWT.NONE);
		btnEtudiant.setBounds(108, 87, 204, 35);
		btnEtudiant.setText("Tableau \u00E9tudiant");
		
		Button btnProf = new Button(shlAccueil, SWT.NONE);
		btnProf.setBounds(108, 161, 204, 35);
		btnProf.setText("Tableau professeur");
		
		Button btnModif = new Button(shlAccueil, SWT.NONE);
		btnModif.setBounds(108, 233, 204, 35);
		btnModif.setText("Modifier un \u00E9tudiant");
		
		btnEtudiant.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   
				   cantine_etudiant Tableau = new cantine_etudiant();
				   Tableau.open();
				   
			   }
		});
		btnProf.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   
				   
				   
			   }
		});
		btnModif.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   
				   
				   
			   }
		});

	}
}
