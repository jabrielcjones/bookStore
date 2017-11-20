/** BookCourier.java **/
/** Jabriel C. Jones */
/** CSCI 340 Sp. 2012 */
/**
 * Member(username, last_name, first_name, email, password, street,
 *        city, state, zip, card_type, card_no, expiration,
 *        name_on_card)
 * Book(isbn, title, author, publisher, edition, keyword)
 * Books_for_sale(listing_no, seller, isbn, condition, price)
 * Orders(order_no, buyer, order_date, total)
 * Items(order_no, listing_no)
 * 
 * 
 * 1. Construct SQL Statements
 * 2. Construct SQL Transaction
 * 3. Construct Java Code
 *
 * Create new connection to database in each method of the class
 */
import java.sql.*;
import java.io.*;
import java.util.*;



public class BookCourier
{
   public BookCourier()
   {
   }
   
	/** checkISBN
	 * 		select book with given isbn
	 */
   public boolean checkISBN(String isbn)
   {
      System.out.println("checkISBN is called.");

      boolean     found = false;

      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();
         System.out.println("Connected to the Database");

         /** TASK */
          //check to see if book is already in db
         PreparedStatement select = connection.prepareStatement("select isbn from book where isbn = ?");
         select.setString(1, isbn);
         ResultSet result = select.executeQuery();

         if(result.next())
            return true;
         else
            return false;
         
         
      } // try      
      catch (IOException e)
      {
         System.out.println("Oops! Something went wrong!\nUnable to Connect to the Database");
      } // catch
      catch (SQLException e)
      {
         System.out.println("Oops! Something went wrong!\nUnable to Disconnect from the Database");
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
               System.out.println("Oops! Something went wrong!\nUnable to Disconnect from the Database");
            } // catch
         } // if
      } // finally

      return false;
   }

   public Book getBook(String isbn)
   {
      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();
         
         /** TASK */
         String      b_isbn;
         String      title;
         String      author;
         String      publisher;
         int         edition;
         String      keywords;
         
         PreparedStatement select = connection.prepareStatement("select * from book where isbn = ?");
         select.setString(1, isbn);
         ResultSet result = select.executeQuery();
         result.next();

         b_isbn = result.getString(1);
         if (result.wasNull())
         {
            b_isbn = null;
         } // if

         title = result.getString(2);
         if (result.wasNull())
         {
            title = null;
         } // if

         author = result.getString(3);
         if (result.wasNull())
         {
            author = null;
         } // if

         publisher = result.getString(4);
         if (result.wasNull())
         {
            publisher = null;
         } // if

         edition = result.getInt(5);
         if (result.wasNull())
         {
            edition = 0;
         } // if

         keywords = result.getString(6);
         if (result.wasNull())
         {
            keywords = null;
         } // if

         Book book = new Book(b_isbn, title, author, publisher, edition, keywords);

         return book;
      } // try      
      catch (IOException e)
      {
         System.out.println("Oops! Something went wrong!\nUnable to Connect to the Database");
      } // catch
      catch (SQLException e)
      {
         System.out.println("Oops! Something went wrong!\nUnable to Connect to the Database");
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
               System.out.println("Oops! Something went wrong!\nUnable to Disconnect from the Database");
            } // catch
         } // if
      } // finally

      return null;

   }//getBook
}//BookCourier

