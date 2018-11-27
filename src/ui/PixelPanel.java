package ui;

import java.awt.*;
import javax.swing.*;

public class PixelPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//pixel size and Color[][] currently hard coded
	int xStep = 15;
	int yStep = 15;
	Dimension size = new Dimension(600,600);
	
	Color[][] colors = new Color[size.height / yStep][size.width / xStep];
	
	//What color is currently being drawn with
	Color curr = Color.BLACK;
	//Color of the background (ADD FUNCTIONALITY)
	Color background = Color.WHITE;
	
	public PixelPanel()
	{
		for(int r = 0; r < colors.length; r++)
			for(int c = 0; c < colors[r].length; c++)
				colors[r][c] = background;
		
		
		PixelListener listener = new PixelListener(xStep,yStep);
		
		setFocusable(true);
		
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		
		addMouseListener(listener);
		addMouseMotionListener(listener);
		addKeyListener(listener);
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
}
