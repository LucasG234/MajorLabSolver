package rgb;

import java.awt.event.*;
import javax.swing.*;

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
				source.red = 255-(y-160);
			}
			else if(x >= 175 && x <= 225)
			{
				source.green = 255-(y-160);
			}
			else if(x >= 250 && x <= 300)
			{
				source.blue = 255-(y-160);
			}
		}
		
		//Unfocuses from textfield whenever panel is pressed
		source.grabFocus();
		
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
