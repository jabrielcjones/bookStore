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

 public class OrdersCourier
{
   public OrdersCourier()
   {
      System.out.println("OrderCourier object instantiated.");
   }
   
	/** getOrders
	 * 		select relation via the ORDERS relation with attributes:
	 * 				seller member name
	 * 				isbn
	 * 				book title
	 * 				price
	 */
   public void getOrders(BookForSale[] books, Book[] book_titles)
   {
      System.out.println("getOrders is called.");

      /** Get books from ORDERS relation */
		 
	 for (int i = 0; i < books.length; i++)
     {
		 books[i] = new BookForSale(i + 1, "Corbin", "xxxx-xxxx-xxxx", "good", 10.00);
		 book_titles[i] = new Book("xxxx-xxxx-xxxx", "Animal Farm", "George Orwell", "Harcourt Brace & Company", 1, "animal, communism");
     }
   }
	
	/** submitOrder
	 * 		remove book(s) from the BOOKS_FOR_SALE relation
	 */
   public void submitOrder()
   {
      System.out.println("submitOrder is called.");
   }
}
