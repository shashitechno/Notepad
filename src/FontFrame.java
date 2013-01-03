
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FontFrame extends JFrame implements ListSelectionListener,ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String fontSize[];
	JList<?> list,list_1,list_2;
	JTextArea txtrShashikantVaishnav;
	JButton font_OK,font_Cancel;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FontFrame(final Index obj) {
		
		setTitle("Font");
		
		System.out.println("lol");
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFont = new JLabel("Font");
		lblFont.setBounds(21, 23, 37, 14);
		contentPane.add(lblFont);
		
		JPanel panel = new JPanel();
		panel.setBounds(225, 12, 10, 10);
		contentPane.add(panel);
		
		textField = new JTextField("comic sans ms");
		textField.setBounds(10, 37, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		Object FontName[]={"comic sans ms","algerian","arial black","britannic bold","brush script mt","century gothic","BRUSH SCRIPT MT","matura mt script capitals","webdings","wide latin","verdana","tempus sans itc"};
		 list = new JList(FontName);
		list.setBounds(10, 58, 86,77);
	
	
	
		contentPane.add(list);
		
		JLabel lblFontStyle = new JLabel("Font Style");
		lblFontStyle.setBounds(168, 23, 67, 14);
		contentPane.add(lblFontStyle);
		
		textField_1 = new JTextField("B");
		textField_1.setBounds(145, 37, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		Object fontStyle[]={"B","B Oblique"};
		 list_1 = new JList(fontStyle);
		 list_1.setToolTipText("Select Font Style");
		 list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(145, 58, 85, 77);
		
		contentPane.add(list_1);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(309, 23, 54, 14);
		contentPane.add(lblSize);
		
		textField_2 = new JTextField("20");
		textField_2.setBounds(285, 37, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		Object fontSize[]={"2","6","10","16","20","24","28","32","34","38","44","48","52","58","62","66","70","72","78"};
		JScrollPane listScroller = new JScrollPane();
	
		 
		 list_2 = new JList(fontSize);
		 list_2.setSelectionMode(1);
		list_2.setBounds(289, 58, 84, 74);
		getContentPane().add(list_2);
		
		 txtrShashikantVaishnav = new JTextArea();
		txtrShashikantVaishnav.setToolTipText("Sample Text");
		txtrShashikantVaishnav.setBackground(UIManager.getColor("Button.background"));
		txtrShashikantVaishnav.setEditable(false);
		txtrShashikantVaishnav.setText("Shashikant Vaishnav");
		txtrShashikantVaishnav.setBounds(23, 159, 375, 58);
		contentPane.add(txtrShashikantVaishnav);
		
		JLabel lblSample = new JLabel("Sample");
		lblSample.setBounds(10, 146, 46, 14);
		contentPane.add(lblSample);
		
		 font_OK = new JButton("OK");
		font_OK.setBackground(Color.WHITE);
		font_OK.setFont(new Font("Papyrus", Font.PLAIN, 11));
		font_OK.setForeground(Color.MAGENTA);
		font_OK.setBounds(199, 228, 89, 23);
		contentPane.add(font_OK);
		
		 font_Cancel = new JButton("Cancel");
		font_Cancel.setBackground(Color.WHITE);
		font_Cancel.setForeground(Color.MAGENTA);
		font_Cancel.setFont(new Font("Papyrus", Font.PLAIN, 11));
		font_Cancel.setBounds(309, 228, 89, 23);
		contentPane.add(font_Cancel);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblFont, panel, textField, list, lblFontStyle, textField_1, list_1, lblSize, textField_2, list_2}));
		//listScroller.add(list_2);
		list_2.addListSelectionListener(this);
		list_1.addListSelectionListener(this);
		list.addListSelectionListener(this);
		font_OK.addActionListener(new ActionListener(){
			
			  public void actionPerformed(ActionEvent e){
				 
			      Font f=new Font(textField.getText(),Font.BOLD,Integer.parseInt(textField_2.getText()));
			      
			     obj.jTextPane.setFont(f);
			  }
			  });
		
		font_Cancel.addActionListener(this);
			
			
	
	
	
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		String fontsize =10+"",FontStyle="B",FontName="ARIAL";
            if(e.getSource()==list_2)
            {
            	fontsize=list_2.getSelectedValue().toString();
            	textField_2.setText(fontsize);
            	
            }
            if(e.getSource()==list_1)
            {
            	FontStyle=list_1.getSelectedValue().toString();
            	textField_1.setText(FontStyle);
            }
            if(e.getSource()==list)
            {
            	FontName=list.getSelectedValue().toString();
            	textField.setText(FontName);
            }
          Font font1 = new Font(textField.getText(),Font.BOLD,Integer.parseInt(textField_2.getText()));
        	
        	txtrShashikantVaishnav.setFont(font1);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
           if(e.getSource()==font_Cancel)
           {
        	   this.setVisible(false);
        	   this.dispose();
           }
		
	}

}