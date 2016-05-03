package com.tp.pool;

/**
 * Represents an abstract pool, that defines the procedure
 * of returning an object to the pool.
 * 
 * @author Pritish Chandak
 *
 * @param < T > the type of pooled objects.
 */
abstract class AbstractPool < T > implements Pool < T >
{
 
 public final void release(T t)
 {
  if(isValid(t))
  {
   returnToPool(t);
  }
  else
  {
   handleInvalidReturn(t);
  }
 }
 
 protected abstract void handleInvalidReturn(T t);
 
 //protected abstract boolean isMinimumPoolSize(T t);
 
// protected abstract boolean isMaximumPoolSize(T t);
 
 protected abstract void returnToPool(T t);
 
 protected abstract boolean isValid(T t);
}
