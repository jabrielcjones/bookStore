// file name -- Item.java

// This file contains the definition of the Item class.
/** Jabriel C. Jones */
/** CSCI 340 Sp. 2012 */

public class Item
{
   private long order_no;
   private long listing_no;

   public Item(long order_no,
               long listing_no)
   {
      this.order_no = order_no;
      this.listing_no = listing_no;
   } // set value constructor


   /*
      Return order number
   */
   public long getOrderNumber()
   {
      return order_no;
   }


   /*
      Return listing number
   */
   public long getListingNumber()
   {
      return listing_no;
   }
} // class Item
