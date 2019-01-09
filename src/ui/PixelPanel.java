package ui;

import java.awt.*;
import javax.swing.*;
import rgb.*;

public class PixelPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//pixel size and Color[][] currently hard coded
	int xStep = 15;
	int yStep = 15;
	Dimension size = new Dimension(600,600);
	
	Color[][] colors = new Color[size.height / yStep][size.width / xStep];
	
	//Color of the background (ADD FUNCTIONALITY)
	private Color background = Color.WHITE;
	
	//Controls drawing
	private PixelListener listener;
	
	public PixelPanel(RGBMixer mixer)
	{
		
		for(int r = 0; r < colors.length; r++)
			for(int c = 0; c < colors[r].length; c++)
				colors[r][c] = background;
		
		listener = new PixelListener(xStep,yStep, mixer);
		
		setFocusable(true);
		
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	/*
	 * Overrides original paintComponent
	 * Redraws component whenever window is resized
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for(int y = 0; y < colors.length; y++)
			for(int x = 0; x < colors[y].length; x++)
			{
				g.setColor(colors[y][x]);
				g.fillRect(x * xStep, y * yStep, xStep, yStep);
			}
	}
	
	//this method only sends info to the PixelListener
	public void setDraw(String typeDraw)
	{
		listener.setDrawType(typeDraw);
	}
	
	//Clears the screen completely
	public void clear()
	{
		for(int y = 0; y < colors.length; y++)
			for(int x = 0; x < colors[y].length; x++)
			{
				colors[y][x] = background;
			}
		
		repaint();
	}
}
