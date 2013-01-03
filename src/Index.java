
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.text.JTextComponent;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;





 class Index extends JFrame implements java.awt.event.ActionListener,java.awt.event.MouseListener{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel contentPane;
	UndoManager manager;
	
	/**
	 * Launch the application.
	 * 
	 */
	JTextPane jTextPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	@SuppressWarnings("deprecation")
	public Index() {
		manager=new UndoManager();
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setTitle("New Text Document");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu file = new JMenu("File");
		menuBar.add(file);
		
		JMenuItem file_new = new JMenuItem("New");
		file.add(file_new);
		
		JMenuItem file_open = new JMenuItem("Open");
		file.add(file_open);
		
		JMenuItem file_save = new JMenuItem("Save");
		file.add(file_save);
		
		JMenuItem file_saveas = new JMenuItem("Save As");
		file.add(file_saveas);
		
		JSeparator separator = new JSeparator();
		file.add(separator);
		
		JMenuItem file_page = new JMenuItem("Page SetUp");
		file.add(file_page);
		
		JMenuItem file_print = new JMenuItem("Print");
		file.add(file_print);
		
		JSeparator separator_1 = new JSeparator();
		file.add(separator_1);
		
		JMenuItem file_exit = new JMenuItem("Exit");
		file.add(file_exit);
		
		JMenu edit = new JMenu("Edit");
		menuBar.add(edit);
		
		JMenuItem edit_undo = new JMenuItem("Undo");
		edit.add(edit_undo);
		
		JSeparator separator_2 = new JSeparator();
		edit.add(separator_2);
		
		JMenuItem edit_cut = new JMenuItem("Cut");
		edit.add(edit_cut);
		
		JMenuItem edit_copy = new JMenuItem("Copy");
		edit.add(edit_copy);
		
		JMenuItem edit_paste = new JMenuItem("Paste");
		edit.add(edit_paste);
		
		JMenuItem edit_delete = new JMenuItem("Delete");
		edit.add(edit_delete);
		
		JSeparator separator_3 = new JSeparator();
		edit.add(separator_3);
		
		JMenuItem edit_find = new JMenuItem("Find");
		edit.add(edit_find);
		
		JMenuItem edit_findNext = new JMenuItem("Find Next");
		edit.add(edit_findNext);
		
		JMenuItem edit_replace = new JMenuItem("Replace");
		edit.add(edit_replace);
		
		JMenuItem edit_goto = new JMenuItem("Go To");
		edit.add(edit_goto);
		
		JSeparator separator_4 = new JSeparator();
		edit.add(separator_4);
		
		JMenuItem edit_select = new JMenuItem("Select All");
		edit.add(edit_select);
		
		JMenuItem edit_timeDate = new JMenuItem("Time/Date");
		edit.add(edit_timeDate);
		
		JMenu format = new JMenu("Format");
		menuBar.add(format);
		
		JMenuItem format_wordwrap = new JMenuItem("Word Wrap");
		format.add(format_wordwrap);
		
		JMenuItem format_font = new JMenuItem("Font");
		format.add(format_font);
		
		JMenu view = new JMenu("View");
		menuBar.add(view);
		
		JMenuItem view_statusBar = new JMenuItem("Status Bar");
		view.add(view_statusBar);
		
		JMenu help = new JMenu("Help");
		menuBar.add(help);
		
		JMenuItem help_viewHelp = new JMenuItem("View Help");
		help.add(help_viewHelp);
		
		JSeparator separator_5 = new JSeparator();
		help.add(separator_5);
		JMenuItem help_aboutNotepad = new JMenuItem("About Notepad");
		help.add(help_aboutNotepad);
		addMouseListener(this);
		file_open.addActionListener(this);
		file_new.addActionListener(this);
		file_save.addActionListener(this);
		file_saveas.addActionListener(this);
		file_exit.addActionListener(this);
		edit_timeDate.addActionListener(this);
		file_print.addActionListener(this);
		edit_copy.addActionListener(this);
		edit_paste.addActionListener(this);
		edit_select.addActionListener(this);
		edit_delete.addActionListener(this);
		help_aboutNotepad.addActionListener(this);
		edit_cut.addActionListener(this);
		view_statusBar.addActionListener(this);
		format_font.addActionListener(this);
		edit_undo.addActionListener(this);
		help_viewHelp.addActionListener(this);
		edit_find.addActionListener(this);
		edit_replace.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 
		// JPanel panel = new JPanel();
		// contentPane.add(panel, BorderLayout.NORTH);
		// panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		 jTextPane = new JTextPane();
		 JScrollPane pane = new JScrollPane(jTextPane);
		//contentPane.add(jTextPane, BorderLayout.CENTER);
		 contentPane.add(pane);
		
		 if(jTextPane.getSelectedText()==null)
			{
				edit_cut.setEnabled(false);
				edit_copy.setEnabled(false);
	
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getActionCommand()=="Open")
	{
		try
		{
		  
                JFileChooser jFileChooser=new JFileChooser("E:\\");
                jFileChooser.approveSelection();
                jFileChooser.setFileSelectionMode(DISPOSE_ON_CLOSE);
                jFileChooser.showOpenDialog(null);
                String s=jFileChooser.getSelectedFile().getPath();
                setTitle(s);
                readin(s.toString(), jTextPane);
                
                	        
         }
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog (null,"Invalid File!!\n\r"+e1,"File Open Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	else if(e.getActionCommand()=="New")
	{
		setTitle("New Text Document");
		jTextPane.setText("");
	}
	else if(e.getActionCommand()=="Save")
	{
		if(this.getTitle()=="New Text Document")
		{
		
		FileDialog fd = new FileDialog(this, "Save TEXTL File..",FileDialog.SAVE);
		fd.show();
		System.out.println(fd.getFile());
		System.out.println(fd.getDirectory());
		

		try {
		DataOutputStream out =new DataOutputStream (new FileOutputStream (fd.getDirectory()+fd.getFile()));

		//out.writeUTF(jTextPane.getText());
		out.writeBytes(jTextPane.getText());
		if(this.getTitle()!=null)
		{
		setTitle(fd.getDirectory()+fd.getFile());
		}
		out.flush ();
		out.close ();

		}
		catch (IOException ioe) {
		JOptionPane.showMessageDialog (null,"Error in writing data!!\n\r"+ioe,"File Save Error",JOptionPane.ERROR_MESSAGE);
		}
		}
		else
		{   
			try {
				DataOutputStream out =new DataOutputStream (new FileOutputStream (this.getTitle()));

				out.writeChars(jTextPane.getText());
				out.flush ();
				out.close ();

				}
				catch (IOException ioe) {
				JOptionPane.showMessageDialog (null,"Error in writing data!!\n\r"+ioe,"File Save Error",JOptionPane.ERROR_MESSAGE);
				}
			
		}
	}
		else if(e.getActionCommand()=="Exit")
		{
			this.dispose();
			System.exit(0);
		}
		else if(e.getActionCommand()=="Time/Date")
		{
			java.util.Date c=new java.util.Date();
			
			jTextPane.setText(c.toString());
			 
		
			
		}
		else if(e.getActionCommand()=="Print")
		{
			new PrintDialogExample();
		}
		else if(e.getActionCommand()=="Copy")
		{
			new Operate(jTextPane).copy();
			
		}
		else if(e.getActionCommand()=="Cut")
		{
			new Operate(jTextPane).cut();
		}
		else if(e.getActionCommand()=="Paste")
		{
			new Operate(jTextPane).paste();
		}
		else if(e.getActionCommand()=="Select All")
		{
			jTextPane.selectAll();
		
		}
		else if(e.getActionCommand()=="Delete")
		{
			new Operate(jTextPane).delete();
		
		}
		else if(e.getActionCommand()=="About Notepad")
		{
			new AboutNotepad();
			
		}
		else if(e.getActionCommand()=="View Help")
		{
			launchURL("http://www.shashitechno.wordpress.com");
			
		}
	 
		else if(e.getActionCommand()=="Status Bar")
		{
			Graphics g=getGraphics();
		
//			int y = 0;
		    g.setColor(new Color(156, 154, 140));
		    g.drawLine(0,getHeight()-50, getWidth(),20);
		  //  y++;
		    g.setColor(new Color(196, 194, 183));
		    g.drawLine(0,getHeight()-30, getWidth(),20);
			g.setColor(Color.red);
			g.drawString("10 cols 1 line",30,700);
			
		}
		else if(e.getActionCommand()=="Font")
		{
			new FontFrame(this);
			
		}

		
	else if(e.getActionCommand()=="Undo")
		{
			 
			try
			{
			
				new RedoAction(manager);
				
			}
			catch(CannotUndoException ex)
			{
				Toolkit.getDefaultToolkit().beep();
			}
		}
		else if(e.getActionCommand()=="Redo")
		{
			 
			try
			{
				new UndoAction(manager);
				
			}
			catch(CannotUndoException ex)
			{
				Toolkit.getDefaultToolkit().beep();
			}
		}
		else if(e.getActionCommand()=="Find")
		{
			new FindReplace(jTextPane);
			
		}
		else if(e.getActionCommand()=="Replace")
		{
			new ReplaceText(jTextPane);
		}
				
		
	      
	jTextPane.getDocument().addUndoableEditListener(manager);

    Action undoAction = new UndoAction(manager);
    Action redoAction = new RedoAction(manager);
    
    jTextPane.registerKeyboardAction(undoAction,KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK),JComponent.WHEN_FOCUSED);
    
    jTextPane.registerKeyboardAction(redoAction,KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK),JComponent.WHEN_FOCUSED);
	
  
	
	

	
	
 }

	private void launchURL(String s) {
        String s1 = System.getProperty("os.name");
        try {

            if (s1.startsWith("Windows")) {
                Runtime.getRuntime().exec((new StringBuilder()).append("rundll32 url.dll,FileProtocolHandler ").append(s).toString());
            } else {
                String as[] = {"firefox", "opera", "konqueror", "epiphany",
                    "mozilla", "netscape"};
                String s2 = null;
                for (int i = 0; i < as.length && s2 == null; i++) {
                    if (Runtime.getRuntime().exec(new String[]{"which", as[i]}).waitFor() == 0) {
                        s2 = as[i];
                    }
                }

                if (s2 == null) {
                    throw new Exception("Could not find web browser");
                }
                Runtime.getRuntime().exec(new String[]{s2, s});
            }
        } catch (Exception exception) {
            System.out.println("An error occured while trying to open the            web browser!\n");
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()+" "+e.getY());
		if(e.getButton()==MouseEvent.BUTTON3)
		{
			new RightMouseMenu(jTextPane);
		}
		
		
				
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	void readin(String fn, JTextComponent pane) {
        try {
            FileReader fr = new FileReader(fn);
            pane.read(fr, null);
            fr.close();
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
	public class UndoAction extends AbstractAction {
	    public UndoAction(UndoManager manager) {
	      this.manager = manager;
	    }

	    public void actionPerformed(ActionEvent evt) {
	      try {
	        manager.undo();
	      } catch (CannotUndoException e){
	    	  System.out.print("m");
	        Toolkit.getDefaultToolkit().beep();
	      }
	    }

	    private UndoManager manager;
	  }

	  // The Redo action
	  public class RedoAction extends AbstractAction {
	    public RedoAction(UndoManager manager) {
	      this.manager = manager;
	    }

	    public void actionPerformed(ActionEvent evt) {
	      try {
	        manager.redo();
	        
	      } catch (CannotRedoException e) {
	        Toolkit.getDefaultToolkit().beep();
	      }
	    }

	    private UndoManager manager;
	  }
	  
	  
 }
	
	
	
 
	
	
                
 	
	
	


