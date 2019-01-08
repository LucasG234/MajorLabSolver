package ui;

import java.awt.event.*;

import codeGeneration.CreateCode;

public class SaveListener implements ActionListener
{
	private int xStep;
	private int yStep;
	private PixelPanel source;
	
	public SaveListener(int xStep, int yStep, PixelPanel source)
	{
		this.xStep = xStep;
		this.yStep = yStep;
		this.source = source;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(CreateCode.generateJava("Test", source.colors, xStep, yStep));
	}

}
