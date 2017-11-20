// file name -- TestConnection.java
// type -- class
// uses -- DBConnection

// This class is used to test to see if the class DBConnection works.

import java.io.*;
import java.sql.*;

public class TestConnection
{
   static public void main(String args[]) throws IOException
   {
      Connection connection;
      DBConnection jdbc;

      jdbc = new DBConnection();
      connection = jdbc.getConnection();
      if (connection != null)
      {
         System.out.println("Connection is established");
         try
         {
            connection.close();
         }

         catch (SQLException e)
         {
            e.printStackTrace();
         } // catch
      } // if
      else
         System.out.println("Connection failed");
   } // end main

} // class TestConnection
