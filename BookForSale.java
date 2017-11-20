/** BooksForSale.java **/
/** Jabriel C. Jones */
/** CSCI 340 Sp. 2012 */

// file name -- BookForSale.java

// This file contains the definition of the BookForSale class.


public class BookForSale
{
   private long listing_no;
   private String seller;
   private String ISBN;
   private String condition;
   private double price;

   public BookForSale(long listing_no,
                      String seller,
                      String ISBN,
                      String condition,
                      double price)
   {
      this.listing_no = listing_no;
      this.seller = seller;
      this.ISBN = ISBN;
      this.condition = condition;
      this.price = price;
   } // set value constructor


   /*
      Return book's listing_no
   */
   public long getListingNumber()
   {
      return listing_no;
   }


   /*
      Return book's seller
   */
   public String getSeller()
   {
      return seller;
   }


   /*
      Return book's ISBN
   */
   public String getISBN()
   {
      return ISBN;
   }


   /*
      Return book's condition
   */
   public String getCondition()
   {
      return condition;
   }


   /*
      Return book's price
   */
   public double getPrice()
   {
      return price;
   }
} // class BookForSale
