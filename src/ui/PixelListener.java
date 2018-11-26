package ui;

import java.awt.*;
import java.awt.event.*;

import codeGeneration.*;

/*
 * Multipurpose listener used for keyboard and mouse input within PixelPanel
 */
public class PixelListener implements MouseMotionListener, MouseListener, KeyListener
{
	int xStep;
	int yStep;
	
	public PixelListener(int xStep, int yStep)
	{
		this.xStep = xStep;
		this.yStep = yStep;
	}
	
	/*
	 * Draw onto current pixel with drawRect
	 * Saves information into the PixelPanel's Color[][]
	 * TODO: add colors
	 */
	public void mouseClicked(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		PixelPanel source = (PixelPanel)e.getSource();
		Graphics g = source.getGraphics();
		
		source.colors[y / yStep][x / xStep] = Color.BLACK;
		g.fillRect((x - x % xStep), (y - y%yStep), xStep, yStep);
	}
	
	public void mouseDragged(MouseEvent e)
	{
		mouseClicked(e);
	}

	//Currently testing save feature on any key press
	public void keyTyped(KeyEvent arg0)
	{
		PixelPanel source = (PixelPanel)arg0.getSource();
		
		System.out.println(CreateCode.generateJava("Test", source.colors, xStep, yStep));
	}
	
	//No action required on these triggers
	
	public void mouseMoved(MouseEvent e) {}

	public void mousePressed(MouseEvent e){}

	public void mouseReleased(MouseEvent e){}

	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void keyPressed(KeyEvent arg0){}
	
	public void keyReleased(KeyEvent arg0){}

}
