import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
		//création de la fenêtre
		shell = new Shell();
		shell.setSize(440, 294);
		shell.setText("Supprimer");
		
		//création des labels
		Label lblSupprimer = new Label(shell, SWT.NONE);
		lblSupprimer.setBounds(28, 10, 55, 15);
		lblSupprimer.setText("Supprimer");
		
		Label lblEntrezLeNom = new Label(shell, SWT.WRAP);
		lblEntrezLeNom.setBounds(28, 52, 360, 28);
		lblEntrezLeNom.setText("Entrez le nom et le pr\u00E9nom de l'\u00E9tudiant que vous voulez suprimmer");
		
		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(62, 106, 33, 15);
		lblNom.setText("Nom :");
		
		Label lblPrnom = new Label(shell, SWT.NONE);
		lblPrnom.setBounds(191, 106, 48, 15);
		lblPrnom.setText("Pr\u00E9nom :");
		
		//création des zones de textes
		text = new Text(shell, SWT.BORDER);
		text.setBounds(99, 100, 76, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(242, 100, 76, 21);
		
		//setup des boutons
		Button btnConfirmer = new Button(shell, SWT.NONE);
		btnConfirmer.setBounds(243, 203, 75, 25);
		btnConfirmer.setText("Confirmer");
		
		//évènement du bouton confirmer
		btnConfirmer.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   
				   //connexion à la bdd
				   String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				   String user="root";
				   String password="";
				   try {
					   //Commande pour supprimer dans la bdd
					   Connection cnx = DriverManager.getConnection(url, user, password);
					   Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					   stm.executeUpdate("delete from etudiant where nom='"+text.getText()+"' and prenom='"+text_1.getText()+"'");

				   } catch (SQLException e) {
					   System.out.println("Une erreur est survenue lors de la connexion à la base de données");
					   e.printStackTrace();
				   }
				   shell.close();
			  }
		});
		
		Button btnAnnuler = new Button(shell, SWT.NONE);
		btnAnnuler.setBounds(324, 203, 75, 25);
		btnAnnuler.setText("Annuler");
		
		//évènement du bouton annuler
		btnAnnuler.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {

				   shell.close();
				   
			  }
		});
	}
}
