package com.A9;

import java.util.HashMap;

public class MyHashSet<T> {

	private HashMap<T, Object> map;
	private static final Object PRESENT = new Object();
	
	public MyHashSet() {
		map = new HashMap<T, Object>();
	}
	
	public boolean add(T t) {
		return map.put(t, PRESENT) == null;
	}
	
	public int size() {
		return map.size();
	}
	
	public boolean remove(T t) {
		return map.remove(t) == PRESENT;
	}
	
	public boolean contains(T t) {
		return map.containsKey(t);
	}
	
	public static void main(String[] args) {
		MyHashSet<String> mhs = new MyHashSet<String>();
		mhs.add("hello");
		mhs.add("world");
		
		System.out.println("size: " + mhs.size());
		
		mhs.remove("world");
		
		System.out.println("size: " + mhs.size());
		
		if (!mhs.add("hello")) {
			System.out.println("hello is already in the set.");
		}
		
	}
}

