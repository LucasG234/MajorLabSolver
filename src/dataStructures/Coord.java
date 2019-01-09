package dataStructures;

/*
 * Class used easily to store relative pixel locations
 */
public class Coord
{
	public int r;
	public int c;
	
	public Coord(int r, int c)
	{
		this.r = r;
		this.c = c;
	}
	
	public String toString()
	{
		return String.format("[%d, %d]", r, c);
	}
}
