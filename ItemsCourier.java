/** ItemsCourier.java **/
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

 public class ItemsCourier
{
	 public ItemsCourier()
	 {
	 }

     /** getItems
     * Get books shopped for by user
	 * 		select relation via the BOOKS_FOR_SALE relation with attributes:
	 * 				seller member name
	 * 				isbn
	 * 				price
	 * 		select relation via the BOOKS relation with matching above isbn
	 */
	 public Item[] getItems(String username)
	 {
       // change to return array (not passed by reference)

      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
         long listing_no, order_no;
         
         //get number of items in ITEMS
         PreparedStatement select1 = connection.prepareStatement("select count(listing_no) from items i, orders o where o.buyer = ? and i.order_no = o.order_no");
         select1.setString(1, username);
         ResultSet result1 = select1.executeQuery();
         result1.next();

         int numberOfItems = result1.getInt(1);
         if (result1.wasNull())
         {
            numberOfItems = 0;
         } //if

         //declare and instantiate items array
         Item[]    items = new Item[numberOfItems];

         
         //get items from items relation at buyer x
         PreparedStatement select2 = connection.prepareStatement("select i.order_no, listing_no from items i, orders o where o.buyer = ? and i.order_no = o.order_no");
         select2.setString(1, username);
         ResultSet result2 = select2.executeQuery();

          // Table traversal
         int index = 0;
         while(result2.next())
         {
            order_no = result2.getLong(1);
            if (result2.wasNull())
            {
               order_no = 0;
            } // if
            
            listing_no = result2.getLong(2);
            if (result2.wasNull())
            {
               listing_no = 0;
            } //if

            items[index] = new Item(order_no, listing_no);
            index++;
         } // while
         return items;
      } // try
      catch (SQLException e)
      {
         System.out.println("Oops! Something went wrong!\nUnable to Disconnect from the Database");
      } // catch
      catch (IOException e)
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
               System.out.println("Oops! Something went wrong!");
            } // catch
         } // if
      } // finally

      return null;
	 } //getItems

    /** removeItem
	 * 		remove book from ITEMS relation
	 */
   public void removeItem(BookForSale post, String username)
   {
      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
         // remove item from items relation at isbn x
         // get order_no from items
         PreparedStatement select1 = connection.prepareStatement("select i.order_no from orders, items i where listing_no = ? and buyer = ?");
         select1.setLong(1, post.getListingNumber());
         select1.setString(2, username);
         ResultSet result1 = select1.executeQuery();
         result1.next();
         
         long order_no = result1.getLong(1);
         if (result1.wasNull())
         {
            order_no = -1;
         } //if

         double total = 0.0;
          //get total
         PreparedStatement select2 = connection.prepareStatement("select total from orders where order_no = ?");
         select2.setLong(1, order_no);
         ResultSet result2 = select2.executeQuery();
         result2.next();

         total = result2.getDouble(1);
         if (result2.wasNull())
         {
            total = 0.0;
         } //if

         //update total
         total -= post.getPrice();
         PreparedStatement select4 = connection.prepareStatement("update orders set total = ? where order_no = ?");
         select4.setDouble(1, total);
         select4.setLong(2, order_no);
         int result4 = select4.executeUpdate();

         // delete item from ITEMS relation
         PreparedStatement select = connection.prepareStatement("delete from items where listing_no = ?");
         select.setLong(1, post.getListingNumber());
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
   }//removeItem
   
	/** insertBook
	 * 		insert book into BOOKS_FOR_SALE relation
	 */
   public void addItem(BookForSale post, String username)
   {      
      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /* TASK */
         //check to see if post is already in cart
         PreparedStatement select6 = connection.prepareStatement("select listing_no from items, orders where listing_no = ? and buyer = ?");
         select6.setLong(1, post.getListingNumber());
         select6.setString(2, username);
         ResultSet result6 = select6.executeQuery();

         if(!result6.next())
         {
            double total = 0.0;
            //check to see if user has an existing order
            long order_no;
            PreparedStatement select = connection.prepareStatement("select order_no from orders where buyer = ?");
            select.setString(1, username);
            ResultSet result = select.executeQuery();
            if (!result.next())
            {
               //order does not exist
               // get largest order_no from items
               Statement select1 = connection.createStatement();
               String sql = "select max(order_no) from orders";
               ResultSet result1 = select1.executeQuery(sql);
               result1.next();
            
               order_no = result1.getLong(1);
               if (result1.wasNull())
               {
                  order_no = -1;
               } //if
               // create unique order_no
               order_no++;

               // update orders relation
               PreparedStatement select3 = connection.prepareStatement("INSERT INTO orders VALUES(?, ?, '5/30/2012', ?)");
               select3.setLong(1, order_no);
               select3.setString(2, username);
               select3.setDouble(3, total);
               int result3 = select3.executeUpdate();
            }
            else
            {
               //order exists
               order_no = result.getLong(1);
               if (result.wasNull())
               {
                  order_no = -1;
               } //if            
            }

             //get total
            PreparedStatement select2 = connection.prepareStatement("select total from orders where order_no = ?");
            select2.setLong(1, order_no);
            ResultSet result2 = select2.executeQuery();
            result2.next();

            total = result2.getDouble(1);
            if (result2.wasNull())
            {
               total = 0.0;
            } //if

            //update total
            total += post.getPrice();
            PreparedStatement select4 = connection.prepareStatement("update orders set total = ? where order_no = ?");
            select4.setDouble(1, total);
            select4.setLong(2, order_no);
            int result4 = select4.executeUpdate();

            // update items relation
            PreparedStatement select5 = connection.prepareStatement("INSERT INTO items VALUES(?, ?)");
            select5.setLong(1, order_no);
            select5.setLong(2, post.getListingNumber());
            int result5 = select5.executeUpdate();
         }
         else
         {
            System.out.println("Book is already in your cart!");
         }
         

              
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
   }//addItem
}
