package com.MaximumArray;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[] test = {1, -1, 5, -2, 3}; 
		System.out.println("The result for OnePass is " + maxSubArrayLen_OnePass(test, 3));
		System.out.println("The result for BruteForce is " + maxSubArrayLen_BruteForce(test, 3));
	}

	// One pass
	public static int maxSubArrayLen_OnePass(int[] nums, int k) {
	/*
	 * Some explanations: 
	 * 1. (0, -1) should be put in the map in the very beginning as the initia value
	 * 2. Keeping track of cumulative sum, if there is already an equal sum in the map,
	 *    ignore the latter, because we want the longest length
	 * 3. Using (sum - k) to determine whether the sum of a certen subarray is k! Awesome. 
	 */
		if (nums == null || nums.length == 0) return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int maxLen = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if (map.containsKey(sum - k)) {
				int prevIndex = map.get(sum - k);
				maxLen = Math.max(maxLen, i - prevIndex);
			}
		}
			
		return maxLen;
	}
	
	// Brute force
	public static int maxSubArrayLen_BruteForce(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) {
			if (nums[0] == k) return 1;
			else return 0;
		}
		
		int maxLen = 0;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int sum = 0;
				int len = 0;
				for (int x = i; x <= j; x++) {
					len++;
					sum += nums[x];
				}
				if (sum == k) maxLen = Math.max(maxLen, len);
			}
		}
		
		return maxLen;
	}
	
}

