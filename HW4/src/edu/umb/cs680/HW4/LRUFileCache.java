package edu.umb.cs680.HW4;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
 
public class LRUFileCache 
{
    // store keys of cache
    private Deque<Integer> doublyQueue; 
    // store references of key in cache
    private HashSet<Integer> hashSet;
    // maximum capacity of cache
    private final int CACHE_SIZE;
    LRUFileCache(int capacity) 
    {
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }
    /* Refer the page within the LRU cache */
    public void check(int page)
    {
        if (!hashSet.contains(page))
        {
            if (doublyQueue.size() == CACHE_SIZE)
            {
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        }
        else 
        {
            doublyQueue.remove(page);
        }
        doublyQueue.push(page);
        hashSet.add(page);
    }
    // display contents of cache
    public LinkedList display()
    {
    	LinkedList l=new LinkedList();
        Iterator<Integer> itr = doublyQueue.iterator();
        while (itr.hasNext()) {
        	l.add(itr.next());
        }
        return l;
    }
 
    public static void main(String[] args) 
    {
    	System.out.println("LRU Cache Implementation");
        LRUFileCache cache = new LRUFileCache(4);
        cache.check(1);
        cache.check(2);
        cache.check(3);
        cache.check(1);
        cache.check(4);
        cache.check(5);
        cache.check(3);
        cache.check(3);
        cache.check(3);
        System.out.println(cache.display());
    }
}