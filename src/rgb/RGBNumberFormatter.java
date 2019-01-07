package rgb;

import java.text.*;
import javax.swing.text.*;

public class RGBNumberFormatter extends NumberFormatter
{
	private static final long serialVersionUID = 1L;

	public RGBNumberFormatter()
	{
		super(NumberFormat.getInstance());
		
		setValueClass(Integer.class);
		setMinimum(0);
		setMaximum(255);
		//Allows user to type invalid characters initially before they are stripped away
		setAllowsInvalid(true);
	}
}
