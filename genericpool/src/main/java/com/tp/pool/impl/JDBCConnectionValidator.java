package com.tp.pool.impl;

import java.sql.Connection;
import java.sql.SQLException;
import com.tp.pool.Pool.Validator;

public  class JDBCConnectionValidator 
    implements Validator < Connection >
{
 public boolean isValid(Connection con)
 { 
  if(con == null)
  {
   return false;
  }
  
  try
  {
   return !con.isClosed();
  }
  catch(SQLException se)
  {
   return false;
  }
 }
 
 public void invalidate(Connection con)
 {
  try
  {
   con.close();
  }
  catch(SQLException se)
  {
   
  }
 }
}