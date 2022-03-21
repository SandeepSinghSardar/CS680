package edu.umb.cs680.HW4;

import java.util.*;

public class FIFOFileCache<K,V> implements Cache<K,V> 
{
	private Map<K,V> cache;
	private Queue<K> queue;
	private int capacity;// Maximum cache capacity 
	public FIFOFileCache(int capacity)
	{
		this.cache = new HashMap<>(capacity);
		this.queue = new ArrayDeque<>(capacity);
		this.capacity = capacity;
	}
	@Override
	public V get(K key)
	{
		return cache.get(key);
	}
	@Override
	public void put(K key, V value) 
	{
		// First judge whether the value to be stored already exists 
		V oldValue = cache.get(key);
		// The cache does not exist 
		if(oldValue == null)
		{
			// We need to check whether the cache capacity is full 
			// If the cache is full ：FIFO Mechanism to delete cache 
			if(cache.size() == capacity)
			{
				// Delete team leader element 
				K oldKey = queue.poll();
				// Remove the element to be eliminated from the cache 
				cache.remove(oldKey);
			}
			// Then new key Save to the end of the team 
			queue.offer(key);
		}
		// Finally, it is stored in the cache 
		cache.put(key,value);
	}
	// The test sample 
	public static void main(String[] args) 
	{
		System.out.println("FIFO Cache Implementation");
		FIFOFileCache<Integer,Integer> cache = new FIFOFileCache<>(3);
		cache.put(1,1);
		cache.put(2,2);
		cache.put(3,3);
		cache.put(4,4);
		System.out.println(cache.get(3));
		cache.put(4,5);
		System.out.println(cache.get(4));
		cache.put(5,6);
		System.out.println(cache.get(2));
	}
}