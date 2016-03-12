package FuzzyCandidateSelection;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TableTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		        	


		        	 UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableTest frame = new TableTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setBackground(new java.awt.Color(0, 204, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 109, 378, 255);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {},
	                {},
	                {},
	                {}
	            },
	            new String [] {

	            }
	        ));
		
		scrollPane.setViewportView(table);
		
		 DefaultTableModel model = new DefaultTableModel();
		 	String columnNames[]={"name","dob"};
		    model.setColumnIdentifiers(columnNames);
		    table.setModel(model);
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    table.setFillsViewportHeight(true);
		   Connection con=DataManager.getConnection();
		    String query="select name,dob from candidate";
		    ResultSet rs= DataManager.retrieveData(query, con);
		    try {
		    while (rs.next()) {
		 
		    String  movid = rs.getString("name");
		 
		    String  movname = rs.getString("dob");
		   // String  movlang= rs.getString("LANGUAGE");
		    model.addRow(new Object[]{movid,movname});
		    }
		    } catch (SQLException ex) {
		    
		    }
		    DataManager.closeConnection(con);
		
		
	}
}
