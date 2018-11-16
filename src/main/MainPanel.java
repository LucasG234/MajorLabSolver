package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JFrame
{
	public MainPanel()
	{
		super("Stites Lab Cheater");
		setSize(700,600);
		
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(right(), BorderLayout.EAST);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JPanel right()
	{
		JPanel right = new JPanel();
		right.setBackground(Color.RED);
		
		return right;
	}
}
