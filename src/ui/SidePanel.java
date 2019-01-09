package ui;

import java.awt.*;
import javax.swing.*;
import rgb.*;

public class SidePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public SidePanel(PixelPanel panel, RGBMixer mixer)
	{
		setBackground(Color.WHITE);
		setOpaque(true);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//holder contains the RGBMixer
		JPanel holder = new JPanel();
		holder.setLayout(new BorderLayout());
		
		mixer = new rgb.RGBMixer();
		holder.add(mixer, BorderLayout.CENTER);
		
		holder.setPreferredSize(new Dimension(325,600));
		
		JButton drawType = new JButton("Current drawing style: Brush");
		drawType.setActionCommand("Draw");
		drawType.addActionListener(new ButtonListener(panel));
		
		JButton clear = new JButton("Clear the Screen");
		clear.setActionCommand("Clear");
		clear.addActionListener(new ButtonListener(panel));
		
		JButton save = new JButton("Export as Java Code");
		save.setActionCommand("Save");
		save.addActionListener(new ButtonListener(panel));
		
		add(holder);
		add(drawType);
		add(clear);
		add(save);
	}
	

}
