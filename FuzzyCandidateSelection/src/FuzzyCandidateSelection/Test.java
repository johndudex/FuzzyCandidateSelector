package FuzzyCandidateSelection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Test extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel newPanel=new JPanel();
		newPanel.setBounds(100, 100, 170, 170);
		
		JLabel MyName=new JLabel("Hello world");
		contentPane.setLayout(null);
		MyName.setBounds(90, 10, 70, 20);
		contentPane.setBackground(Color.GREEN);
		newPanel.add(MyName);
		//newPanel.setVisible(false);
		contentPane.add(newPanel);
		this.setVisible(false);
		Rating rating =new Rating();
		rating.setVisible(true);
		
		
	}

}
