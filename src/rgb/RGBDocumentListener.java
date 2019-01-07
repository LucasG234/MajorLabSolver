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
		} catch (BadLocationException e1)
		{
			e1.printStackTrace();
		}
		
		int num = 0;
		if(text.length() > 0)
		{
			num = Integer.parseInt(text);
		}
		
		if(num > -1 && num < 256)
		{
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
