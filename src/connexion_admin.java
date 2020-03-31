import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class connexion_admin {
	private static Text textId;
	private static Text textMdp;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlAzJunior = new Shell();
		shlAzJunior.setSize(577, 475);
		shlAzJunior.setText("Az Junior");
		
		Label lblId = new Label(shlAzJunior, SWT.NONE);
		lblId.setBounds(122, 95, 96, 25);
		lblId.setText("Identifiant :");
		
		Label lblMdp = new Label(shlAzJunior, SWT.NONE);
		lblMdp.setBounds(122, 152, 123, 25);
		lblMdp.setText("Mot de passe :");
		
		textId = new Text(shlAzJunior, SWT.BORDER);
		textId.setBounds(292, 92, 131, 31);
		
		textMdp = new Text(shlAzJunior, SWT.BORDER);
		textMdp.setBounds(292, 149, 131, 31);
		
		Button btnCo = new Button(shlAzJunior, SWT.NONE);
		btnCo.setBounds(122, 226, 113, 35);
		btnCo.setText("Se connecter");
		
		Label lblErreur = new Label(shlAzJunior, SWT.NONE);
		lblErreur.setBounds(292, 226, 223, 31);
		
		btnCo.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   
				   String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				   String user="root";
				   String password="";
				   try {
						Connection cnx = DriverManager.getConnection(url, user, password);
						Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = stm.executeQuery("select * from compte where identifiant ='"+textId.getText()+"' and mdp ='"+textMdp.getText()+"'");
						
						if(rs.next()){
							Accueil fen2 = new Accueil();
							shlAzJunior.close();
							fen2.open();
						}
						else {
							lblErreur.setText("Mauvais identifiant ou mot de passe");
						}
					} catch (SQLException e) {
						System.out.println("Une erreur est survenue lors de la connexion à la base de données");
						e.printStackTrace();
					}
				    
			   }
		});

		shlAzJunior.open();
		shlAzJunior.layout();
		while (!shlAzJunior.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		

	}
}
