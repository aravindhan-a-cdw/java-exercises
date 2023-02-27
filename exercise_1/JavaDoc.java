package exercise_1;

public class JavaDoc {

	public static void main(String[] args) {
		Point p1 = new Point(10, 5);
		System.out.println(p1);
	}

}

/**
 * This is a Point class created by me to denote a point.
 * 
 * @author Aravindhan
 * 
 *
 */
class Point {
	private int x;
	private int y;

	/**
	 * This is a Point class constructor to initiate a point.
	 * 
	 * @author Aravindhan
	 * 
	 * @param is the x axis
	 * @param y  is the y axis
	 *
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + x + ", " + y + ")";
	}
}
