package FuzzyCandidateSelection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

public class LoginScreen extends JFrame {
//
	private JPanel contentPane;
	JRadioButton adm=new JRadioButton("Admininstrator");
	JRadioButton comm=new JRadioButton("Rating Committee");
	ButtonGroup loginGroup=new ButtonGroup();
	JLabel Status=new JLabel("");
	

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
					LoginScreen frame = new LoginScreen();
					frame.getContentPane().setLayout(null);
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
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel MainPanel=new JPanel();
		MainPanel.setBackground(Color.BLUE);
		MainPanel.setLayout(null);
		MainPanel.setBounds(0, 0, 700, 400);
		JPanel LoginPanel=new JPanel();
		LoginPanel.setLayout(null);
		LoginPanel.setBackground(Color.CYAN);
		LoginPanel.setBounds(125, 150, 375, 150);
		LoginPanel.setVisible(true);
		LoginPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(MainPanel);
		MainPanel.add(LoginPanel);
		JLabel Heading=new JLabel("Fuzzy Chooser Login");
		MainPanel.add(Heading);
		Heading.setBounds(250,120,200,20);
		final JLabel Usrname =new JLabel("User Name");
		Usrname.setBounds(30,10,70,20);
		LoginPanel.add(Usrname);
		
		final JTextField Username =new JTextField();
		Username.setBounds(120,10,170,30);
		LoginPanel.add(Username);
		
		final JPasswordField Password =new JPasswordField();
		Password.setBounds(120,50,170,30);
		
		LoginPanel.add(Password);
		
		JLabel Passwrd =new JLabel("Password");
		Passwrd.setBounds(30,50,70,20);
		LoginPanel.add(Passwrd);
		JButton LoginSubmit=new JButton("LOGIN");
		LoginSubmit.setBackground(Color.CYAN);
		LoginSubmit.setBounds(275, 125, 70,20 );
		LoginPanel.add(LoginSubmit);
			
		
		loginGroup.add(adm);
		loginGroup.add(comm);
		adm.setBackground(Color.CYAN);
		LoginPanel.add(adm);
		comm.setBackground(Color.CYAN);
		LoginPanel.add(comm);
		adm.setEnabled(true);
		adm.setBounds(10,90,155,20);
		adm.setSelected(true);
		Status.setBounds(10, 330, 300, 20);
		//Status.setText("hello");
		MainPanel.add(Status);
		comm.setBounds(220,90,149,20);
		
		
		LoginSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				final String Pass=Password.getText().trim();
				final String Uname=Username.getText().trim();
				
				try {
					if(adm.isSelected())
					ValidateAdmin(Uname,Pass,1);
					else 
					ValidateAdmin(Uname, Pass,0);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
			}

			private void ValidateAdmin(String Uname,String Pass,int Auth) throws SQLException {
				// TODO Auto-generated method stub
				String Type="";
				if(Auth==1)
					Type="adm";
				else
					Type="com";
				int flag=0;
				Connection con=DataManager.getConnection();
				String name="select *from authenticate where username='"+Uname+"'";
				ResultSet rs=DataManager.retrieveData(name, con);
				while(rs.next())
				{
					if(rs.getString(2).equals(Pass) && rs.getString(3).equals(Type)){
						Status.setText("matched");
						flag=1;
						Password.setText(null);
						if(Auth==0){
							ComitteePanel.MemberName=rs.getString(1);
							ComitteePanel cm=new ComitteePanel();
							cm.setVisible(true);
							dispose();
							
						}
					}
					
				}
				if(flag==0){
					if(Auth==1)
					Status.setText("You are not a valid Administrator");
					else
					Status.setText("you are not a Valid Rating Member");
				}
			}
		});
		
	}

}
