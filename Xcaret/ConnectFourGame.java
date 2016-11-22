public class ConnectFour {
	
	private static char[][] grid = null;
	private static final int ROW = 6;
	private static final int COL = 7;
	
	public static void main(String[] args) {
		grid = new char[ROW][COL];
		String input = "10_r3_brbrbr_3b2rb_b2r2br_r2b3rb";
		if (deserialize(input)) {
			System.out.println("Input is valid.\n");
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					System.out.print(grid[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Input is invalid.");
		}
	}
	
	/**
	 * 	corner cases：
	 *	1. number count overflow
	 *	2. number count underflow
	 *	3. invalid char
	 *	4. invalid digit -> 0 or 1
	 *	5. Last char is digit.
	 */
	private static boolean deserialize(String input) {
		char[] ica = input.toCharArray();
		int i = 0;
		int j = 0;
		int index = 0;
		int count = 0;
		
		while (index < ica.length) {
			char curr = ica[index];
			if (curr >= '1' && curr <= '9') {
				while (index < ica.length && Character.isDigit(ica[index])) {
					count = count * 10 + (ica[index] - '0');
					index++;
				}
				if (index == ica.length) {
					System.out.println("Error: Last char of string is digit.");
					return false;
				}
				if (count > 42) {
					System.out.println("Error: Number count overflow, which is bigger than 42.");
					return false;
				}
				if (count == 1 || count == 0) {
					System.out.println("Error: Invalid count.");
					return false;
				}
				index--;
			} else if ((curr >= 'a' && curr <= 'z') || curr == '_') {
				if (count == 0) count = 1;
				while (count > 0) {
					if (i == 6 && j == 0) {
						System.out.println("Error: Number count overflow.");
						return false;
					}
					grid[i][j] = curr;
					i = (j + 1 == 7 ? i + 1 : i);
					j = (j + 1 == 7 ? 0 : j + 1);
					count--;
				}
			} else {
				System.out.println("Error: Invalid input.");
				return false;
			}
			index++;
		}
		
		if (i != 6 && j != 0) {
			System.out.println("Error: Number count underflow.");
			return false;
		}
		
		return true;
	}
}

