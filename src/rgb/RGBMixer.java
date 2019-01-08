package rgb;

import java.awt.*;
import javax.swing.*;

/*
 * This module contains the RBGMixer
 */
public class RGBMixer extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private int red, green, blue;
	private JFormattedTextField redField, greenField, blueField;
	
	public RGBMixer()
	{
		//Default color of black
		red = 0;
		green = 0;
		blue = 0;
		
		addMouseListener(new RGBMouseListener());
		addMouseMotionListener(new RGBMouseListener());
		
		setBackground(Color.WHITE);
		setOpaque(true);
		setFocusable(true);
		
		//textFields() creates a content pane which covers the panel, containing the text fields
		setLayout(new BorderLayout());
		add(textFields(), BorderLayout.CENTER);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//Draw Bars
		g2.setColor(new Color(red, green, blue));
		g2.fillRect(50, 50, 200, 100);
		
		g2.setColor(Color.RED);
		g2.fillRect(50, 160 + (255-red), 50, red);
		
		g2.setColor(Color.GREEN);
		g2.fillRect(125, 160 + (255-green), 50, green);
		
		g2.setColor(Color.BLUE);
		g2.fillRect(200, 160 + (255-blue), 50, blue);
		
		//Draw boundaries over bars
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(5));
		g2.drawRect(50, 50, 200, 100);
		g2.drawRect(50, 160, 50, 255);
		g2.drawRect(125, 160, 50, 255);
		g2.drawRect(200, 160, 50, 255);
	}
	
	private JPanel textFields()
	{
		JPanel pane = new JPanel();
		pane.setOpaque(false);
		
		//allows absolute positioning of Components
		pane.setLayout(null);
		
		RGBNumberFormatter formatter = new RGBNumberFormatter();
		
		redField = new JFormattedTextField(formatter);
		redField.getDocument().addDocumentListener(new RGBDocumentListener(Color.RED, this));
		redField.setValue(0);
		redField.setBounds(60,435,30,20);
		redField.setFocusable(true);
		
		greenField = new JFormattedTextField(formatter);
		greenField.getDocument().addDocumentListener(new RGBDocumentListener(Color.GREEN, this));
		greenField.setValue(0);
		greenField.setBounds(135,435,30,20);
		
		blueField = new JFormattedTextField(formatter);
		blueField.getDocument().addDocumentListener(new RGBDocumentListener(Color.BLUE, this));
		blueField.setValue(0);
		blueField.setBounds(210,435,30,20);
		
		pane.add(redField);
		pane.add(blueField);
		pane.add(greenField);
		
		return(pane);
	}
	
	public void setColor(Color c, int val)
	{
		if(c == Color.RED)
		{
			red = val;
		}
		else if(c == Color.BLUE)
		{
			blue = val;
		}
		else if(c == Color.GREEN)
		{
			green = val;
		}
		repaint();
	}
	
	public void setField(Color c, int val)
	{
		if(c == Color.RED)
		{
			redField.setValue(val);
		}
		else if(c == Color.BLUE)
		{
			blueField.setValue(val);
		}
		else if(c == Color.GREEN)
		{
			greenField.setValue(val);
		}
		repaint();
	}
	
	public Color getColor()
	{
		return new Color(red, green, blue);
	}
}
