package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PixelListener implements MouseMotionListener, MouseListener
{
	int xStep;
	int yStep;
	
	public PixelListener(int xStep, int yStep)
	{
		this.xStep = xStep;
		this.yStep = yStep;
	}
	
	public void mouseDragged(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		Graphics g = ((JPanel)e.getSource()).getGraphics();
		g.fillRect((x - x % xStep), (y - y%yStep), xStep, yStep);
	}

	public void mouseMoved(MouseEvent e)
	{
	}

	public void mouseClicked(MouseEvent e)
	{
		mouseDragged(e);
	}

	public void mousePressed(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

}
