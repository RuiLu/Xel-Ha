public class NumberConversion {
	/**
	 * Convert a the representation of a number in one base to its representation in another base, 
	 * where the bases can range from 2 to 36.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "1110011001";
		String output = convertUnder16(input, 2, 35);
		System.out.println(output);
	}
	/**
	 * Idea: first convert the number to base 10, then convert the number to toBase
	 * 
	 * @param number
	 * @param fromBase
	 * @param toBase
	 * @return
	 */
	private static String convertUnder16(String number, int fromBase, int toBase) {
		if (number == null || number.length() == 0 || toBase == 0) return number;
		
		if (fromBase == toBase) return number;
		
		char[] ca = number.toCharArray();
		int len = ca.length;
		long baseTen = 0;
		
		// Convert the current number into 10-based number
		for (int i = len-1; i >= 0; i--) {
			int value = getIntFromChar(ca[i]);
			if (value >= fromBase) return "Error: Invalid input "+number+" for "+fromBase+"-based number.";
			baseTen += value*Math.pow(fromBase, len-1-i);
		}
		
		if (toBase == 10) return baseTen+"";
		
		// Convert 10-based number into toBase-based number.
		String res = "";
		
		while (baseTen != 0) {
			String str = getStringFromInt((int)baseTen%toBase);
			if (str.equals("-1")) return "Error.";
			res = str+res;
			baseTen /= toBase;
		}

		return res;
	}
	
	public static int getIntFromChar(char ch){
        return ch <= '9' && ch >= '0' ? ch-'0' : ch-'A'+10;
    }
	
	public static String getStringFromInt(int i) {
		String res = "";
		if (i >= 0 && i <= 9) res = i+"";
		else if (i > 9 && i < 36) res = String.valueOf((char)('A'+i-10));
		else res = "-1";
		return res;
	}
}

