package com.palindrome;

import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		
//		String string = "carerac";
//		System.out.println("The result is " + palindromePermutation(string));
		
		String str = "aaaabbbbc";
		List<String> res = palindromePermutationII(str);
		System.out.println(res);
		
	}
	
//	public static boolean palindromePermutation(String s) {
//		if (s == null || s.length() == 0) return false;
//		if (s.length() == 1) return true;
//		int[] counts = new int[256];
//		int odd = 0;
//		for (int i = 0; i < s.length(); i++) {
//			char curr = s.charAt(i);
//			if (counts[curr] == 0 || counts[curr] == -1) counts[curr] = 1;
//			else if (counts[curr] == 1) counts[curr] = -1;
//			odd += counts[curr];
//		}
//		return odd <= 1;
//	}
	
	public static List<String> palindromePermutationII(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) return res;
		
		// first part -> determine if s is palindrome
		int[] map = new int[256];
		String mid = "";
		int odd = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			map[curr]++;
			odd += map[curr] % 2 != 0 ? 1 : -1;
		}
		
		if (odd > 1) return res;
		
		// second part -> find middle string, which is not palindrome
		for (int i = 0; i < map.length; i++) {
			if (map[i] % 2 != 0) {
				mid += (char)i;
				map[i] = 0; // We need to set the mid value to 0, so it will not effect getAllPermutation function
				break;
			}
		}
		
		// third part -> find all possible permutations
		getAllPermutations(res, map, mid, s.length());
	
		return res;
	}
	
	
	// The key here is BackTracking!!!
	private static void getAllPermutations(List<String> res, int[] map, String mid, int len) {
		if (mid.length() == len) {
			res.add(mid);
		} else {
			for (int i = 0; i < map.length; i++) {
				if (map[i] <= 0) continue;
				map[i] -= 2; // we take out two element at one time.
				mid = (char)i + mid + (char)i;
				getAllPermutations(res, map, mid, len); // recursion
				map[i] += 2; // backtracking! 
				mid = mid.substring(1, mid.length() - 1);
			}
		}
	}
	
}

