package Amazon.OA2;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return "";
		if (s.length() == 1) return s;
		
		int lo = 0;
		int hi = 0;
		int maxLen = 0;
		
		for (int i = 0; i < s.length(); i++) {
			// for odd length
			for (int j = 0; i-j >= 0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j); j++) {
				if (2*j+1 > maxLen) {
					maxLen = 2 * j + 1;
					lo = i - j;
					hi = i + j;
				}
			}
			
			// for even length
			for (int j = 1; i-j+1 >= 0 && i + j < s.length() && s.charAt(i-j+1) == s.charAt(i+j); j++) {
				if (2 * j > maxLen) {
					maxLen = 2 * j;
					lo = i - j + 1;
					hi = i + j;
				}
			}
		}
		
		return s.substring(lo, hi + 1);
	}
}

