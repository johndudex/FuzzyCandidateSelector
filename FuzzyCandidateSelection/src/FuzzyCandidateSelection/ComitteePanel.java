package FuzzyCandidateSelection;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Blob;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ComitteePanel extends JFrame {

	JLabel CandidateName,CandidateAadharNo,CandidateAge,CandidateState,CandidateDistrict;
	private JPanel contentPane;
	private JTable table;
	String ColumnNames[]={"Name","Adhaar No"};
	JLabel ImageLabel;
	String AdhaarNo;
	static String MemberName;
	 JButton RateBtn;
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
					ComitteePanel frame = new ComitteePanel();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComitteePanel() {
		
		
		//System.out.println(MemberName);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel Toolbar= new JPanel();
		contentPane.add(Toolbar);
		Toolbar.setBounds(0, 0, 650, 30);
		Toolbar.setLayout(null);
		Toolbar.setBackground(Color.DARK_GRAY);
		
		
		JPanel ToolbarBottom= new JPanel();
		contentPane.add(ToolbarBottom);
		ToolbarBottom.setBounds(0,442, 650, 36);
		ToolbarBottom.setLayout(null);
		ToolbarBottom.setBackground(Color.DARK_GRAY);
		
	
		JPanel TablePanel= new JPanel();
		contentPane.add(TablePanel);
		TablePanel.setBounds(0, 0, 255, 462);
		TablePanel.setLayout(null);
        TablePanel.setBackground(Color.blue);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 120, 235, 278);
        TablePanel.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
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
        
        
        DefaultTableModel model = new DefaultTableModel();
	 	
	    model.setColumnIdentifiers(ColumnNames);
	    table.setModel(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.setFillsViewportHeight(true);
	   Connection con=DataManager.getConnection();
	    String query="select name,Adhaar from candidate where "+MemberName+" =0";
	    //System.out.println(query);
	    ResultSet rs= DataManager.retrieveData(query, con);
	    try {
	    while (rs.next()) {
	 
	    String  movid = rs.getString("name");
	 
	    String  movname = rs.getString("Adhaar");
	   // String  movlang= rs.getString("LANGUAGE");
	    model.addRow(new Object[]{movid,movname});
	    }
	    } catch (SQLException ex) {
	    
	    }
	    DataManager.closeConnection(con);
        
        
        JPanel InfoPanel= new JPanel();
        InfoPanel.setBackground(Color.cyan);
        InfoPanel.setBounds(250, 30, 400, 550);
        InfoPanel.setLayout(null);
        contentPane.add(InfoPanel);
        
        
        JLabel MyName=new JLabel("Name                  :");
        MyName.setBounds(74,150,120,10);
        InfoPanel.add(MyName);
        InfoPanel.setLayout(null);
        
        CandidateName=new JLabel("");
        CandidateName.setBounds(190,150,200,15);
        InfoPanel.add(CandidateName);
        InfoPanel.setLayout(null);
        
        JLabel MyAge=new JLabel("Dob                      :");
        MyAge.setBounds(74,200,120,20);
        InfoPanel.add(MyAge);
        InfoPanel.setLayout(null);
        
        CandidateAge=new JLabel("");
        CandidateAge.setBounds(190,200,200,20);
        InfoPanel.add(CandidateAge);
        InfoPanel.setLayout(null);
        
        JLabel MyAadharNo=new JLabel("AadharNo           :");
        MyAadharNo.setBounds(74,250,120,20);
        InfoPanel.add(MyAadharNo);
        InfoPanel.setLayout(null);
        
        CandidateAadharNo=new JLabel("");
        CandidateAadharNo.setBounds(190,250,173,15);
        InfoPanel.add(CandidateAadharNo);
        InfoPanel.setLayout(null);
        
        JLabel MyState=new JLabel("State                   :");
        MyState.setBounds(74,300,120,20);
        InfoPanel.add(MyState);
        InfoPanel.setLayout(null);
        
        CandidateState=new JLabel("");
        CandidateState.setBounds(190,300,120,15);
        InfoPanel.add(CandidateState);
        InfoPanel.setLayout(null);
        
        JLabel MyDistrict=new JLabel("District                  :");
        MyDistrict.setBounds(74,350,120,20);
        InfoPanel.add(MyDistrict);
        InfoPanel.setLayout(null);
        
        CandidateDistrict=new JLabel("");
        CandidateDistrict.setBounds(190,355,120,15);
        InfoPanel.add(CandidateDistrict);
        InfoPanel.setLayout(null);
        
        ImageLabel = new JLabel("");
        ImageLabel.setBounds(113, 11, 161, 115);
        InfoPanel.add(ImageLabel);
        
        RateBtn = new JButton("Rate this Candidate");
        RateBtn.setBounds(124, 381, 151, 23);
        InfoPanel.add(RateBtn);
        RateBtn.setVisible(false);
        
        RateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Rating.AdhaarNo=AdhaarNo;
				Rating.Member=MemberName;
				Rating rating =new Rating();
				rating.setVisible(true);
				dispose();
			}
		});
        
        table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRow = table.getSelectedRow();
				CandidateName.setText(table.getValueAt(selectedRow, 0).toString());
				CandidateAadharNo.setText(table.getValueAt(selectedRow, 1).toString());
				AdhaarNo=table.getValueAt(selectedRow, 1).toString();
				
				Connection con=DataManager.getConnection();
				String query="select dob,state,district,image from candidate where Adhaar= '" +AdhaarNo +"'";
				
				
				
				ResultSet rs= DataManager.retrieveData(query, con);
				try {
					while(rs.next())
					{
						CandidateAge.setText(rs.getString(1));
						CandidateState.setText(rs.getString(2));
						CandidateDistrict.setText(rs.getString(3));
						
						// setting the image to an icon 
						Blob imageData = (Blob) rs.getBlob("Image");

						if( imageData != null )
						{
						try 
						{
						File tmpFile = new File("tmpImage");
						FileOutputStream fos = new FileOutputStream(tmpFile);
						fos.write( imageData.getBytes(1L, (int)imageData.length()) );
						fos.close();
						String ss=tmpFile.getAbsolutePath();
						ImageLabel.setIcon(ResizeImage(ss)); 
						RateBtn.setVisible(true);
						//ImageIcon icon = new ImageIcon(ImageIO.read(tmpFile) ); 
						// JOptionPane.showMessageDialog(null, icon);
						// tmpFile.deleteOnExit();


						}
						catch(IOException ioe)
						{
						ioe.printStackTrace();
						JOptionPane.showMessageDialog(null, "Failed To Load Image Data", "Load Error", JOptionPane.ERROR_MESSAGE); 
						} 
						}
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}

			private ImageIcon ResizeImage(String imgPath) {
				ImageIcon MyImage = new ImageIcon(imgPath);
				Image img = MyImage.getImage();
				Image newImage = img.getScaledInstance(ImageLabel.getWidth(), ImageLabel.getHeight(),Image.SCALE_SMOOTH); ImageIcon image = new ImageIcon(newImage); 
				return image;
			}
		});
        
        
        



        
        
        
        
        
        
        
	}
}
