package rgb;

import java.awt.*;
import javax.swing.*;

/*
 * This module currently serves purely as an example of a hardcoded RGB Mixer
 */
public class RGBMixer extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public int red, green, blue;
	
	public RGBMixer()
	{
		red = 0;
		green = 0;
		blue = 0;
		
		addMouseListener(new RGBMouseListener());
		addMouseMotionListener(new RGBMouseListener());
		
		//allows absolute positioning of Components
		//setLayout(null);
		
		setFocusable(true);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		
		
		//Draw Bars
		g2.setColor(new Color(red, green, blue));
		g2.fillRect(100, 50, 200, 100);
		
		g2.setColor(Color.RED);
		g2.fillRect(100, 160 + (255-red), 50, red);
		
		g2.setColor(Color.GREEN);
		g2.fillRect(175, 160 + (255-green), 50, green);
		
		g2.setColor(Color.BLUE);
		g2.fillRect(250, 160 + (255-blue), 50, blue);
		
		//Draw boundaries over bars
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(5));
		g2.drawRect(100, 50, 200, 100);
		g2.drawRect(100, 160, 50, 255);
		g2.drawRect(175, 160, 50, 255);
		g2.drawRect(250, 160, 50, 255);
	}
}
