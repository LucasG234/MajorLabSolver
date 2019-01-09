package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import dataStructures.Coord;
import rgb.*;

/*
 * Multipurpose listener used for mouse input within PixelPanel
 */
public class PixelListener implements MouseMotionListener, MouseListener
{
	private int xStep;
	private int yStep;
	
	//source of Color information
	private RGBMixer mixer;
	
	private String drawType;
	
	public PixelListener(int xStep, int yStep, RGBMixer mixer)
	{
		this.xStep = xStep;
		this.yStep = yStep;
		this.mixer = mixer;
		//default drawType is brush
		drawType = "Brush";
	}
	
	/*
	 * Draw onto current pixel with drawRect
	 * Saves information into the PixelPanel's Color[][]
	 */
	public void mouseClicked(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		PixelPanel source = (PixelPanel)e.getSource();
		
		//Check if in bounds
		if(y > 0 && x > 0 && y < source.getHeight() && x < source.getWidth())
		{
			Color curr = mixer.getColor();
			
			if(drawType.equals("Fill"))
			{
				ArrayList<Coord> connected = findConnected(source.colors, y / yStep, x / xStep);
			}
			else		//Defaults to Brush in case of any error
			{
				source.colors[y / yStep][x / xStep] = curr;
				source.repaint();
			}
		}
	}
	
	public ArrayList<Coord> findConnected(Color[][] colors, int y, int x)
	{
		ArrayList<Coord> connected = new ArrayList<>();
		
		
		return connected;
	}
	
	public void setDrawType(String drawType)
	{
		this.drawType = drawType;
	}
	
	public void mouseDragged(MouseEvent e)
	{
		mouseClicked(e);
	}

	//No action required on these triggers
	
	public void mouseMoved(MouseEvent e) {}

	public void mousePressed(MouseEvent e){}

	public void mouseReleased(MouseEvent e){}

	public void mouseEntered(MouseEvent e){}
	 
	public void mouseExited(MouseEvent e){}
}
