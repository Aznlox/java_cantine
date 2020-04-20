import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;

public class cantine_etudiant {

	protected Shell shlCantinetudiant;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			cantine_etudiant window = new cantine_etudiant();
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
		insertTable();
		shlCantinetudiant.open();
		shlCantinetudiant.layout();
		while (!shlCantinetudiant.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCantinetudiant = new Shell();
		shlCantinetudiant.setSize(884, 737);
		shlCantinetudiant.setText("Cantine \u00E9tudiant");
		
		Button btnAjout = new Button(shlCantinetudiant, SWT.NONE);
		btnAjout.setBounds(50, 576, 204, 35);
		btnAjout.setText("Ajouter un \u00E9tudiant");
		
		btnAjout.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   
				   Ajout Ajouter = new Ajout();
				   Ajouter.open();
					table.removeAll();
				    String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
					String user="root";
					String password="";
					try {
						Connection cnx = DriverManager.getConnection(url, user, password);
						Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = stm.executeQuery("select * from etudiant");
						java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				        int columnsNumber = rsmd.getColumnCount();

				        TableItem item;
				        while (rs.next()) {
				            item = new TableItem(table, SWT.NONE);
				            for (int i = 1; i <= columnsNumber; i++) {            
				                item.setText(i - 1, rs.getString(i));
				            }
				        }
					} catch (SQLException e) {
						System.out.println("Une erreur est survenue lors de la connexion à la base de données");
						e.printStackTrace();
					}
				   
			   }
		});
		
		Button btnModif = new Button(shlCantinetudiant, SWT.NONE);
		btnModif.setBounds(470, 576, 204, 35);
		btnModif.setText("Modifier un \u00E9tudiant");
		
		Button btnSuppr = new Button(shlCantinetudiant, SWT.NONE);
		btnSuppr.setBounds(260, 576, 204, 35);
		btnSuppr.setText("Supprimer un \u00E9tudiant");
		
		btnSuppr.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   
				   
				   table.removeAll();
				   String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				   String user="root";
				   String password="";
				   try {
					   Connection cnx = DriverManager.getConnection(url, user, password);
					   Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					   ResultSet rs = stm.executeQuery("select * from etudiant");
					   java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					   int columnsNumber = rsmd.getColumnCount();

				       TableItem item;
				       while (rs.next()) {
				           item = new TableItem(table, SWT.NONE);
				           for (int i = 1; i <= columnsNumber; i++) {            
				               item.setText(i - 1, rs.getString(i));
				           }
				       }
				   } catch (SQLException e) {
					   System.out.println("Une erreur est survenue lors de la connexion à la base de données");
					   e.printStackTrace();
				   }
				   
			  }
		});
		
		
		table = new Table(shlCantinetudiant, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(50, 100, 613, 440);
		
		
		TableColumn tblclmnNom = new TableColumn(table, SWT.CENTER);
		tblclmnNom.setResizable(false);
		tblclmnNom.setWidth(100);
		tblclmnNom.setText("Nom");
		
		TableColumn tblclmnPrnom = new TableColumn(table, SWT.NONE);
		tblclmnPrnom.setWidth(100);
		tblclmnPrnom.setText("Pr\u00E9nom");
		
		TableColumn tblclmnClasse = new TableColumn(table, SWT.NONE);
		tblclmnClasse.setWidth(100);
		tblclmnClasse.setText("Classe");
		
		TableColumn tblclmnCantine = new TableColumn(table, SWT.NONE);
		tblclmnCantine.setWidth(82);
		tblclmnCantine.setText("Cantine");
		
		TableColumn tblclmnJour = new TableColumn(table, SWT.NONE);
		tblclmnJour.setWidth(100);
		tblclmnJour.setText("Jour");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(126);
		tblclmnNewColumn_1.setText("R\u00E9gime alimentaire");
		
		Button btnTrinom = new Button(shlCantinetudiant, SWT.NONE);
		btnTrinom.setBounds(67, 43, 122, 35);
		btnTrinom.setText("Trier par nom");
		btnTrinom.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   	table.removeAll();
				    String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
					String user="root";
					String password="";
					try {
						Connection cnx = DriverManager.getConnection(url, user, password);
						Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = stm.executeQuery("select * from etudiant order by upper(nom)");
						java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				        int columnsNumber = rsmd.getColumnCount();

				        TableItem item;
				        while (rs.next()) {
				            item = new TableItem(table, SWT.NONE);
				            for (int i = 1; i <= columnsNumber; i++) {            
				                item.setText(i - 1, rs.getString(i));
				            }
				        }
					} catch (SQLException e) {
						System.out.println("Une erreur est survenue lors de la connexion à la base de données");
						e.printStackTrace();
					}
			   }
		});
		
		Button btnTriclasse = new Button(shlCantinetudiant, SWT.NONE);
		btnTriclasse.setBounds(267, 43, 148, 35);
		btnTriclasse.setText("Trier par classe");
		btnTriclasse.addSelectionListener(new SelectionAdapter() {
			 
			   @Override
			   public void widgetSelected(SelectionEvent arg0) {
				   	table.removeAll();
				    String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
					String user="root";
					String password="";
					try {
						Connection cnx = DriverManager.getConnection(url, user, password);
						Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = stm.executeQuery("select * from etudiant order by classe desc");
						java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				        int columnsNumber = rsmd.getColumnCount();

				        TableItem item;
				        while (rs.next()) {
				            item = new TableItem(table, SWT.NONE);
				            for (int i = 1; i <= columnsNumber; i++) {            
				                item.setText(i - 1, rs.getString(i));
				            }
				        }
					} catch (SQLException e) {
						System.out.println("Une erreur est survenue lors de la connexion à la base de données");
						e.printStackTrace();
					}
			   }
		});
		
		Label lblTotal = new Label(shlCantinetudiant, SWT.NONE);
		lblTotal.setBounds(693, 546, 209, 52);
		lblTotal.setText("Total du mois :");

	}
	
	protected void insertTable() {
		table.clearAll();
		String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user="root";
		String password="";
		try {
			Connection cnx = DriverManager.getConnection(url, user, password);
			Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery("select * from etudiant");
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	        int columnsNumber = rsmd.getColumnCount();

	        TableItem item;
	        while (rs.next()) {
	            item = new TableItem(table, SWT.NONE);
	            for (int i = 1; i <= columnsNumber; i++) {            
	                item.setText(i - 1, rs.getString(i));
	            }
	        }
		} catch (SQLException e) {
			System.out.println("Une erreur est survenue lors de la connexion à la base de données");
			e.printStackTrace();
		}
	}
}
