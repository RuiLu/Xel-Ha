package com.palantir;

import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortByFrequency {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,1,2,4,1,2,2,2};
		
		List<Integer> res1 = sortByBucket(arr);
		for (int i : res1) {
			System.out.print(i);
			System.out.print(" ");
		}
		
		System.out.println("\n====================");
		
		List<Integer> res2 = sortByFrequency(arr);
		for (int i : res2) {
			System.out.print(i);
			System.out.print(" ");
		}
	}
	
	/**
	 * 	Idea -> Bucket sort
	 *	Time complexity -> O(n)
	 *	Space complexity -> O(n)
	 */
	private static List<Integer> sortByBucket(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		/*
		 * Sometimes Java generics just doesn't let you do what you want to, 
		 * and you need to effectively tell the compiler that what you're doing really will be legal at execution time.
		 * I usually find this a pain when I'm mocking a generic interface, but there are other examples too. 
		 * It's usually worth trying to work out a way of avoiding the warning rather than suppressing it (the Java Generics FAQ helps here) 
		 * but sometimes even if it is possible, it bends the code out of shape so much that suppressing the warning is neater. 
		 * Always add an explanatory comment in that case!
		 */
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] list = new LinkedList[arr.length + 1];
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (list[freq] == null) {
				list[freq] = new LinkedList<>();
			}
			list[freq].add(key);
		}
		
		List<Integer> res = new LinkedList<>();
		for (int i = list.length - 1; i >= 0; i--) {
			LinkedList<Integer> tmp = list[i];
			if (tmp != null) {
				for (int num : tmp) {
					int count = map.get(num);
					while (count > 0) {
						res.add(num);
						count--;
					}
				}
			}
		}
		
		return res;
	}
	
	/**
	 * Time complexity -> O(nlogn)
	 * @param arr
	 */
	private static List<Integer> sortByFrequency(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		TreeMap<Integer, LinkedList<Integer>> tmap = new TreeMap<>();
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (!tmap.containsKey(freq)) tmap.put(freq, new LinkedList<>());
			tmap.get(freq).add(key);
		}
		
		List<Integer> res = new LinkedList<>();
		while (!tmap.isEmpty()) {
			Map.Entry<Integer, LinkedList<Integer>> me = tmap.pollLastEntry();
			LinkedList<Integer> tmp = me.getValue();
			for (int num : tmp) {
				int count = map.get(num);
				while (count > 0) {
					res.add(num);
					count--;
				}
			}	
		}
		
		return res;
	}
}

