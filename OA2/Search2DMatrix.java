package Amazon.OA2;

/*
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 */
public class Search2DMatrix {
	
	public static void main(String[] args) {
		Search2DMatrix s2m = new Search2DMatrix();
		int[][] matrix = {{1, 3, 5, 7},
						{10, 11, 16, 20},
						{23, 30, 34, 50}};
		System.out.println(s2m.searchMatrix(matrix, 12));
	}
	
	public Search2DMatrix() {
		
	}
	
	/**
	 * Idea -> 1. do binary search on the last column,
	 * 		   2. do binary search on the chosen row 
	 * Time complexity -> O(logm + logn)
	 * Space complexity -> O(1)
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	private boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int lo = 0;
		int hi = m - 1;
		
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (matrix[mid][n-1] < target) lo = mid + 1;
			else hi = mid;
		}
		
		int rowIdx = hi;
		lo = 0;
		hi = n - 1;
		
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (matrix[rowIdx][mid] == target) return true;
			else if (matrix[rowIdx][mid] > target) hi = mid - 1;
			else lo = mid + 1;
		}
		
		return false;
	}
}

