package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PixelListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		Pixel source = (Pixel)e.getSource();
		
		source.setColor(Color.BLACK);
		
		source.repaint();
	}

}
