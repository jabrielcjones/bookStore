/** OrdersCourier.java **/
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


 public class OrdersCourier
{
   public OrdersCourier()
   {
   }
   
	/** submitOrder
	 * 		remove book(s) from the BOOKS_FOR_SALE relation
	 */
   public void submitOrder(long listing_no, String username)
   {

      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
         //get order number
         PreparedStatement select = connection.prepareStatement("select o.order_no from orders o, items where listing_no = ? and buyer = ?");
         select.setLong(1, listing_no);
         select.setString(2, username);
         ResultSet result = select.executeQuery();
         result.next();

         long order_no = result.getLong(1);
         if (result.wasNull())
         {
            order_no = 0;
         } //if


         //submit order
         PreparedStatement select1 = connection.prepareStatement("begin; delete from orders where order_no = ? and buyer = ?; commit");
         select1.setLong(1, order_no);
         select1.setString(2, username);
         int result1 = select1.executeUpdate();
         
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
