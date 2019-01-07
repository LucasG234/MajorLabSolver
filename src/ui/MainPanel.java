package ui;

import java.awt.*;
import javax.swing.*;
import rgb.*;

public class MainPanel extends JFrame
{
	private static final long serialVersionUID = 1L;

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
				
		pane.add(pixelHolder(), BorderLayout.CENTER);
		pane.add(RGBHolder(), BorderLayout.LINE_END);
	}
	
	/*
	 * FlowLayout allows main canvas to move instead of resizing
	 * when window is resized
	 */
	public static JPanel pixelHolder()
	{
		JPanel holder = new JPanel();
		
		holder.setLayout(new FlowLayout());
		
		holder.add(new PixelPanel());
		
		return holder;
	}
	
	public static JPanel RGBHolder()
	{
		JPanel holder = new JPanel();
		holder.setOpaque(false);
		holder.setLayout(new BorderLayout());
		
		holder.add(new rgb.RGBMixer(), BorderLayout.CENTER);
		
		holder.setPreferredSize(new Dimension(325,600));
		return holder;
	}
}
