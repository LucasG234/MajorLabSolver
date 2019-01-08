package codeGeneration;

import java.awt.*;
import java.util.*;

public class CreateCode
{
	/*
	 * Main generation of code
	 */
	public static String generateJava(String classTitle, Color[][] colorArray, int xStep, int yStep)
	{
		HashMap<Color, ArrayList<Coord>> map = parseArray(colorArray);
		
		String out = generateJavaHeader(classTitle);
		
		for(Color col : map.keySet())
		{
			if(col!=null)
			{
				out += String.format("\t\tg.setColor(new %s);%n", colorToString(col));
				
				for(Coord cor : map.get(col))
				{
					out += String.format("\t\tg.fillRect(%d,%d,%d,%d);%n", xStep*cor.c, yStep*cor.r, xStep, yStep);
				}
				
				out += "\n";
			}
		}
		
		out += generateJavaEnding();
		
		return out;
	}
	
	/*
	 * Converts the matrix of color values for pixels into 
	 * map of used colors to their relative pixel locations
	 */
	public static HashMap<Color, ArrayList<Coord>> parseArray(Color[][] in)
	{
		HashMap<Color, ArrayList<Coord>> map = new HashMap<>();
		
		for(int r = 0; r < in.length; r++)
			for(int c = 0; c < in[r].length; c++)
			{
				Color curr = in[r][c];
				
				if(!map.containsKey(curr))
					map.put(curr, new ArrayList<Coord>());
				
				map.get(curr).add(new Coord(r,c));
			}
		
		return map;
	}
	
	/*
	 * Converts color objects to String format usable in java code
	 */
	public static String colorToString(Color c)
	{
		return String.format("Color(%d,%d,%d)", c.getRed(), c.getGreen(), c.getBlue());
	}
	
	/*
	 * Create class and method declaration for java file
	 */
	public static String generateJavaHeader(String classTitle)
	{
		String out = "";
		out += "import java.awt.*;\nimport java.applet.*;\n\n";
		out += String.format("public class %s extends Applet%n", classTitle);
		out += "{\n";
		out += "\tpublic void paint(Graphics g)";
		out += "\t{\n\n";
		return out;
	}
	
	/*
	 * HTML runner file for Applet
	 */
	public static String generateHTML(String classFile, int xSize, int ySize)
	{
		return String.format("<APPLET CODE=\"%s\" WIDTH=%d HEIGHT=%d>%n</APPLET>", classFile, xSize, ySize);
	}
	
	/*
	 * Ending braces for java file
	 */
	public static String generateJavaEnding()
	{
		return "\t}\n}";
	}
	
	
	
}
