/**
 * From Leetcode
 */
public class Solution {
    /**
     *  Time complexity -> O(n)
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        
        int[] c = new int[256];
        int res = 0;
        
        for (char ch : s.toCharArray()) {
            c[ch]++;
            res += (c[ch] % 2 != 0) ? 1 : -1;
        }
        
        return res <= 1;
    }
}

/**
 * From eclipse
 */
package com.palindrome;

import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		
		String string = "carerac";
		System.out.println("The result is " + palindromePermutation(string));
		
//		String str = "aaaabbbb";
//		List<String> res = palindromePermutationII(str);
//		System.out.println(res);
		
	}
	
	public static boolean palindromePermutation(String s) {
		if (s == null || s.length() == 0) return false;
		if (s.length() == 1) return true;
		int[] counts = new int[256];
		int odd = 0;
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (counts[curr] == 0 || counts[curr] == -1) counts[curr] = 1;
			else if (counts[curr] == 1) counts[curr] = -1;
			odd += counts[curr];
		}
		return odd <= 1;
	}
	
	
	
}

