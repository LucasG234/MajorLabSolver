package ui;

import java.awt.*;
import javax.swing.*;

public class PixelCanvasPanel extends JPanel
{
	//pixel size and Color[][] currently hard coded
	int xStep = 150;
	int yStep = 150;
	Dimension size = new Dimension(600,600);
	
	Color[][] colors = new Color[size.height / yStep][size.width / xStep];
	
	public PixelCanvasPanel()
	{
		for(int r = 0; r < colors.length; r++)
			for(int c = 0; c < colors[r].length; c++)
				colors[r][c] = Color.WHITE;
		
		
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
