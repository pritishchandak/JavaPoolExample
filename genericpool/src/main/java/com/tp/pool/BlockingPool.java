package com.tp.pool;
import java.util.concurrent.TimeUnit;

/**
 * Represents a pool of objects that makes the 
 * requesting threads wait if no object is available.
 * 
 * @author Pritish Chandak
 *
 * @param < T > the type of objects to pool.
 */
public interface BlockingPool < T > extends Pool < T >
{
 
 T get();
  
 T get(long time, TimeUnit unit) throws InterruptedException;
}