package codeGeneration;

import java.awt.*;
import java.util.*;
import java.awt.image.*;

public class CreateCode
{
	//Main method used for testing purposes only
//	public static void main(String[] args)
//	{
//		Color[][] testArr = new Color[2][2];
//		
//		testArr[0][0] = Color.RED;
//		testArr[1][0] = Color.RED;
//		testArr[0][1] = Color.BLUE;
//		testArr[1][1] = Color.RED;
//		
//		System.out.println(generateJava("Picture", testArr, 10, 10));
//	}
	
	/*
	 * Main method to generate the java code
	 */
	public static String generateJava(String classTitle, BufferedImage screenshot, int xStep, int yStep)
	{
		HashMap<Color, ArrayList<Coord>> map = parseArray(convertBufferedImage(screenshot, xStep, yStep));
		
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
	 * This method will convert image into an array
	 * Handles the pixel logic
	 * Currently in progress
	 */
	public static Color[][] convertBufferedImage(BufferedImage bi, int xStep, int yStep)
	{
		return null;
	}
	
	/*
	 * Converts the matrix of color values for pixels into 
	 * Map of used colors to their relative pixel locations
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
		out += "import java.awk.*;\nimport java.applet.*;\n\n";
		out += String.format("public class %s extends Applet%n", classTitle);
		out += "{\n";
		out += "\t{\n";
		return out;
	}
	
	public static String generateJavaEnding()
	{
		String out = "";
		out+= "\t}\n";
		out+="}";
		return out;
	}
	
	/*
	 * Creates Runner HTML File for Applet
	 */
	public static String generateHTML(String classFile, int xSize, int ySize)
	{
		return String.format("<APPLET CODE=\"%s\" WIDTH=%d HEIGHT=%d>%n</APPLET>", classFile, xSize, ySize);
	}
	
}

