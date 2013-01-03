

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;


public class AboutNotepad extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public AboutNotepad() {
		
		setLayout(null);
		//this.setUndecorated(true);
		this.setLocationRelativeTo(null);
					setSize(350,350);
					setVisible(true);
				
					
				
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
	
		
		this.setTitle("About Notepad");
	  
	
		setContentPane(contentPane);
		
     
    
		JLabel lblNewLabel = new JLabel("CopyRight MindSoft Webdevelopment All Right Reserved :) ");
		lblNewLabel.setBounds(0,10,150,30);
		add(lblNewLabel);
		
		ImageIcon im=new ImageIcon("E:\\java\\Notepad\\src\\Army.jpg");
		JLabel lblNewLabel_1 = new JLabel(im);
		lblNewLabel_1.setBounds(0,30,200,200);
		add(lblNewLabel_1);
	
		
		
	}
	

}
