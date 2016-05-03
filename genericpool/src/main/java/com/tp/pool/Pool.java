package com.tp.pool;

/**
 * Represents a cached pool of objects.
 * 
 * @author Pritish Chandak
 *
 * @param < T > the type of object to pool.
 */
public interface Pool< T >
{
 
 T get();
   
 void release(T t);
  
 void shutdown();
 
 
 public static interface Validator < T >
 {
  
  public boolean isValid(T t);
     
  public void invalidate(T t);
 }
}