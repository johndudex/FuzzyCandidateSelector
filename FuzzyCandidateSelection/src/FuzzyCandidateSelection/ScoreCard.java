package FuzzyCandidateSelection;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ScoreCard extends JFrame {

	private JPanel contentPane;
	JTextField Text[]=new JTextField[22];
	JTextField Text1[]=new JTextField[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreCard frame = new ScoreCard();
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
	public ScoreCard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel newPanel= new JPanel();
		newPanel.setBounds(50, 50, 350, 150);
		contentPane.setBackground(Color.cyan);
		contentPane.setLayout(null);
		
		JPanel Toolbar= new JPanel();
		contentPane.add(Toolbar);
		Toolbar.setBounds(0, 0, 900, 30);
		Toolbar.setLayout(null);
		Toolbar.setBackground(Color.gray);
		
		
		JPanel ToolbarBottom= new JPanel();
		contentPane.add(ToolbarBottom);
		ToolbarBottom.setBounds(0,665, 900, 30);
		ToolbarBottom.setLayout(null);
		ToolbarBottom.setBackground(Color.gray);
		
		JButton submit=new JButton("Submit");
		ToolbarBottom.add(submit);
		submit.setBounds(415,0,100,30);
		
		
		JLabel HumanSkills=new JLabel("<html><b><u>HUMAN SKILLS AND QUALIFICATIONS:</html>");
		HumanSkills.setFont(new Font("Serif", Font.PLAIN, 16));
		HumanSkills.setBounds(20,50,310,20);
        contentPane.add(HumanSkills);
        contentPane.setLayout(null);
        
        Text1[0]=new JTextField();
		contentPane.add(Text1[0]);
		Text1[0].setBounds(350, 50, 30, 20);
		
		
        
        JLabel CommunicationSkills=new JLabel("CommunicationSkills         ");
        CommunicationSkills.setBounds(60,90,250,10);
        contentPane.add(CommunicationSkills);
        contentPane.setLayout(null);
        
        Text[0]=new JTextField();
		contentPane.add(Text[0]);
		Text[0].setBounds(350, 85, 30, 20);
		
        
        
        
        
        
        JLabel Influence=new JLabel("Positive influence on people              ");
        Influence.setBounds(60,120,250,20);
        contentPane.add(Influence);
        contentPane.setLayout(null);
        
        Text[1]=new JTextField();
		contentPane.add(Text[1]);
		Text[1].setBounds(350, 120, 30, 20);
		
       
        JLabel Skills=new JLabel("Leadership and Persuasion skills             ");
        Skills.setBounds(60,160,250,20);
        contentPane.add(Skills);
        contentPane.setLayout(null);
        
         
        Text[2]=new JTextField();
		contentPane.add(Text[2]);
		Text[2].setBounds(350, 160, 30, 20);
        
        JLabel Motivation=new JLabel("Motivation capability and durability            ");
        Motivation.setBounds(60,200,250,20);
        contentPane.add(Motivation);
        contentPane.setLayout(null);
        
        Text[3]=new JTextField();
		contentPane.add(Text[3]);
		Text[3].setBounds(350, 200, 30, 20);
        
        
        
        JLabel GeneralSkills=new JLabel("<html><b><u>GENERAL SKILLS:</b></html>");
        GeneralSkills.setFont(new Font("Serif", Font.PLAIN, 16));
		GeneralSkills.setBounds(30,250,250,20);
        contentPane.add(GeneralSkills);
        contentPane.setLayout(null);
        
        Text1[1]=new JTextField();
		contentPane.add(Text1[1]);
		Text1[1].setBounds(350, 250, 30, 20);
		
        
        JLabel Level=new JLabel("Knowledge level about global issues  ");
        Level.setBounds(60,290,250,20);
        contentPane.add(Level);
        contentPane.setLayout(null);
        
        Text[4]=new JTextField();
		contentPane.add(Text[4]);
		Text[4].setBounds(350, 290, 30, 20);
        
        
        JLabel Team=new JLabel("Powerful and Technical team ");
        Team.setBounds(60,330,250,20);
        contentPane.add(Team);
        contentPane.setLayout(null);
        
        Text[5]=new JTextField();
		contentPane.add(Text[5]);
		Text[5].setBounds(350, 330, 30, 20);
        
        
        JLabel Mission=new JLabel("Possessing municipality mission");
        Mission.setBounds(60,370,250,20);
        contentPane.add(Mission);
        contentPane.setLayout(null);
        
        Text[6]=new JTextField();
		contentPane.add(Text[6]);
		Text[6].setBounds(350, 370, 30, 20);
        
         
       
        JLabel Work=new JLabel("Ability to work and coordinate with NGO's");
        Work.setBounds(60,410,250,20);
        contentPane.add(Work);
        contentPane.setLayout(null);
        
        Text[7]=new JTextField();
		contentPane.add(Text[7]);
		Text[7].setBounds(350, 410, 30, 20);
        
        
        JLabel Education=new JLabel("Educational Background ");
        Education.setBounds(60,450,250,20);
        contentPane.add(Education);
        contentPane.setLayout(null);
        
        Text[8]=new JTextField();
		contentPane.add(Text[8]);
		Text[8].setBounds(350, 450, 30, 20);
        
        
        
        JLabel Urban=new JLabel("<html><b><u>URBAN STRATEGIES:</b></html> ");
        Urban.setFont(new Font("Serif", Font.PLAIN, 16));
        Urban.setBounds(30,490,250,20);
        contentPane.add(Urban);
        contentPane.setLayout(null);
        
        Text1[2]=new JTextField();
		contentPane.add(Text1[2]);
		Text1[2].setBounds(350, 490, 30, 20);
		
        
        JLabel Sponsor=new JLabel("Taking part as sponsors in urban projects");
        Sponsor.setBounds(60,520,250,20);
        contentPane.add(Sponsor);
        contentPane.setLayout(null);
        
        Text[9]=new JTextField();
		contentPane.add(Text[9]);
		Text[9].setBounds(350, 525, 30, 20);
        
        
        JLabel Value=new JLabel("Adding value to urban developments");
        Value.setBounds(60,560,250,20);
        contentPane.add(Value);
        contentPane.setLayout(null);
        
        Text[10]=new JTextField();
		contentPane.add(Text[10]);
		Text[10].setBounds(350, 560, 30, 20);
        
        
        JLabel City=new JLabel("Positive relationship with city personels");
        City.setBounds(60,600,250,20);
        contentPane.add(City);
        contentPane.setLayout(null);
        
        Text[11]=new JTextField();
		contentPane.add(Text[11]);
		Text[11].setBounds(350, 600, 30, 20);
        
        
        JLabel Issue=new JLabel("Knowledge about urban problem");
        Issue.setBounds(60,635,250,30);
        contentPane.add(Issue);
        contentPane.setLayout(null);
        
        Text[12]=new JTextField();
		contentPane.add(Text[12]);
		Text[12].setBounds(350, 635, 30, 20);
        
        
        JLabel Human=new JLabel("<html><b><u>PERSONAL CHARACTERISTICS:");
        Human.setFont(new Font("Serif", Font.PLAIN, 16));
		Human.setBounds(450,50,250,20);
        contentPane.add(Human);
        contentPane.setLayout(null);
        
        Text1[3]=new JTextField();
		contentPane.add(Text1[3]);
		Text1[3].setBounds(830, 45, 30, 20);
		
        
        JLabel Able=new JLabel("Using resources efficiently and economically ");
        Able.setBounds(490,80,260,30);
        contentPane.add(Able);
        contentPane.setLayout(null);
        
        Text[13]=new JTextField();
		contentPane.add(Text[13]);
		Text[13].setBounds(830, 85, 30, 20);
        
        
        JLabel Prior=new JLabel("No prior criminal activities ");
        Prior.setBounds(490,120,260,30);
        contentPane.add(Prior);
        contentPane.setLayout(null);
        
        Text[14]=new JTextField();
		contentPane.add(Text[14]);
		Text[14].setBounds(830, 120, 30, 20);
        
        
        JLabel Notion=new JLabel("Sub-Identity notion");
        Notion.setBounds(490,160,260,30);
        contentPane.add(Notion);
        contentPane.setLayout(null);
        
        Text[15]=new JTextField();
		contentPane.add(Text[15]);
		Text[15].setBounds(830, 160, 30, 20);
        
        
        JLabel Courage=new JLabel("Courage and Intelligence");
        Courage.setBounds(490,200,260,30);
        contentPane.add(Courage);
        contentPane.setLayout(null);
        
        Text[16]=new JTextField();
		contentPane.add(Text[16]);
		Text[16].setBounds(830, 200, 30, 20);
        
        
        JLabel Interact=new JLabel("<html><b><u>INTERACTION BETWEEN CANDIDATE AND POLITICAL PARTY :");
        Interact.setFont(new Font("Serif", Font.PLAIN, 16));
        Interact.setBounds(450,240,340,40);
        contentPane.add(Interact);
        contentPane.setLayout(null);
        
        Text1[4]=new JTextField();
		contentPane.add(Text1[4]);
		Text1[4].setBounds(830, 245, 30, 20);
		
        
        JLabel Party=new JLabel("Adoptibilty to party's mission");
        Party.setBounds(490,300,340,30);
        contentPane.add(Party);
        contentPane.setLayout(null);
        
        Text[17]=new JTextField();
		contentPane.add(Text[17]);
		Text[17].setBounds(830, 305, 30, 20);
        
        
        JLabel Harmony=new JLabel("Being in harmony with political party");
        Harmony.setBounds(490,340,340,30);
        contentPane.add(Harmony);
        contentPane.setLayout(null);
        
        Text[18]=new JTextField();
		contentPane.add(Text[18]);
		Text[18].setBounds(830, 345, 30, 20);
        
        
        JLabel Task=new JLabel("Previous achievements in party tasks");
        Task.setBounds(490,380,340,30);
        contentPane.add(Task);
        contentPane.setLayout(null);
        
        
        Text[19]=new JTextField();
		contentPane.add(Text[19]);
		Text[19].setBounds(830, 385, 30, 20);
        
        JLabel Root=new JLabel("Experience in grassroots projects");
        Root.setBounds(490,420,340,30);
        contentPane.add(Root);
        contentPane.setLayout(null);
        
        Text[20]=new JTextField();
		contentPane.add(Text[20]);
		Text[20].setBounds(830, 425, 30, 20);
        
       
       
       
        
        
      submit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			// validating entries in the form 
			if(FormValidate())
				System.out.println("true");
		}

		
		
		
		
		private boolean FormValidate() {
			int sum=0,i,j;
			for(i=0;i<4;i++)
				sum+=Integer.parseInt(Text[i].getText());
			if(sum!=100)
				return false;
			sum=0;
			for(j=i;j<=9;j++)
				sum+=Integer.parseInt(Text[j].getText());
			if(sum!=125)
				return false;
			
			sum=0;
			for(i=j;i<=13;i++)
				sum+=Integer.parseInt(Text[i].getText());
			if(sum!=100)
				return false;
			
			sum=0;
			for(j=i;j<=17;j++)
				sum+=Integer.parseInt(Text[j].getText());
			if(sum!=100)
				return false;
			
			sum=0;
			for(i=j;i<=21;i++)
				sum+=Integer.parseInt(Text[i].getText());
			if(sum!=100)
				return false;
			
			return true;
			
			
		}
	});
        
        
        
       
       
       
       
       
       
       
       
       
        
       
       
        
        
        
        
        
       
        
        
        
        
        
        
        
        

        
		
		
		
	}

}
