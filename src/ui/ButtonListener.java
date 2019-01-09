package ui;

import java.awt.event.*;
import javax.swing.*;
import codeGeneration.*;

public class ButtonListener implements ActionListener
{
	private int xStep;
	private int yStep;
	private PixelPanel source;
	
	public ButtonListener(PixelPanel source)
	{
		this.xStep = source.xStep;
		this.yStep = source.yStep;
		this.source = source;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		JButton button = (JButton)e.getSource();
		
		if(command.equals("Save"))
		{
			System.out.println(CreateCode.generateJava("Test", source.colors, xStep, yStep));
		}
		else if(command.equals("Clear"))
		{
			source.clear();
		}
		else if(command.equals("ToFill"))
		{
			button.setText("Current drawing style: Fill");
			button.setActionCommand("ToBrush");
			source.setDraw("Fill");
		}
		else if(command.equals("ToBrush"))
		{
			button.setText("Current drawing style: Brush");
			button.setActionCommand("ToFill");
			source.setDraw("Brush");
		}
	}

}
