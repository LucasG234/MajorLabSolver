package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.SwingUtilities;

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
				LinkedList<Coord> connected = findConnected(source.colors, y / yStep, x / xStep);
				
				for(Coord coord : connected)
				{
					source.colors[coord.r][coord.c] = curr;
				}
				
				source.repaint();
			}
			else		//Defaults to Brush in case of any error
			{
				source.colors[y / yStep][x / xStep] = curr;
				source.repaint();
			}
		}
	}
	
	//Copy color on right click
	public void mouseReleased(MouseEvent e)
	{
		if(SwingUtilities.isRightMouseButton(e))
		{
			int x = e.getX();
			int y = e.getY();
			
			PixelPanel source = (PixelPanel)e.getSource();
			
			//Check if in bounds
			if(y > 0 && x > 0 && y < source.getHeight() && x < source.getWidth())
			{
				Color newCol = source.colors[y / yStep][ x / xStep];
				mixer.setAllColor(newCol);
			}
			
		}
	}
	
	//Check more efficient implementation
	public LinkedList<Coord> findConnected(Color[][] colors, int y, int x)
	{
		//all Lists will only contain elements within bounds
		LinkedList<Coord> connected = new LinkedList<>();
		LinkedList<Coord> toCheck = new LinkedList<>();
		LinkedList<Coord> invalid = new LinkedList<>();
		
		connected.add(new Coord(y, x));
		
		if(inBounds(colors, y+1, x))
			toCheck.add(new Coord(y+1, x));
		
		if(inBounds(colors, y-1, x))
			toCheck.add(new Coord(y-1, x));
		
		if(inBounds(colors, y, x+1))
			toCheck.add(new Coord(y, x+1));
		
		if(inBounds(colors, y, x-1))
			toCheck.add(new Coord(y, x-1));
		
		while(!toCheck.isEmpty())
		{
			Coord curr = toCheck.poll();
			
			if(!invalid.contains(curr) && colors[y][x].equals(colors[curr.r][curr.c]))
			{
				connected.add(curr);
				invalid.add(curr);
				
				Coord up = new Coord(curr.r-1, curr.c);
				Coord down = new Coord(curr.r+1, curr.c);
				Coord left = new Coord(curr.r, curr.c-1);
				Coord right = new Coord(curr.r, curr.c+1);
				
				if(inBounds(colors, up) && !invalid.contains(up) && colors[y][x].equals(colors[up.r][up.c]))
				{
					toCheck.add(up);
				}
				else if(!invalid.contains(up))
				{
					invalid.add(up);
				}
				
				if(inBounds(colors, down) && !invalid.contains(down) && colors[y][x].equals(colors[down.r][down.c]))
				{
					toCheck.add(down);
				}
				else if(!invalid.contains(down))
				{
					invalid.add(down);
				}
				
				if(inBounds(colors, left) && !invalid.contains(left) && colors[y][x].equals(colors[left.r][left.c]))
				{
					toCheck.add(left);
				}
				else if(!invalid.contains(left))
				{
					invalid.add(left);
				}
				
				if(inBounds(colors, right) && !invalid.contains(right) && colors[y][x].equals(colors[right.r][right.c]))
				{
					toCheck.add(right);
				}
				else if(!invalid.contains(right))
				{
					invalid.add(right);
				}
			}
			else
			{
				invalid.add(curr);
			}
		}
		
		return connected;
	}
	
	private boolean inBounds(Color[][] bounds, int r, int c)
	{
		return(r >= 0 && c >= 0 
				&& r < bounds.length && c < bounds[r].length);
	}
	
	private boolean inBounds(Color[][] bounds, Coord coord)
	{
		return(coord.r >= 0 && coord.c >= 0 
				&& coord.r < bounds.length && coord.c < bounds[coord.r].length);
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

	public void mouseEntered(MouseEvent e){}
	 
	public void mouseExited(MouseEvent e){}
}
