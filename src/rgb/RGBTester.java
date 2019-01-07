package rgb;

import javax.swing.*;
//THIS CLASS USED ONLY TO TEST RGBMixer INDIVIDUALLY
public class RGBTester extends JFrame
{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		RGBTester app = new RGBTester();
		app.setVisible(true);
	}
	
	public RGBTester()
	{
		super("RGB Tester");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(325,600);
		
		add(new RGBMixer());
	}
}
