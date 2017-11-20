// file name -- Sales4.java
// type -- class

// SQL INJECTION MITIGATION --> Bound parameters

// This class will be used to open a connection to a database via the
// url and the JDBC driver. It will display salesperson's name and
// commission earned.

import java.sql.*;
import java.io.*;
import java.util.*;

public class Sales4
{
  static public void main(String args[]) throws IOException
  {
      Connection connection = null;
      DBConnection jdbc;

      try
      {
         String slsrep_name;
         float commission;
         Scanner stdin;
         String sql;

         jdbc = new DBConnection();
         connection = jdbc.getConnection();
         PreparedStatement select = connection.prepareStatement("SELECT slsrep_name, commission FROM slsrep WHERE slsrep_name = ?");
         System.out.print("Enter the name for sales name: ");
         stdin = new Scanner(System.in);
         slsrep_name = stdin.nextLine();
         select.setString(1, slsrep_name);

         //System.out.println("The SQL statement is <" + sql + ">");
         ResultSet result = select.executeQuery();

         System.out.println("Got Results");

         while(result.next())
         {
            slsrep_name = result.getString(1);
            if (result.wasNull())
            {
               slsrep_name = null;
            } //if

            commission = result.getFloat(2);

            if (result.wasNull())
            {
               commission = 0;
            } // if

            System.out.println("Salesman Name= " + slsrep_name);
            System.out.println("Commission = " + commission);
         } // while
      } // try

      catch (SQLException e)
      {
         e.printStackTrace();
      } // catch

      finally
      {
         if (connection != null)
         {
            try
            {
               connection.close();
            } // try

            catch (SQLException e)
            {
                  e.printStackTrace();
            } // catch
         } // if
      } // finally
   } // end main
} // class Sales4
