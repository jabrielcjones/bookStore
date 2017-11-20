// file name -- Orders.java

// This file contains the definition of the Orders class.
/** Jabriel C. Jones */
/** CSCI 340 Sp. 2012 */

public class Orders
{
   private int order_no;
   private String buyer;
   private String order_date;
   private double total;

   public Orders(int order_no,
                 String buyer,
                 String order_date,
                 double total)
   {
      this.order_no = order_no;
      this.buyer = buyer;
      this.order_date = order_date;
      this.total = total;
   } // set value constructor


   /*
      Return order number
   */
   public int getOrderNumber()
   {
      return order_no;
   }


   /*
      Return book order's buyer
   */
   public String getTitle()
   {
      return buyer;
   }


   /*
      Return order date
   */
   public String getOrderDate()
   {
      return order_date;
   }


   /*
      Return order's total
   */
   public double getTotal()
   {
      return total;
   }
} // class Orders
