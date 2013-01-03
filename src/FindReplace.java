
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JButton;


import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;


public class FindReplace extends JFrame implements ActionListener {

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
	  private JTextField Find_TextField;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public FindReplace(JTextPane jt) {
		setResizable(false);
		setTitle("Find Replace");
		
		jTextPane=jt;
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Find = new JButton("Find");
		Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Find.setBounds(312, 32, 89, 23);
		contentPane.add(Find);
		
		JButton Find_Cancel = new JButton("Cancel");
		Find_Cancel.setBounds(312, 80, 89, 23);
		contentPane.add(Find_Cancel);
		
		JLabel lblNewLabel = new JLabel("Find What");
		lblNewLabel.setBounds(10, 54, 75, 23);
		contentPane.add(lblNewLabel);
		
		Find_TextField = new JTextField();
		Find_TextField.setBounds(73, 48, 183, 34);
		contentPane.add(Find_TextField);
		Find_TextField.setColumns(10);
		
		JCheckBox Find_CheckBox = new JCheckBox("Match Case");
		Find_CheckBox.setBounds(10, 147, 97, 23);
		contentPane.add(Find_CheckBox);
		
		JLabel lblDirection = new JLabel("Direction");
		lblDirection.setBounds(181, 109, 89, 14);
		contentPane.add(lblDirection);
		ButtonGroup bg=new ButtonGroup();
		JRadioButton Font_Radio = new JRadioButton("UP");
		Font_Radio.setBounds(154, 129, 53, 23);
		bg.add(Font_Radio);
		contentPane.add(Font_Radio);
		
		JRadioButton Font_Radio2 = new JRadioButton("Down");
		Font_Radio2.setBounds(209, 129, 109, 23);
		bg.add(Font_Radio2);
		contentPane.add(Font_Radio2);
		Find.addActionListener(this);
		Find_Cancel.addActionListener(this);
		
	}
	


	  /** * finds next occurrence of text in a string 
	  * @param find the text to locate in the string */ 
	  public void doFindText(String find) { 
	  int nextPosn = 0; 
	  if (!find.equals(findText) ) // *** new find word 
	  findPosn = 0; // *** start from top 
	  nextPosn = nextIndex( jTextPane.getText(), find, findPosn, findCase ); 
	 
	  if ( nextPosn >= 0 ) { 
		  int l=getLineNumber(jTextPane,nextPosn+find.length());
		  System.out.print(l);
	  jTextPane.setSelectionStart( nextPosn-l); // position cursor at word start 
	  jTextPane.setSelectionEnd( nextPosn+ find.length()-l+1);
	 
	  findPosn = nextPosn + find.length()+1; // reset for next search 
	  findText = find; // save word & case 
	  } else { 
	  findPosn = nextPosn; // set to -1 if not found 
	  JOptionPane.showMessageDialog(null, find + " not Found!" ); 
	  } 
	  } 

	  /** finds and replaces <B>ALL</B> occurrences of text in a string 
	  * @param find the text to locate in the string 
	  * @param replace the text to replace the find text with - if the find 
	  text exists */ 
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
	//  jTextPane.replaceRange( replace, nextPosn, nextPosn + find.length() ); 
	  } else if ( rtn == javax.swing.JOptionPane.CANCEL_OPTION ) 
	  return; // cancelled replace - exit method 
	  findPosn = nextPosn + find.length(); // set for next search 
	  } 
	  } 
	  } 
	  public int getLineNumber(JTextPane component, int pos) 
	  {
	    int posLine;
	    int y = 0;

	    try
	    {
	      Rectangle caretCoords = component.modelToView(pos);
	      y = (int) caretCoords.getY();
	    }
	    catch (BadLocationException ex)
	    {
	    }

	    int lineHeight = component.getFontMetrics(component.getFont()).getHeight();
	    posLine = (y / lineHeight) + 1;
	    return posLine;
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
		else if(e.getActionCommand()=="Find")
		{
			doFindText(Find_TextField.getText());
		}
	}
	  }


