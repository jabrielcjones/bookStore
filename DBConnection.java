// file name -- DBConnection.java
// type -- class

// This class will be used to open a connection to a database via the
// url and the  JDBC driver, this program is run with no arguments
// passed to the program at run time.
/** Jabriel C. Jones */
/** CSCI 340 Sp. 2012 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;

public class DBConnection
{
   Connection connection = null;

   DBConnection () throws IOException
   {
      String driver;
      String user;
      String password;
      String url;

      DataInput infile = new DataInputStream
                        (new FileInputStream("secret.dat"));

      driver = infile.readLine();
      user = infile.readLine();
      password = infile.readLine();
      url = infile.readLine();

      try
      { // attempts to load the driver
         Class.forName(driver).newInstance();
      } // try

      catch (Exception e)
      { // problem loading driver, trace steps.
         e.printStackTrace();
         return;
      } // catch

      try
      {
         connection = DriverManager.getConnection(url, user, password);
      } // try

      catch (SQLException e)
      {
         e.printStackTrace();
      } // catch
   } // constructor DBConnection


   Connection getConnection()
   {
      return connection;
   }  // method getConnection


   boolean isConnected()
   {
      return (connection != null);
   }  // method isConnected

   void close() throws SQLException
   {
      connection.close();
   }  // method close

} // class DBConnection
