package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pixel extends JButton
{
	public Color c;
	
	public Pixel(Color c)
	{
		setOpaque(true);
		setBorderPainted(false);
		setColor(c);
		addActionListener(new PixelListener());
	}
	
	public void setColor(Color c)
	{
		this.c = c;
		setBackground(this.c);
	}
}
