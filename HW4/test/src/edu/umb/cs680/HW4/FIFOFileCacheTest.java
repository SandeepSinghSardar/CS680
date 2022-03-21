package edu.umb.cs680.HW4;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.HW04.FIFOFileCache;

class FIFOFileCacheTest
{
	@Test
	public void put()
	{
		FIFOFileCache cache = new FIFOFileCache(2);
        cache.put(3, 1);
        cache.put(5, 10);

        assertEquals(1, cache.get(3));
        assertEquals(10, cache.get(5));
        for (int i = 6; i < 10; i++) 
        {
            assertEquals(null, cache.get(i));
        }
    }
}