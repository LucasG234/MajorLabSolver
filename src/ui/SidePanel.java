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
		
		holder.add(mixer, BorderLayout.CENTER);
		
		holder.setPreferredSize(new Dimension(325,600));
		
		JButton drawType = new JButton("Current drawing style: Brush");
		drawType.setActionCommand("ToFill");
		drawType.addActionListener(new ButtonListener(panel));
		drawType.setPreferredSize(new Dimension(200,30));
		
		JButton clear = new JButton("Clear the Screen");
		clear.setActionCommand("Clear");
		clear.addActionListener(new ButtonListener(panel));
		clear.setPreferredSize(new Dimension(200,30));
		
		JButton save = new JButton("Export as Java Code");
		save.setActionCommand("Save");
		save.addActionListener(new ButtonListener(panel));
		clear.setPreferredSize(new Dimension(200,30));
		
		add(holder);
		add(drawType);
		add(clear);
		add(save);
	}
	

}
