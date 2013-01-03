
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;


public class ReplaceText extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextPane jTextPane;
	private int findPosn = 0; 
	  /** the last text searched for */ 
	  private String findText = null; 
	  /** case sensitive find/replace */ 
	  private boolean findCase = false; 
	  /** user must confirm text replacement */ 
	  private boolean replaceConfirm = true; 
	  private JTextField Replace_t1;
	  private JTextField Replace_t2;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ReplaceText(JTextPane jt) {
		setResizable(false);
		setTitle("Find Replace");
		
		jTextPane=jt;
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Button_Replace = new JButton("Replace");
		Button_Replace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Button_Replace.setBounds(312, 32, 89, 23);
		contentPane.add(Button_Replace);
		
		JButton button_ReplaceAll = new JButton("Replace All");
		button_ReplaceAll.setBounds(312, 133, 89, 23);
		contentPane.add(button_ReplaceAll);
		
		JLabel lblNewLabel = new JLabel("Find What");
		lblNewLabel.setBounds(8, 32, 67, 23);
		contentPane.add(lblNewLabel);
		
		Replace_t1 = new JTextField();
		Replace_t1.setBounds(76, 26, 183, 34);
		contentPane.add(Replace_t1);
		Replace_t1.setColumns(10);
		
		JCheckBox Replace_CheckBox = new JCheckBox("Match Case");
		Replace_CheckBox.setBounds(10, 147, 97, 23);
		contentPane.add(Replace_CheckBox);
		ButtonGroup bg=new ButtonGroup();
		
		JLabel lblReplaceWith = new JLabel("Replace With");
		lblReplaceWith.setBounds(8, 95, 67, 28);
		contentPane.add(lblReplaceWith);
		
		Replace_t2 = new JTextField();
		Replace_t2.setBounds(76, 93, 173, 33);
		contentPane.add(Replace_t2);
		Replace_t2.setColumns(10);
		
		JButton button_Cancel = new JButton("Cancel");
		button_Cancel.setBounds(312, 80, 89, 23);
		contentPane.add(button_Cancel);
		Button_Replace.addActionListener(this);
		button_ReplaceAll.addActionListener(this);
		
	}
	

	  public void doReplaceWords(String find, String replace) { 
	  int nextPosn = 0; 
	  StringBuffer str = new StringBuffer(); 
	  findPosn = 0; // *** begin at start of text 
	  while (nextPosn >= 0) { 
	  nextPosn = nextIndex( jTextPane.getText(), find, findPosn, findCase ); 

	  if ( nextPosn >= 0 ) { // if text is found 
	  int rtn = JOptionPane.YES_OPTION; // default YES for confirm 
	  jTextPane.grabFocus(); 
	  jTextPane.setSelectionStart( nextPosn ); // posn cursor at word start 
	  jTextPane.setSelectionEnd( nextPosn + find.length() ); //select found text 
	  if ( replaceConfirm ) { // user replace confirmation 
	  rtn = JOptionPane.showConfirmDialog(null, "Found: " + find + "\nReplace with: " + replace, "Text Find & Replace", JOptionPane.YES_NO_CANCEL_OPTION); 
	  } 
	  // if don't want confirm or selected yes 
	  if ( !replaceConfirm || rtn == JOptionPane.YES_OPTION ) { 
	  jTextPane.replaceSelection(Replace_t2.getText());//( replace, nextPosn, nextPosn + find.length() ); 
	  } else if ( rtn == javax.swing.JOptionPane.CANCEL_OPTION ) 
	  return; // cancelled replace - exit method 
	  findPosn = nextPosn + find.length(); // set for next search 
	  } 
	  } 
	  } 

	  /** returns next posn of word in text - forward search 
	  * @return next indexed position of start of found text or -1 
	  * @param input the string to search 
	  * @param find the string to find 
	  * @param start the character position to start the search 
	  * @param caseSensitive true for case sensitive. false to ignore case 
	  */ 
	  public int nextIndex(String input, String find, int start, boolean 
	  caseSensitive ) { 
	  int textPosn = -1; 
	  if ( input != null && find != null && start < input.length() ) { 
	  if ( caseSensitive == true ) { // indexOf() returns -1 if not found 
	  textPosn = input.indexOf( find, start ); 
	  } else { 
	  textPosn = input.toLowerCase().indexOf( find.toLowerCase(), 
	  start ); 
	  } 
	  } 
	  return textPosn; 
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Cancel")
		{
			this.setVisible(false);
			this.dispose();
			
		}
		else if(e.getActionCommand()=="Replace")
		{
			doReplaceWords(Replace_t1.getText(),Replace_t2.getText());
		}
	}
	  }


