import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.TransferHandler;
import javax.swing.text.JTextComponent;
public class RightMouseMenu extends PopupMenu
{
	 JTextComponent jTextComponent;
	 String cut;
	 String copy;
	 String paste;
	 String delete;
	 String selectAll;
	
	public RightMouseMenu(JTextComponent jTextComponent)
	{
		this(jTextComponent,"Cut", "Copy","Paste","Delete","Select all");
	}
	
	public RightMouseMenu(JTextComponent jTextComponent, String cut, String copy, String paste, String delete, String selectAll)
	{
		super();
		this.jTextComponent = jTextComponent;
		this.cut = cut;
		this.copy = copy;
		this.paste = paste;
		this.delete = delete;
		this.selectAll = selectAll;
		jTextComponent.add(this);
		
		MyListner myListner = new MyListner();
		jTextComponent.addMouseListener(myListner);
		addActionListener(myListner);
	}
	 void resetItem()
	{
		removeAll();
		
		boolean isTestSel = jTextComponent.getSelectedText()!=null;
		boolean isEditable = jTextComponent.isEditable();
		addMenuItem(cut, isTestSel && isEditable);
		addMenuItem(copy, isTestSel);
		addMenuItem(paste, isEditable);
		addMenuItem(delete, isEditable);
		addSeparator();
		addMenuItem(selectAll, jTextComponent.isEnabled());
	}
	
	
	 void addMenuItem(String label, boolean isEnabled)
	{
		MenuItem menuItem = new MenuItem(label);
		menuItem.setEnabled(isEnabled);
		add(menuItem);
	}
	 void copy()
	{
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		TransferHandler transferHandler = jTextComponent.getTransferHandler();
		transferHandler.exportToClipboard(jTextComponent, clipboard, TransferHandler.COPY);
	}
	
	 void paste()
	{
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		TransferHandler transferHandler = jTextComponent.getTransferHandler();
		transferHandler.importData(jTextComponent, clipboard.getContents(null));
	}
	 class MyListner extends MouseAdapter implements ActionListener
	{
		@Override
		public void mousePressed(MouseEvent e) 
		{
			if(e.getButton() ==3)
			{
				resetItem();
				Point point = jTextComponent.getMousePosition();
				if(point!=null)
					show(jTextComponent,point.x,point.y);
			}
		}
		
		public void actionPerformed(ActionEvent e)
		{
			String source = e.getActionCommand();
			if(source.equals(copy))
				copy();
		
			else if(source.equals(paste))
				paste();
			
			else if(source.equals(cut))
			{
				copy();
				jTextComponent.replaceSelection("");
			}
			
			else if(source.equals(delete))
				jTextComponent.replaceSelection("");
			
			else if(source.equals(selectAll))
				jTextComponent.selectAll();
		}
	}
}