/** BooksForSaleCourier.java **/
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

 public class BooksForSaleCourier
{
   public BooksForSaleCourier()
   {
   }
   
   
	 
 	/** getUserPosts
 	 * Get books posted by user
	 * 		select relation via the BOOKS_FOR_SALE relation with attributes:
	 * 				seller member name
	 * 				isbn
	 * 				price
	 * 		select relation via the BOOKS relation with matching above isbn
	 */
	 public BookForSale[] getUserPosts(String username)
	 {

      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
         //get count of all posts by user
         PreparedStatement select1 = connection.prepareStatement("select count(listing_no) from books_for_sale where seller = ?");
         select1.setString(1, username);
         ResultSet result1 = select1.executeQuery();
         result1.next();

         int numberOfPosts = result1.getInt(1);
         if (result1.wasNull())
         {
            numberOfPosts = 0;
         } //if

         //declare and instantiate items array
         BookForSale[]     posts = new BookForSale[numberOfPosts];
         long              listing_no;
         String            seller;
         String            isbn;
         String            condition;
         double            price;
         
         //get all posts by user
         PreparedStatement select2 = connection.prepareStatement("select * from books_for_sale where seller = ?");
         select2.setString(1, username);
         ResultSet result2 = select2.executeQuery();

          // Table traversal
         int index = 0;
         while(result2.next())
         {
            listing_no = result2.getLong(1);
            if (result2.wasNull())
            {
               listing_no = 0;
            } // if
            
            seller = result2.getString(2);
            if (result2.wasNull())
            {
               seller = null;
            } //if

            isbn = result2.getString(3);
            if (result2.wasNull())
            {
               isbn = null;
            } //if

            condition = result2.getString(4);
            if (result2.wasNull())
            {
               condition = null;
            } //if

            price = result2.getDouble(5);
            if (result2.wasNull())
            {
               price = 0.00;
            } //if

            posts[index] = new BookForSale(listing_no, seller, isbn, condition, price);
            index++;
         } // while
         return posts;
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
               System.out.println("Oops! Something went wrong!\nUnable to Connect to the Database");
            } // catch
         } // if
      } // finally
      return null;
	 } //getUserPosts
	 
	 /** getPost
 	 * Get books posted by user
	 * 		select relation via the BOOKS_FOR_SALE relation with attributes:
	 * 				seller member name
	 * 				isbn
	 * 				price
	 * 		select relation via the BOOKS relation with matching above isbn
	 */
	 public BookForSale getPost(String isbn)
	 {    
      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
         long        listing_no;
         String      seller;
         String      b_ISBN;
         String      condition;
         double      price;

         /*
         String      title;
         String      author;
         String      publisher;
         int         edition;
         String      keywords;*/
         
         PreparedStatement select = connection.prepareStatement("select * from books_for_sale where isbn = ?");
         select.setString(1, isbn);
         ResultSet result = select.executeQuery();
         result.next();

         listing_no = result.getLong(1);
         if (result.wasNull())
         {
            listing_no = 0;
         } //if

         seller = result.getString(2);
         if (result.wasNull())
         {
            seller = null;
         } // if

         b_ISBN = result.getString(3);
         if (result.wasNull())
         {
            b_ISBN = null;
         } // if

         condition = result.getString(4);
         if (result.wasNull())
         {
            condition = null;
         } // if

         price = result.getDouble(5);
         if (result.wasNull())
         {
            price = 0.0;
         } // if

         BookForSale book = new BookForSale(listing_no, seller, b_ISBN, condition, price);

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
	 } // getPost




    /** getPost
 	 * Get books posted by user
	 * 		select relation via the BOOKS_FOR_SALE relation with attributes:
	 * 				seller member name
	 * 				isbn
	 * 				price
	 * 		select relation via the BOOKS relation with matching above isbn
	 */
	 public BookForSale getPost(Long listing_no)
	 {    
      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
         long        b_listing_no;
         String      seller;
         String      isbn;
         String      condition;
         double      price;

         /*
         String      title;
         String      author;
         String      publisher;
         int         edition;
         String      keywords;*/
         
         PreparedStatement select = connection.prepareStatement("select * from books_for_sale where listing_no = ?");
         select.setLong(1, listing_no);
         ResultSet result = select.executeQuery();
         result.next();

         b_listing_no = result.getLong(1);
         if (result.wasNull())
         {
            b_listing_no = 0;
         } //if

         seller = result.getString(2);
         if (result.wasNull())
         {
            seller = null;
         } // if

         isbn = result.getString(3);
         if (result.wasNull())
         {
            isbn = null;
         } // if

         condition = result.getString(4);
         if (result.wasNull())
         {
            condition = null;
         } // if

         price = result.getDouble(5);
         if (result.wasNull())
         {
            price = 0.0;
         } // if

         BookForSale book = new BookForSale(b_listing_no, seller, isbn, condition, price);

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
	 } // getPost



    	 /** getPosts
 	 * Get books posted by user
	 * 		select relation via the BOOKS_FOR_SALE relation with attributes:
	 * 				seller member name
	 * 				isbn
	 * 				price
	 * 		select relation via the BOOKS relation with matching above isbn
	 */
	 public BookForSale[] getPosts()
    {
      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
         long        listing_no;
         String      seller;
         String      isbn;
         String      condition;
         double      price;

         //get number of posts in BOOKS_FOR_SALE
         Statement select1 = connection.createStatement();
         String sql = "select count(listing_no) from books_for_sale";
         ResultSet result1 = select1.executeQuery(sql);
         result1.next();
         
         int numberOfPosts = result1.getInt(1);
         if (result1.wasNull())
         {
            numberOfPosts = 0;
         } //if

         //declare and instantiate posts array
         BookForSale[]    posts = new BookForSale[numberOfPosts];

         //get all posts from BOOKS_FOR_SALE
         Statement select2 = connection.createStatement();
         sql = "select * from books_for_sale";
         ResultSet result2 = select2.executeQuery(sql);

         // Table traversal
         int index = 0;
         while(result2.next())
         {
            listing_no = result2.getLong(1);
            if (result2.wasNull())
            {
               listing_no = 0;
            } //if

            seller = result2.getString(2);
            if (result2.wasNull())
            {
               seller = null;
            } // if

            isbn = result2.getString(3);
            if (result2.wasNull())
            {
               isbn = null;
            }

            condition = result2.getString(4);
            if (result2.wasNull())
            {
               condition = null;
            }

            price = result2.getDouble(5);
            if (result2.wasNull())
            {
               price = 0.0;
            }

            posts[index] = new BookForSale(listing_no, seller, isbn, condition, price);
            index++;
         } // while

         

         return posts;
         
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
	 } // getPosts
	
	
   
   /** removeBook
	 * 		remove book from BOOKS_FOR_SALE relation
	 */
  public void removePost(long listing_no, String username)
  {

     Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
          // delete post from BOOKS_FOR_SALE relation
         PreparedStatement select = connection.prepareStatement("delete from books_for_sale where listing_no = ? and seller = ?");
         select.setLong(1, listing_no);
         select.setString(2, username);
         int result = select.executeUpdate();
         
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
      } // finally */
  }// removePost
  
	/** insertBook
	 * 		insert book into BOOKS_FOR_SALE relation
	 */
  public void insertPost(BookForSale post)
  {

     Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();
         System.out.println("Connected to the Database");

         /** TASK */
         //generate listing_no
         Statement select1 = connection.createStatement();
         String sql = "select max(listing_no) from books_for_sale";
         ResultSet result1 = select1.executeQuery(sql);
         result1.next();
      
         long listing_no = result1.getLong(1);
         if (result1.wasNull())
         {
            listing_no = -1;
         } //if
         listing_no++;
         
         // update BOOKS_FOR_SALE relation
         PreparedStatement select = connection.prepareStatement("INSERT INTO books_for_sale VALUES(?, ?, ?, ?, ?)");
         select.setLong(1, listing_no);
         select.setString(2, post.getSeller());
         select.setString(3, post.getISBN());
         select.setString(4, post.getCondition());
         select.setDouble(5, post.getPrice());
         int result = select.executeUpdate();
         
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
  }
}
