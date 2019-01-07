package rgb;

import javax.swing.event.*;
import javax.swing.text.*;

import java.awt.Color;

public class RGBDocumentListener implements DocumentListener
{
	Color col;
	RGBMixer source;
	
	public RGBDocumentListener(Color c, RGBMixer source)
	{
		this.col = c;
		this.source = source;
	}
	
	public void insertUpdate(DocumentEvent e)
	{
		Document doc = e.getDocument();
		String text = "";
		try
		{
			text = doc.getText(0, doc.getLength());
		} catch(BadLocationException e1) //should never be accessed
		{
			e1.printStackTrace();
		}
		
		int num = 0;
		if(text.length() > 3)
		{
			num = 255;
		}
		else if(text.length() > 0)
		{
			try 
			{
			num = Integer.parseInt(text);
			} catch(java.lang.NumberFormatException e1) 
			{
				//No change if non number is entered
				//Formatted text box will reset if non number is left in
			}
		}
		
		//numbers between 255 & 999 are read in but set to 255
		if(num > -1)
		{
			if(num > 256)
				num = 255;
			source.setColor(col, num);
		}
	}

	public void removeUpdate(DocumentEvent e)
	{
		insertUpdate(e);
	}
	
	//unused in TextFields without styling
	public void changedUpdate(DocumentEvent e)
	{
	}
}
