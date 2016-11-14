package com.A9;

import java.util.*;

/**
 * Idea -> First sort, then two pointers
 * Time complexity -> O(nlogn)
 * @author Rui
 */
public class PairSum {
	public static void main(String[] args) {
		int[] arr = new int[]{7, 4, 10, -6, -2, 13, 2, 0, 17, 9, 6, 15, -4};
		int target = 13;
		
		PairSum ps = new PairSum();
		List<List<Integer>> res = ps.findPairSum(arr, target);
		
		for (List<Integer> pair : res) {
			System.out.println(pair.get(0) + "+" + pair.get(1) + "=" + target);
		}
	}
	
	public PairSum() {}
	
	private List<List<Integer>> findPairSum(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (arr == null || arr.length == 0) return res;
		
		Arrays.sort(arr);
		int lo = 0;
		int hi = arr.length - 1;
		
		while (lo < hi) {
			int sum = arr[lo] + arr[hi];
			if (sum == target) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(arr[lo++]);
				tmp.add(arr[hi--]);
				res.add(new ArrayList<>(tmp)); 
			} else if (sum > target) {
				hi--;
			} else {
				lo++;
			}
		}
		
		return res;
	}
}

