package Amazon.OA2;

/*
 * 给两个长方形的topLeft和bottomRight坐标, 判断这两个长方形是否重叠
 */
class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class OverlapRectangle {
	
	public static void main(String[] args) {
		Point l1 = new Point(-3, 4);
		Point r1 = new Point(3, 0);
		Point l2 = new Point(4, 2);
		Point r2 = new Point(9, -1);
		System.out.println(check(l1, r1, l2, r2));
	}
	
	// Returns true if two rectangles (l1, r1) and (l2, r2) overlap
	private static boolean check(Point l1, Point r1, Point l2, Point r2) {
		if (l1.x > r2.x || l2.x > r1.x) return false;
		if (l1.y < r2.y || l2.y < r1.y) return false;
		return true;
	}
}

