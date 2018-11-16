package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PixelCanvasPanel extends JPanel
{
	public PixelCanvasPanel()
	{
		PixelListener listener = new PixelListener(10,10);
		
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
}
