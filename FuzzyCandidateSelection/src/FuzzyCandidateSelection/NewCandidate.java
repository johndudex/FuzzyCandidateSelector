package FuzzyCandidateSelection;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;



public class NewCandidate extends JFrame {

	private JPanel contentPane;
	JTextField Name,Age,Adhaar,Religion,State,District;
	//JDatePicker Dob;
	String imagePath;
	JButton Upload=new JButton("Upload");
	static NewCandidate frm;
	static JLabel StatusBotton=new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		        	
		        	 UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");

		        	
		            break;
		        }
		    }
		} catch (Exception e) {
			 
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCandidate frame = new NewCandidate();
					frame.setVisible(true);
					frame.setResizable(false);
					frm=frame;
					frame.addWindowStateListener(new WindowStateListener() {
						
						@Override
						public void windowStateChanged(WindowEvent e) {
							// TODO Auto-generated method stub
							frm.setBounds(100, 100, 750, 500);
							frm.setResizable(false);
						}
					});
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**(
	 * Create the frame.
	 */
	public NewCandidate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JPanel Toolbar=new JPanel();
		Toolbar.setBounds(0,0,750,50);
		Toolbar.setBackground(Color.darkGray);
		
		contentPane.add(Upload);
		Upload.setBounds(500,240,100,20);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.CYAN);		
		
		
		
		
		JLabel MyName=new JLabel("Name");
		MyName.setBounds(30,90,100,20);
		contentPane.add(Toolbar);
		contentPane.add(MyName);
		Name =new JTextField();
		contentPane.add(Name);
		Name.setBounds(200,90,150,30);
		
		
	    JLabel MyName1=new JLabel("Dob");
	    MyName1.setBounds(30,140,100,20);
	    contentPane.add(Toolbar);
        contentPane.add(MyName1);
        Age =new JTextField();
		contentPane.add(Age);
		Age.setBounds(200,140,150,30);
 		
        
        JLabel MyName2=new JLabel("Adhar No");
	    MyName2.setBounds(30,190,100,20);
	    contentPane.add(Toolbar);
        contentPane.add(MyName2);
        Adhaar =new JTextField();
		contentPane.add(Adhaar);
		Adhaar.setBounds(200,190,150,30);
 		
        JLabel MyName3=new JLabel("Religion");
	    MyName3.setBounds(30,240,100,20);
	    contentPane.add(Toolbar);
        contentPane.add(MyName3);
        Religion =new JTextField();
		contentPane.add(Religion);
		Religion.setBounds(200,240,150,30);
        
        JLabel MyName4=new JLabel("State");
	    MyName4.setBounds(30,290,100,20);
	    contentPane.add(Toolbar);
        contentPane.add(MyName4);
        State =new JTextField();
		contentPane.add(State);
		State.setBounds(200,290,150,30);
 		
        JLabel MyName5=new JLabel("District");
	    MyName5.setBounds(30,340,100,20);
	    contentPane.add(Toolbar);
        contentPane.add(MyName5);
        District =new JTextField();
		contentPane.add(District);
		District.setBounds(200,340,150,30);
 		
		
        JPanel ToolbarBottom=new JPanel();
		ToolbarBottom.setBounds(0,430,750,50);
		ToolbarBottom.setLayout(null);
		contentPane.setBackground(Color.CYAN);		
		contentPane.add(ToolbarBottom);
		ToolbarBottom.setBackground(Color.darkGray);
		
		StatusBotton.setBounds(10,5,100, 20);
		StatusBotton.setForeground(Color.WHITE);
		ToolbarBottom.add(StatusBotton);
		
		final JLabel ImageLabel = new JLabel("");
		ImageLabel.setBounds(473, 99, 150, 130);
		ImageLabel.setBorder(BorderFactory.createLineBorder(Color.black)); 
		contentPane.add(ImageLabel);
		
		
		JButton SubmitButton=new JButton("Submit");
		SubmitButton.setBounds(350, 10, 70, 20);
		ToolbarBottom.add(SubmitButton);
		
		SubmitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String temp=Adhaar.getText().trim();	
				if(!Name.getText().isEmpty())
					if(DataManager.IsValidDate(Age.getText().trim()))
						if(temp.length()==12)
							if(!Religion.getText().isEmpty())
								if(!State.getText().isEmpty()||!State.getText().isEmpty())
									try {
										if(imagePath!=null){
										int dialogResult = JOptionPane.showConfirmDialog (frm, "Are you sure you want to save the details","Warning",JOptionPane.YES_NO_OPTION);
										if(dialogResult == JOptionPane.YES_OPTION){
										EnterCandidateDetails();
										}}
										else 
											JOptionPane.showMessageDialog(frm, "Please upload an image and try again");

									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								else
									JOptionPane.showMessageDialog(frm, "Enter your State and District correctly");
							else
								JOptionPane.showMessageDialog(frm, "Enter the correct Religion");
							
						else
							JOptionPane.showMessageDialog(frm, "Adhaar Number Invalid");
					else 
						JOptionPane.showMessageDialog(frm, "The Entered Date is not valid (DD/MM/YY)");
					else
						JOptionPane.showMessageDialog(frm, "You have not entered the Name");
			}

			private void EnterCandidateDetails() throws FileNotFoundException, SQLException {
		Connection con=DataManager.getConnection();
		InputStream is = new FileInputStream(new File(imagePath));
		PreparedStatement ps = con.prepareStatement("insert into Candidate(Name,Dob,Adhaar,Religion,State,District,Image) values(?,?,?,?,?,?,?)");
		ps.setString(1,Name.getText().trim());
		ps.setString(2,Age.getText().trim());
		ps.setString(3,Adhaar.getText().trim());
		ps.setString(4,Religion.getText().trim());
		ps.setString(5,State.getText().trim());
		ps.setString(6,District.getText().trim());
		ps.setBlob(7,is);
		System.out.println(is);
		try{
		ps.executeUpdate();		
		JOptionPane.showMessageDialog(frm, "Candidate Successfully entered");
		}catch(SQLIntegrityConstraintViolationException e){
			JOptionPane.showMessageDialog(frm, "Entered data already exists");
		}
		
		
			}
		});
		
 		
		Upload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png"); 
				fileChooser.addChoosableFileFilter(filter); 
				int result = fileChooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath(); 
					ImageLabel.setIcon(ResizeImage(path)); 
					imagePath = path; 
				}
				else if(result == JFileChooser.CANCEL_OPTION)
				{
					StatusBotton.setText("The Selected file doesnt appear to be an image please try again !");
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
