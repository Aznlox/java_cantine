import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;

public class Modifier {

	protected Shell shell;
	private Text textNom;
	private Text textPrenom;
	private Text textRegime;
	private Text Cnom;
	private Text Cprenom;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Modifier window = new Modifier();
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
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		
		//Création de la fenêtre
		shell = new Shell();
		shell.setSize(589, 454);
		shell.setText("Modifier");
		
		//création des labels
		Label lblTitre = new Label(shell, SWT.NONE);
		lblTitre.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblTitre.setBounds(30, 10, 126, 36);
		lblTitre.setText("Modifier un \u00E9l\u00E8ve");
		
		Label lblEntrezLeNom = new Label(shell, SWT.NONE);
		lblEntrezLeNom.setBounds(40, 45, 261, 15);
		lblEntrezLeNom.setText("Entrez le nom et le pr\u00E9nom de l'\u00E9l\u00E8ve \u00E0 modifier");
		
		Label lblNom_1 = new Label(shell, SWT.NONE);
		lblNom_1.setBounds(50, 66, 36, 15);
		lblNom_1.setText("Nom");
		
		//création des zones de textes
		Cnom = new Text(shell, SWT.BORDER);
		Cnom.setBounds(92, 63, 84, 21);
		
		Label lblPrenom_1 = new Label(shell, SWT.NONE);
		lblPrenom_1.setBounds(197, 66, 49, 15);
		lblPrenom_1.setText("Pr\u00E9nom");
		
		Cprenom = new Text(shell, SWT.BORDER);
		Cprenom.setBounds(252, 63, 91, 21);
		
		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(68, 127, 55, 15);
		lblNom.setText("Nom");
		
		Label lblPrenom = new Label(shell, SWT.NONE);
		lblPrenom.setBounds(68, 156, 55, 15);
		lblPrenom.setText("Pr\u00E9nom");
		
		Label lblClasse = new Label(shell, SWT.NONE);
		lblClasse.setBounds(67, 186, 55, 15);
		lblClasse.setText("Classe");
		
		Label lblCantine = new Label(shell, SWT.NONE);
		lblCantine.setBounds(68, 215, 55, 15);
		lblCantine.setText("Cantine");
		
		Label lblJours = new Label(shell, SWT.NONE);
		lblJours.setBounds(68, 242, 55, 15);
		lblJours.setText("Jours");
		
		Label lblRegimeAlimentaire = new Label(shell, SWT.NONE);
		lblRegimeAlimentaire.setBounds(68, 273, 117, 15);
		lblRegimeAlimentaire.setText("R\u00E9gime Alimentaire");
		
		Label labelChoix = new Label(shell, SWT.NONE);
		labelChoix.setEnabled(false);
		labelChoix.setVisible(false);
		labelChoix.setBounds(351, 215, 55, 15);
		
		Label labelJour = new Label(shell, SWT.NONE);
		labelJour.setEnabled(false);
		labelJour.setVisible(false);
		labelJour.setBounds(468, 325, 55, 15);
		
		Label labelLundi = new Label(shell, SWT.NONE);
		labelLundi.setEnabled(false);
		labelLundi.setVisible(false);
		labelLundi.setBounds(391, 273, 55, 15);
		
		Label labelMardi = new Label(shell, SWT.NONE);
		labelMardi.setEnabled(false);
		labelMardi.setVisible(false);
		labelMardi.setBounds(452, 273, 55, 15);
		
		Label labelMercredi = new Label(shell, SWT.NONE);
		labelMercredi.setEnabled(false);
		labelMercredi.setVisible(false);
		labelMercredi.setBounds(391, 294, 55, 15);
		
		Label labelJeudi = new Label(shell, SWT.NONE);
		labelJeudi.setEnabled(false);
		labelJeudi.setVisible(false);
		labelJeudi.setBounds(452, 294, 55, 15);
		
		Label labelVendredi = new Label(shell, SWT.NONE);
		labelVendredi.setEnabled(false);
		labelVendredi.setVisible(false);
		labelVendredi.setBounds(391, 315, 55, 15);
		
		textNom = new Text(shell, SWT.BORDER);
		textNom.setBounds(207, 124, 91, 21);
		
		textPrenom = new Text(shell, SWT.BORDER);
		textPrenom.setBounds(207, 153, 91, 21);
	
		//setup de la liste déroulante
		Combo comboClasse = new Combo(shell, SWT.READ_ONLY);
		String[] items = new String[] {"BTS","Terminale","Première","Seconde"};
		comboClasse.setItems(items);
		comboClasse.setBounds(207, 182, 91, 23);
		
		//regroupement des boutons radio
		Composite compositeCantine = new Composite(shell, SWT.NONE);
		compositeCantine.setBounds(207, 197, 120, 44);
		
		Button btnOui = new Button(compositeCantine, SWT.RADIO);
		btnOui.setBounds(0, 20, 49, 16);
		btnOui.setText("Oui");
		
		Button btnNon = new Button(compositeCantine, SWT.RADIO);
		
		//récupération des données des boutons radio
		btnOui.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                    labelChoix.setText("Oui");
                }
            }
             
        });
         
        btnNon.addSelectionListener(new SelectionAdapter()  {
 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                	labelChoix.setText("Non");
                }
            }
             
        });
		btnNon.setBounds(55, 20, 49, 16);
		btnNon.setText("Non");
	      
		
		Button btnLundi = new Button(shell, SWT.CHECK);
		
		//Récupération des données des boutons checkbox
		btnLundi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                	labelLundi.setText("L ");

                }
                else {
                	labelLundi.setText("");

                }
            }
             
        });
		btnLundi.setBounds(207, 242, 55, 16);
		btnLundi.setText("Lundi");
		
		Button btnMardi = new Button(shell, SWT.CHECK);
		btnMardi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                	labelMardi.setText("Ma ");

                }
                else {
                	labelMardi.setText("");

                }
            }
             
        });
		btnMardi.setBounds(272, 241, 55, 16);
		btnMardi.setText("Mardi");
		
		Button btnMercredi = new Button(shell, SWT.CHECK);
		btnMercredi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                	labelMercredi.setText("Me ");
                }
                else {
                	labelMercredi.setText("");
                }
            }
             
        });
		btnMercredi.setBounds(334, 241, 72, 16);
		btnMercredi.setText("Mercredi");
		
		Button btnJeudi = new Button(shell, SWT.CHECK);
		btnJeudi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                	labelJeudi.setText("J ");
                }
                else {
                	labelJeudi.setText("");
                }
            }
             
        });
		btnJeudi.setBounds(412, 241, 56, 16);
		btnJeudi.setText("Jeudi");
		
		Button btnVendredi = new Button(shell, SWT.CHECK);
		btnVendredi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                	labelVendredi.setText("V ");
                }
                else {
                	labelVendredi.setText("");
                }
            }
             
        });
		btnVendredi.setBounds(468, 241, 72, 16);
		btnVendredi.setText("Vendredi");
		
		textRegime = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		textRegime.setBounds(207, 273, 178, 67);
		
		Button btnValider = new Button(shell, SWT.NONE);
		
		//évènement du bouton valider
		btnValider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//calcul du tarif
				float tarif = 0;
				if (labelLundi.getText() != "" ) {
					tarif = tarif+6;
				}
				if (labelMardi.getText() != "" ) {
					tarif = tarif+6;
				}
				if (labelMercredi.getText() != "" ) {
					tarif = tarif+6;
				}
				if (labelJeudi.getText() != "" ) {
					tarif = tarif+6;
				}
				if (labelVendredi.getText() != "" ) {
					tarif = tarif+6;
				}
				tarif = tarif*4;
				
				//mise en texte des jours
				labelJour.setText(labelLundi.getText()+labelMardi.getText()+labelMercredi.getText()+labelJeudi.getText()+labelVendredi.getText());
				
				//connexion à la bdd
				String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String user="root";
				String password="";
				
				//update des données dans la bdd
				try {
					Connection cnx = DriverManager.getConnection(url, user, password);
					PreparedStatement pstm = cnx.prepareStatement("Update etudiant set nom=?, prenom=?, classe=?, cantine=?, jour=?, regime=?, tarif=? where nom=? and prenom=?",Statement.RETURN_GENERATED_KEYS);
					pstm.setString(1, textNom.getText());
					pstm.setString(2, textPrenom.getText());
					pstm.setString(3, comboClasse.getText());
					pstm.setString(4, labelChoix.getText());
					pstm.setString(5, labelJour.getText());
					pstm.setString(6, textRegime.getText());
					pstm.setFloat(7, tarif);
					pstm.setString(8, Cnom.getText());
					pstm.setString(9, Cprenom.getText());

					pstm.executeUpdate();
					
					} catch (SQLException ee) {
						System.out.println("Une erreur est survenue lors de la connexion à la base de données");
						ee.printStackTrace();
					}
				shell.close();
			}
			
		});
		btnValider.setBounds(363, 360, 75, 25);
		btnValider.setText("Modifier");
		
		Button btnAnnuler = new Button(shell, SWT.NONE);
		btnAnnuler.setBounds(465, 360, 75, 25);
		btnAnnuler.setText("Annuler");
		
		//évènement du bouton annuler
		btnAnnuler.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});

	}
}
