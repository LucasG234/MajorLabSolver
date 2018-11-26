package ui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class PixelCanvasPanel extends JPanel
{
	public PixelCanvasPanel()
	{
		PixelListener listener = new PixelListener(10,10);
		
		setFocusable(true);
		
		//Size currently immutable
		setPreferredSize(new Dimension(600,600));
		setMinimumSize(new Dimension(600,600));
		setMaximumSize(new Dimension(600,600));
		
		setBackground(Color.RED);
		
		addMouseListener(listener);
		addMouseMotionListener(listener);
		addKeyListener(listener);
	}
	
	public BufferedImage getScreenShot()
	{
		BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		
		paint(bi.getGraphics());
		
		return bi;
	}
}
