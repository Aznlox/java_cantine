import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;

public class cantine_prof {

	protected Shell shlCantineprof;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			cantine_prof window = new cantine_prof();
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
		shlCantineprof.open();
		shlCantineprof.layout();
		while (!shlCantineprof.isDisposed()) {
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
		shlCantineprof = new Shell();
		shlCantineprof.setSize(869, 639);
		shlCantineprof.setText("Cantine professeur");
		
		//création des labels
		Label lblTotal = new Label(shlCantineprof, SWT.NONE);
		lblTotal.setBounds(666, 507, 86, 15);
		lblTotal.setText("Total du mois :");
		
		Label lblTarif = new Label(shlCantineprof, SWT.NONE);
		lblTarif.setBounds(758, 507, 73, 15);
		
		//setup du tableau
		table = new Table(shlCantineprof, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(58, 61, 611, 440);
		
		
		TableColumn tblclmnNom = new TableColumn(table, SWT.CENTER);
		tblclmnNom.setResizable(false);
		tblclmnNom.setWidth(100);
		tblclmnNom.setText("Nom");
		
		TableColumn tblclmnPrnom = new TableColumn(table, SWT.NONE);
		tblclmnPrnom.setWidth(100);
		tblclmnPrnom.setText("Pr\u00E9nom");
		
		TableColumn tblclmnCantine = new TableColumn(table, SWT.NONE);
		tblclmnCantine.setWidth(82);
		tblclmnCantine.setText("Cantine");
		
		TableColumn tblclmnJour = new TableColumn(table, SWT.NONE);
		tblclmnJour.setWidth(100);
		tblclmnJour.setText("Jour");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(126);
		tblclmnNewColumn_1.setText("R\u00E9gime alimentaire");
		
		TableColumn tblclmnTarif = new TableColumn(table, SWT.NONE);
		tblclmnTarif.setWidth(100);
		tblclmnTarif.setText("Tarif");
		
		
		
		//calcul et affichage tarif total
		String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user="root";
		String password="";
		try {
			Connection cnx = DriverManager.getConnection(url, user, password);
			Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery("select sum(tarif) from professeur");
			rs.next();
			lblTarif.setText(rs.getString(1)+" €");
	        
		} catch (SQLException e) {
			System.out.println("Une erreur est survenue lors de la connexion à la base de données");
			e.printStackTrace();
		}
		
		

	}
	
	//méthode pour inséré les données de la bdd dans le tableau
	protected void insertTable() {
		table.removeAll();
		String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user="root";
		String password="";
		try {
			Connection cnx = DriverManager.getConnection(url, user, password);
			Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery("select * from professeur");
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
