package point;


/** 
 * This class specifies and stores a Point with an x and an y. 
 * It also contains methods to modify the Point.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 18:15, September 8, 2015.
 */
public class Point {
	
	// Member fields.
	private int x;
	private int y;

	/**
	 * Constructor which sets x and y to 0.
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Constructor which sets x and y to specific values.
	 * 
	 * @param x  coordinate
	 * @param y  coordinate
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {
		
		Point p1 = new Point();
		Point p2 = new Point(3,4);
				
		System.out.println(p1.toString());   // ==> (0,0)
		System.out.println(p2.toString());   // ==> (3,4)
				
		if (p1.isEqualTo(p2))              // False!
			System.out.println("The two points are equal");
				
		double dist = p1.distanceTo(p2);
		System.out.println("Point Distance: " + dist);
				
		p2.move(5,-2);         // ==> (8,2)
		p1.moveToXY(8,2);      // ==> (8,2)

		if (p1.isEqualTo(p2))              // True!
			System.out.println("The two points are equal");
	}

	/**
	 * Provides a new set of coordinates to a Point.
	 * 
	 * @param x  coordinate
	 * @param y  coordinate
	 */
	private void moveToXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Moves the Point to a new position.
	 * 
	 * @param x  coordinate
	 * @param y  coordinate
	 */
	private void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * Computes the distance between two Points.
	 * 
	 * @param p2	the second Point to compare with
	 * @return		the distance between two Points
	 */
	private double distanceTo(Point p2) {
		return Math.sqrt(Math.pow(p2.x - x, 2) + Math.pow(p2.y - y, 2));
	}

	/**
	 * Checks if two Points is equal to each other.
	 * 
	 * @param p2	the second Point to compare with
	 * @return		if the Points were equals			
	 */
	private boolean isEqualTo(Point p2) {
		return x == p2.x && y == p2.y;
	}
	
	/**
	 * Returns a string which, if printed, provides a nice looking print out of the Point content.
	 * 
	 * @return	a pretty String
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
