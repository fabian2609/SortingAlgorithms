package Version2;
import java.awt.Color;
/**
 * @author Fabian Menn 
 * @version 21.11.2018
 */
public class Bar implements Comparable<Bar> {
	
	private int length;
	private Color bColor;

	public Bar (int length)
	{
		this.length = length;
		bColor = Color.BLACK;
	}
	
	public Color getColor()
	{
		return bColor;
	}
	
	public void setColor(Color bColor)
	{
		this.bColor = bColor;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}

	@Override
	public int compareTo(Bar other) {
		/*if (other.getLength() < length)
			return 1;
		else if (other.getLength() > length)
			return -1;
		else 
			return 0;*/
		
		return  Integer.compare(this.length, other.length);
	}

}

