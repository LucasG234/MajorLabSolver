package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PixelArtPanel extends JPanel
{
	Pixel[][] pixels;
	
	public PixelArtPanel(int rCount, int cCount)
	{
		pixels = new Pixel[rCount][cCount];
		setLayout(new GridLayout(rCount, cCount));
		
		for(int r = 0; r < rCount; r++)
			for(int c = 0; c < cCount; c++)
			{
				Pixel curr = new Pixel(Color.WHITE);
				pixels[r][c] = curr;
				add(curr);
			}
	}
}
