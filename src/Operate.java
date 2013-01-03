
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;



import javax.swing.TransferHandler;

import javax.swing.text.JTextComponent;


public class Operate {

	

	/**
	 * Launch the application.
	 */
	JTextComponent jTextComponent;
	

	/**
	 * Create the frame.
	 */
	public Operate(JTextComponent jTextComponent) {
		this.jTextComponent=jTextComponent;
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
		 void cut()
		 {
			 copy();
			 jTextComponent.replaceSelection("");
		 }
		 
		 void delete()
		 {
			 jTextComponent.replaceSelection("");
		 }

}
