package ui;

import java.awt.*;
import javax.swing.*;
import rgb.*;

public class MainPanel extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	//Mixer stored to be supplied to both panels
	private RGBMixer mixer;
	private PixelPanel center;

	/*
	 * Primary panel holding UI
	 */
	public MainPanel()
	{
		super("Stites Lab Solver");
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Default size which the window opens at
		setSize(1000,700);
		
		//TODO: initialization (ask for size and pixel number)
		
		//Default action of program
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		mixer = new rgb.RGBMixer();
		center = new PixelPanel(mixer);
		
		//Initialize the current color before the pixel board
		pane.add(new SidePanel(center, mixer), BorderLayout.LINE_END);
		pane.add(pixelHolder(), BorderLayout.CENTER);
	}
	
	/*
	 * FlowLayout allows main canvas to move instead of resizing
	 * when window is resized
	 */
	public JPanel pixelHolder()
	{
		JPanel holder = new JPanel();
		
		holder.setLayout(new FlowLayout());
		
		holder.add(center);
		
		return holder;
	}
	
//	public JPanel sidePanel()
//	{
//		JPanel side = new JPanel();
//		side.setLayout(new BoxLayout(side, BoxLayout.Y_AXIS));
//		
//		//holder contains the RGBMixer
//		JPanel holder = new JPanel();
//		holder.setOpaque(false);
//		holder.setLayout(new BorderLayout());
//		
//		mixer = new rgb.RGBMixer();
//		holder.add(mixer, BorderLayout.CENTER);
//		
//		holder.setPreferredSize(new Dimension(325,600));
//		
//		clear = new JButton("Clear the Screen");
//		clear.setActionCommand("Clear");
//		
//		save = new JButton("Export as Java Code");
//		save.setActionCommand("Save");
//		
//		side.add(holder);
//		side.add(clear);
//		side.add(save);
//		
//		return side;
//	}
}
