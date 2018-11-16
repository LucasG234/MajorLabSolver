package codeGeneration;

import java.awt.*;
import java.util.*;

public class CreateCode
{
	//Main method used for testing purposes only
	public static void main(String[] args)
	{
		Color[][] testArr = new Color[2][2];
		
		testArr[0][0] = Color.RED;
		testArr[1][0] = Color.RED;
		testArr[0][1] = Color.BLUE;
		testArr[1][1] = Color.RED;
		
		System.out.println(generateJava("Picture", testArr));
	}
	
	
	public static String generateJava(String classTitle, Color[][] colorArray)
	{
		HashMap<Color, ArrayList<Coord>> map = parseArray(colorArray);
		
		String out = generateJavaHeader(classTitle);
		for(Color c : map.keySet())
		{
			if(c!=null)
			{
				out += String.format("\t\tg.setColor(new %s);%n", colorToString(c));
			}
		}
		
		return out;
	}
	
	/*
	 * Converts color objects to String format usable in java code
	 */
	public static String colorToString(Color c)
	{
		return String.format("Color(%d,%d,%d)", c.getRed(), c.getGreen(), c.getBlue());
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
	
	/*
	 * Creates Runner HTML File for Applet
	 */
	public static String generateHTML(String classFile, int xSize, int ySize)
	{
		return String.format("<APPLET CODE=\"%s\" WIDTH=%d HEIGHT=%d>%n</APPLET>", classFile, xSize, ySize);
	}
}

