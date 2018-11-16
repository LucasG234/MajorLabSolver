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
	
	public String generateJava(HashMap<Color, ArrayList<Coord>> map)
	{
		String out = "";
		
		return out;
	}
}

