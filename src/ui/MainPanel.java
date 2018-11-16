package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JFrame
{
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
		setSize(600,600);
		
		//TODO: initialization (ask for size and pixel number)
		
		//Default action of program
		
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		
		pane.add(new PixelCanvasPanel(), BorderLayout.CENTER);
	}
}
