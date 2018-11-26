package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PixelListener implements MouseMotionListener, MouseListener, KeyListener
{
	int xStep;
	int yStep;
	
	public PixelListener(int xStep, int yStep)
	{
		this.xStep = xStep;
		this.yStep = yStep;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		Graphics g = ((JPanel)e.getSource()).getGraphics();
		g.fillRect((x - x % xStep), (y - y%yStep), xStep, yStep);
		
	}
	
	public void mouseDragged(MouseEvent e)
	{
		mouseClicked(e);
	}


	public void keyTyped(KeyEvent arg0)
	{
		System.out.println("Currently testing save feature on any key press");
		
		
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
