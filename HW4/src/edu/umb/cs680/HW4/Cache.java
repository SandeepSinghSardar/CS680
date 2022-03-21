package edu.umb.cs680.HW4;

public interface Cache<K,V>
{
	// take 
	V get(K key);
	// save 
	void put(K key , V value);
}