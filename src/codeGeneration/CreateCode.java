package codeGeneration;

import java.awt.*;
import java.util.*;

public class CreateCode
{
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
	
	public static String generateJava(HashMap<Color, ArrayList<Coord>> map)
	{
		String out = "";
		
		return out;
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

