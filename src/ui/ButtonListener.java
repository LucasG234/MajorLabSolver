package ui;

import java.awt.event.*;

import codeGeneration.CreateCode;

public class ButtonListener implements ActionListener
{
	private int xStep;
	private int yStep;
	private PixelPanel source;
	
	public ButtonListener(int xStep, int yStep, PixelPanel source)
	{
		this.xStep = xStep;
		this.yStep = yStep;
		this.source = source;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		
		if(command.equals("Save"))
		{
			System.out.println(CreateCode.generateJava("Test", source.colors, xStep, yStep));
		}
		if(command.equals("Clear"))
		{
			source.clear();
		}
	}

}
