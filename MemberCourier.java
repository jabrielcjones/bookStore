/** MemberCourier.java **/
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


public class MemberCourier
{
   /** Constructor */
   public MemberCourier()
   {
   }// constuctor
	
	/** checkUsername */
   public boolean checkUsername(String username)
   {
      boolean        found = false;
      Connection     connection = null;
      DBConnection   jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
         /** Get USERNAME from Database */
         PreparedStatement select = connection.prepareStatement("SELECT username FROM member WHERE username = ?");
         select.setString(1, username);
         ResultSet result = select.executeQuery();

         if (result.next())
         {
            found = true;
         }        
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

      return found;
   }// checkUsername
    
	
	/** checkPassword */
   public boolean checkPassword(String password)
   {
      boolean        found = false;
      Connection     connection = null;
      DBConnection   jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();

         /** TASK */
         /** Get PASSWORD from Database */
         PreparedStatement select = connection.prepareStatement("SELECT password FROM member WHERE password = ?");
         select.setString(1, password);
         ResultSet result = select.executeQuery();

         if (result.next())
         {
            found = true;
         }        
         
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


      return found;
   }// checkPassword
    
	
	/** insertMember */
   public void insertMember(Member member, boolean success)
   {
      Connection connection = null;
      DBConnection jdbc;

      try
      {
         jdbc = new DBConnection();
         connection = jdbc.getConnection();
         /** TASK */
         PreparedStatement select = connection.prepareStatement("INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
         select.setString(1, member.getLastName());
         select.setString(2, member.getFirstName());
         select.setString(3, member.getEmail());
         select.setString(4, member.getPassword());
         select.setString(5, member.getUser());
         select.setString(6, member.getStreet());
         select.setString(7, member.getCity());
         select.setString(8, member.getState());
         select.setString(9, member.getZip());
         select.setString(10, member.getCardType());
         select.setString(11, member.getCardNumber());
         select.setString(12, member.getExpiration());
         select.setString(13, member.getNameOnCard());
         int result = select.executeUpdate();

         
                  
      } // try      
      catch (IOException e)
      {
         System.out.println("Oops! Something went wrong!");
         success = false;
      } // catch
      catch (SQLException e)
      {
         System.out.println("Oops! Something went wrong!");
         success = false;
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
   }// insertMember
}// MemberCourier
