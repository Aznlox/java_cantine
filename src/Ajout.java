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
		
		Label labelChoix = new Label(shell, SWT.NONE);
		labelChoix.setEnabled(false);
		labelChoix.setVisible(false);
		labelChoix.setBounds(351, 151, 55, 15);
		
		Label labelJour = new Label(shell, SWT.NONE);
		labelJour.setEnabled(false);
		labelJour.setVisible(false);
		labelJour.setBounds(468, 261, 55, 15);
		
		Label labelLundi = new Label(shell, SWT.NONE);
		labelLundi.setEnabled(false);
		labelLundi.setVisible(false);
		labelLundi.setBounds(391, 209, 55, 15);
		
		Label labelMardi = new Label(shell, SWT.NONE);
		labelMardi.setEnabled(false);
		labelMardi.setVisible(false);
		labelMardi.setBounds(452, 209, 55, 15);
		
		Label labelMercredi = new Label(shell, SWT.NONE);
		labelMercredi.setEnabled(false);
		labelMercredi.setVisible(false);
		labelMercredi.setBounds(391, 230, 55, 15);
		
		Label labelJeudi = new Label(shell, SWT.NONE);
		labelJeudi.setEnabled(false);
		labelJeudi.setVisible(false);
		labelJeudi.setBounds(452, 230, 55, 15);
		
		Label labelVendredi = new Label(shell, SWT.NONE);
		labelVendredi.setEnabled(false);
		labelVendredi.setVisible(false);
		labelVendredi.setBounds(391, 251, 55, 15);
		
		textNom = new Text(shell, SWT.BORDER);
		textNom.setBounds(207, 60, 91, 21);
		
		textPrenom = new Text(shell, SWT.BORDER);
		textPrenom.setBounds(207, 89, 91, 21);
		
		Combo comboClasse = new Combo(shell, SWT.READ_ONLY);
		String[] items = new String[] {"BTS","Terminale","Première","Seconde"};
		comboClasse.setItems(items);
		comboClasse.setBounds(207, 118, 91, 23);
		
		Composite compositeCantine = new Composite(shell, SWT.NONE);
		compositeCantine.setBounds(207, 133, 120, 44);
		
		Button btnOui = new Button(compositeCantine, SWT.RADIO);
		btnOui.setBounds(0, 20, 49, 16);
		btnOui.setText("Oui");
		
		Button btnNon = new Button(compositeCantine, SWT.RADIO);
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
		btnLundi.setBounds(207, 178, 55, 16);
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
		btnMardi.setBounds(272, 177, 55, 16);
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
		btnMercredi.setBounds(334, 177, 72, 16);
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
		btnJeudi.setBounds(412, 177, 56, 16);
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
		btnVendredi.setBounds(468, 177, 72, 16);
		btnVendredi.setText("Vendredi");
		
		textRegime = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		textRegime.setBounds(207, 209, 178, 67);
		
		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				labelJour.setText(labelLundi.getText()+labelMardi.getText()+labelMercredi.getText()+labelJeudi.getText()+labelVendredi.getText());
				String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String user="root";
				String password="";
				try {
					Connection cnx = DriverManager.getConnection(url, user, password);
					PreparedStatement pstm = cnx.prepareStatement("Insert into etudiant (nom, prenom, classe, cantine, jour, regime) Value(?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
					pstm.setString(1, textNom.getText());
					pstm.setString(2, textNom.getText());
					pstm.setString(3, comboClasse.getText());
					pstm.setString(4, labelChoix.getText());
					pstm.setString(5, labelJour.getText());
					pstm.setString(6, textRegime.getText());

					pstm.executeUpdate();
					
					} catch (SQLException ee) {
						System.out.println("Une erreur est survenue lors de la connexion à la base de données");
						ee.printStackTrace();
					}
				shell.close();
			}
			
		});
		btnValider.setBounds(363, 296, 75, 25);
		btnValider.setText("Ajouter");
		
		Button btnAnnuler = new Button(shell, SWT.NONE);
		btnAnnuler.setBounds(465, 296, 75, 25);
		btnAnnuler.setText("Annuler");
		
		
		
			
		btnAnnuler.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});

	}
}
