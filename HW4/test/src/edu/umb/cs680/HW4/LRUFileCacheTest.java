package edu.umb.cs680.HW04;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class LRUFileCacheTest
{
	@Test
	public void cdisplay()
	{
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
        LinkedList expected = new LinkedList(Arrays.asList(3,5,4,1));
        assertEquals(expected,cache.display());
	}
}