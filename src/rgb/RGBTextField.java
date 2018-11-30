package rgb;

import java.awt.*;
import java.text.*;

import javax.swing.*;
import javax.swing.text.*;

public class RGBTextField extends JFormattedTextField
{
	public RGBTextField(NumberFormatter n)
	{
		super(n);
		
		setPreferredSize(new Dimension(100,100));
	}
	
	public static NumberFormatter createRGBFormatter()
	{
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(255);
		//Allows user to type invalid characters initially before they are stripped away
		formatter.setAllowsInvalid(true);
		
		return formatter;
	}
}
