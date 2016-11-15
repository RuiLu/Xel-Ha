package com.A9;

import java.util.ArrayList;

public class MyHashMap<K, V> {
	
	/* LinkedListNode class. Used only within the HashTable. No one else can access to it.
	 * Implemented as a doubled-linked list. */
	private static class LinkedListNode<K, V> {
		public K key;
		public V value;
		public LinkedListNode<K, V> prev;
		public LinkedListNode<K, V> next;
		public LinkedListNode(K k, V v) {
			key = k;
			value = v;
		}
	}
	
	private ArrayList<LinkedListNode<K, V>> arr;
	private static int size = 0;
	
	public MyHashMap(int capacity) {
		/* Create list of linked lists at a particular size. */
		arr = new ArrayList<LinkedListNode<K, V>>();
		arr.ensureCapacity(capacity);
		for (int i = 0; i < capacity; i++) {
			arr.add(null);
		}
	}
	
	/* Insert key and value into hashtable */
	public void put(K key, V value) {
		LinkedListNode<K, V> node = getNodeFromKey(key);
		if (node != null) {	// Already there, so just update value
			node.value = value;
			return;
		}
		
		size++;
		node = new LinkedListNode<K, V>(key, value);
		int index = getIndexFromKey(key);
		if (arr.get(index) != null) {
			node.next = arr.get(index);
			node.next.prev = node;
		}
		arr.set(index, node);
	}
	
	/* Remove node for key */
	public void remove(K key) {
		LinkedListNode<K, V> node = getNodeFromKey(key);
		if (node == null) return;
		
		size--;
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			/* Remove head, update */
			int index = getIndexFromKey(key);
			arr.set(index, node.next);
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}
	
	/* Get value for key */
	public V get(K key) {
		LinkedListNode<K, V> node = getNodeFromKey(key);
		return node == null ? null : node.value;
	}
	
	/* Get LinkedListNode<K, V> associated with a given key */
	private LinkedListNode<K, V> getNodeFromKey(K key) {
		int index = getIndexFromKey(key);
		LinkedListNode<K, V> content = arr.get(index);
		while (content != null) {
			if (content.key == key) return content;
			content = content.next;
		}
		return null;
	}
	
	/* Really naive method to map a key to an index */
	private int getIndexFromKey(K key) {
		return Math.abs(key.hashCode() % arr.size());
	}
	
	public static void main(String[] args) {
		MyHashMap<Integer, Integer> mhm = new MyHashMap<Integer, Integer>(128);
		mhm.put(1, 10);
		mhm.put(2, 9);
		mhm.put(3, 7);
		mhm.put(4, 6);
		mhm.put(5, 5);
		
		System.out.println("size: " + size);
		System.out.println(mhm.get(2));
		System.out.println(mhm.get(5));
		
		mhm.put(2, 100);
		mhm.remove(5);
		
		System.out.println("size: " + size);
		System.out.println(mhm.get(2));
		System.out.println(mhm.get(5));
	}
}

