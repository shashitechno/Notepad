import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class JStatusBar extends JPanel {

  /**
	 * 
	 */
	private static final long serialVersionUID = -1717824468963266014L;

public JStatusBar() {
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(10, 23));

    JPanel rightPanel = new JPanel(new BorderLayout());
    rightPanel.setOpaque(false);

    add(rightPanel, BorderLayout.EAST);
    JFrame frame = new JFrame();
    frame.setSize(600, 200);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BorderLayout());

    JStatusBar statusBar = new JStatusBar();
    contentPane.add(statusBar, BorderLayout.SOUTH);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int y = 0;
    g.setColor(new Color(156, 154, 140));
    g.drawLine(0, y, getWidth(), y);
    y++;
    g.setColor(new Color(196, 194, 183));
    g.drawLine(0, y, getWidth(), y);
	g.setColor(Color.red);
	g.drawString("10 cols 1 line",0,14);
  }
  public static void main(String args[])
  {
	   new JStatusBar();
  }
}

 


