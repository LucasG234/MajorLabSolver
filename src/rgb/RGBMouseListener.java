package rgb;

import java.awt.Color;
import java.awt.event.*;


public class RGBMouseListener implements MouseListener, MouseMotionListener
{

	public void mouseClicked(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		RGBMixer source = (RGBMixer)e.getSource();
		
		//Check if click is in bounds of any slider
		if(y >= 160 && y <= 415)
		{
			if(x >= 100 && x <= 150)
			{
				source.setColor(Color.RED, 255-(y-160));
				source.setField(Color.RED, 255-(y-160));
			}
			else if(x >= 175 && x <= 225)
			{
				source.setColor(Color.GREEN, 255-(y-160));
				source.setField(Color.GREEN, 255-(y-160));
			}
			else if(x >= 250 && x <= 300)
			{
				source.setColor(Color.BLUE, 255-(y-160));
				source.setField(Color.BLUE, 255-(y-160));
			}
		}
		
		//forces TextFields to focus on window and update values
		//source.grabFocus();
		
		source.repaint();
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
