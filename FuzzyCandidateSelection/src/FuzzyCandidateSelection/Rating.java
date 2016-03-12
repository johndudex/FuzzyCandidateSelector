package FuzzyCandidateSelection;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

public class Rating extends JFrame {

	private JPanel contentPane;
	JPanel Panel1;
	JPanel Panel2;
	JPanel Panel3;
	JPanel Panel4;
	JPanel Toolbar;
	JPanel ToolbarBottom;
	static Rating Frm,frm;
	
	static String Member="";
	static String AdhaarNo="";
	public JTextField Text[]=new JTextField[22];
	int N[]=new int[22];
	
	String Query="";
	
	
	
	JButton Submit=new JButton("Submit");
	
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
					Rating frame = new Rating();
					Frm=frame;
					frm=Frm;
					frame.setTitle("Rating Candidates");
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
	public Rating() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,00, 800, 700);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setBackground(Color.blue);
		DrawToolBar();
		
		System.out.print(AdhaarNo);
		
		Panel_function1();
		Panel_function2();
		Panel_function3();
		Panel_function4();
		
		//contentPane.add(Submit);
		
		Submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int flag=0,flag1=0,NaN=0;
				Query="";
				for(int i=1;i<=21;i++)
				{
					if(Text[i].getText().isEmpty())
						flag1=1;
				}
				if(flag1==0){

					try{
					for(int i=1;i<=21;i++)
					N[i]=Integer.parseInt(Text[i].getText().trim());
					}catch (NumberFormatException nfe)
					{
					NaN=1;	
					}
				if(NaN==0){
				
				for(int i=1;i<=21;i++)
					if(N[i]<1 ||N[i]>5)
					{
						Text[i].setText("");
						flag=1;
					}
				if(flag==1)
					JOptionPane.showMessageDialog(Frm, "Entry Out of Range (1-5)");
				else
				{
					int dialogResult = JOptionPane.showConfirmDialog (Frm, "Are you sure you want to save the details","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
					int i;
					int count =0;
					for(i=1;i<21;i++){
						Query=Query+Text[i].getText().trim()+",";
						count++;
					
					}
					Query=Query+Text[i].getText().trim()+",'"+AdhaarNo+"'";
					count++;
					//System.out.println(Query);
					Connection con=DataManager.getConnection();
					String name="select *from administrator";
					boolean fl=DataManager.updateData("insert into rating values("+Query+")", con);
					if(fl)
						JOptionPane.showMessageDialog(Frm, "Inserted Succesfully");
					DataManager.updateData("update candidate set "+Member+"= 1 where Adhaar= '"+AdhaarNo+"'", con);
					DataManager.closeConnection(con);
					dispose();
					}
				}
				}
				else 
					JOptionPane.showMessageDialog(Frm, "Some of the values entered are not a number");
				}
				else
					JOptionPane.showMessageDialog(Frm, "All entries are not filled");
			}
			
		});
		
	}

	private void DrawToolBar() {
		// TODO Auto-generated method stub
		Toolbar=new JPanel();
		contentPane.add(Toolbar);
		Toolbar.setLayout(null);
		Toolbar.setBackground(Color.darkGray);
		Toolbar.setBounds(0, 0, 1250, 50);
		
		
		ToolbarBottom=new JPanel();
		contentPane.add(ToolbarBottom);
		ToolbarBottom.setLayout(null);
		ToolbarBottom.setBackground(Color.darkGray);
		ToolbarBottom.setBackground(Color.darkGray);
		ToolbarBottom.setBounds(0, 600, 800,100);
		ToolbarBottom.add(Submit);
		Submit.setBounds(350,10,75 ,20);
	}

	private void Panel_function4() {
		// TODO Auto-generated method stub
		Panel4=new JPanel();
		Panel4.setLayout(null);
		contentPane.add(Panel4);
		
		Panel4.setBounds(400,300,400, 300);
		Panel4.setBackground(Color.cyan);
		JLabel Label16=new JLabel("No prior criminal activities");
		Panel4.add(Label16);
		Label16.setBounds(30,30,250,20);
		Text[16]=new JTextField();
		Panel4.add(Text[16]);
		Text[16].setBounds(310,30,25,25);
		
		JLabel Label17=new JLabel("Sub-Identity notion");
		Panel4.add(Label17);
		Label17.setBounds(30,70,250,20);
        Text[17]=new JTextField();
		Panel4.add(Text[17]);
		Text[17].setBounds(310,70,25,25);

		
		JLabel Label18=new JLabel("Adoptability to party's mission ");
		Panel4.add(Label18);
		Label18.setBounds(30,110,250,20);
	    Text[18]=new JTextField();
		Panel4.add(Text[18]);
		Text[18].setBounds(310,110,25,25);
	
		
		
		JLabel Label19=new JLabel("Being in harmony with political party");
		Panel4.add(Label19);
		Label19.setBounds(30,150,250,20);
	    Text[19]=new JTextField();
		Panel4.add(Text[19]);
		Text[19].setBounds(310,150,25,25);
	
		
		
		JLabel Label20=new JLabel("Previous achievements in party tasks");
		Panel4.add(Label20);
		Label20.setBounds(30,190,250,20);
	    Text[20]=new JTextField();
		Panel4.add(Text[20]);
		Text[20].setBounds(310,190,25,25);
	
		
		
		JLabel Label21=new JLabel("Experience in grassroots projects");
		Panel4.add(Label21);
		Label21.setBounds(30,230,250,20);
	    Text[21]=new JTextField();
		Panel4.add(Text[21]);
		Text[21].setBounds(310,230,25,25);
	
		
	}

	private void Panel_function3() {
		// TODO Auto-generated method stub
		Panel3=new JPanel();
		Panel3.setLayout(null);
		contentPane.add(Panel3);
		Panel3.setBackground(Color.cyan);
		Panel3.setBounds(0,300,400,300);
		
		
		
		JLabel Label11=new JLabel("Adding Value to urban Developments");
		Panel3.add(Label11);
		Label11.setBounds(30,30,250,20);
		
		 Text[11]=new JTextField();
		Panel3.add(Text[11]);
		Text[11].setBounds(310,30, 25,25);
		//Text11.setVisible(true);

		
		
		JLabel Label12=new JLabel("Positive Relationship with City Personels");
		Panel3.add(Label12);
		Label12.setBounds(30,70,250,20);
		
		 Text[12]=new JTextField();
		Panel3.add(Text[12]);
		Text[12].setBounds(310, 70, 25,25);
		
		
		JLabel Label13=new JLabel("Positive Relationship with City Personels");
		Panel3.add(Label13);
		Label13.setBounds(30,110,250,20);
		
		 Text[13]=new JTextField();
		Panel3.add(Text[13]);
		Text[13].setBounds(310, 110, 25,25);
		
		JLabel Label14=new JLabel("Knowledge about urban problems");
		Panel3.add(Label14);
		Label14.setBounds(30,150,250,20);
		
		 Text[14]=new JTextField();
		Panel3.add(Text[14]);
		Text[14].setBounds(310, 150, 25,25);
		
		
		JLabel Label15=new JLabel("using resources efficiently and economically");
		Panel3.add(Label15);
		Label15.setBounds(30,190,250,20);
		
		 Text[15]=new JTextField();
		Panel3.add(Text[15]);
		Text[15].setBounds(310, 190, 25,25);
		
	}

	private void Panel_function2() {
		// TODO Auto-generated method stub
		Panel2=new JPanel();
		Panel2.setLayout(null);
		contentPane.add(Panel2);
		Panel2.setBackground(Color.cyan);
		Panel2.setBounds(400,0,400,300);
		
		
		JLabel Label6=new JLabel("Powerful and Technical team");
		Panel2.add(Label6);
		Label6.setBounds(30,70, 250, 20);
		
	    Text[6]=new JTextField();
		Panel2.add(Text[6]);
		Text[6].setBounds(305, 70, 25,25);
		
		
		
		JLabel Label7=new JLabel("Possessing municipality mission");
		Panel2.add(Label7);
		Label7.setBounds(30,120, 250, 20);
		
	    Text[7]=new JTextField();
		Panel2.add(Text[7]);
		Text[7].setBounds(305, 120, 25,25);
		
		JLabel Label8=new JLabel("Ability to work and coordinate with NGO's");
		Panel2.add(Label8);
		Label8.setBounds(30,170, 250, 20);
		
		Text[8]=new JTextField();
		Panel2.add(Text[8]);
		Text[8].setBounds(305, 170, 25,25);
		
		JLabel Label9=new JLabel("Educational Background");
		Panel2.add(Label9);
		Label9.setBounds(30,220, 250, 20);
		
		Text[9]=new JTextField();
		Panel2.add(Text[9]);
		Text[9].setBounds(305, 220, 25,25);
		
		JLabel Label10=new JLabel("Taking part as sponsors in urban projects");
		Panel2.add(Label10);
		Label10.setBounds(30,270, 250, 20);
		
		Text[10]=new JTextField();
		Panel2.add(Text[10]);
		Text[10].setBounds(305, 270, 25,25);
		
	}

	private void Panel_function1() {
		// TODO Auto-generated method stub
		Panel1=new JPanel();
		Panel1.setLayout(null);
		contentPane.add(Panel1);
		Panel1.setBounds(0,0,400, 300);
		Panel1.setBackground(Color.cyan);
		
		JLabel Label1=new JLabel("Communication skills");
		Panel1.add(Label1);
		Label1.setBounds(30,70, 250, 20);
		
		Text[1]=new JTextField();
		Panel1.add(Text[1]);
		Text[1].setBounds(305, 70, 25,25);
		
		JLabel Label2=new JLabel("Positive influence on people");
		Panel1.add(Label2);
		Label2.setBounds(30,120, 250, 20);
		
		Text[2]=new JTextField();
		Panel1.add(Text[2]);
		Text[2].setBounds(305, 120, 25,25);
		
		JLabel Label3=new JLabel("Leadership and Persuasion skills");
		Panel1.add(Label3);
		Label3.setBounds(30,170, 250, 20);
		
		Text[3]=new JTextField();
		Panel1.add(Text[3]);
		Text[3].setBounds(305, 170, 25,25);
		
		JLabel Label4=new JLabel("Motivation capability and durability");
		Panel1.add(Label4);
		Label4.setBounds(30,220, 250, 20);
		
		Text[4]=new JTextField();
		Panel1.add(Text[4]);
		Text[4].setBounds(305, 220, 25,25);
		
		JLabel Label5=new JLabel("Knowledge level about global issues");
		Panel1.add(Label5);
		Label5.setBounds(30,270, 250, 20);
		
		Text[5]=new JTextField();
		Panel1.add(Text[5]);
		Text[5].setBounds(305, 270, 25,25);
		
		
		
	}

}
