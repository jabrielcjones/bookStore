/** Cooper.java */
/** Jabriel C. Jones */
/** CSCI 340 Sp. 2012 */
/** Use try catch block to catch SQL exceptions */

/** Problem: when making a selection to remove an item from a list
 * 			 the proper index needs to be accessed.
 * Solution: index - x
 */

/** Implement transactions */

/** Create new connection to database in each method of the courier
 *  classes
 */

/** PLEASE finish making this section of the application so you can
 *  get to the actual database work.
 */

import java.util.*;



class Cooper
{
   public static String   username = "";
   
   /** Main Method */
   public static void main(String[] args)
   {
      System.out.println("*** WELCOME TO COOPER ***");

      if (login())
         displayMenu();
      else
         System.out.println("END OF APPLICATION");
   }// main
   

   /** login user */
   public static boolean login()
   {    
      String   password = "";
      Scanner  input;
      int      attempts = 0;

      /** USERNAME */
      // Prompt for USERNAME successful
      System.out.println("Please enter USERNAME: ");
      // Read USERNAME successful
      input = new Scanner(System.in);
      username = input.nextLine();
      // Check Input
      //System.out.println("Username = " + username);

      while (!usernameIsValid(username))
      {
         if (registerUser())
         {
            // username is not registered; register user
            System.out.println("Please enter USERNAME: ");
            // Read USERNAME successful
            input = new Scanner(System.in);
            username = input.nextLine();
         }// if
         else
         {
            return false;
         }// else
      }// while

      /** PASSWORD */
      while (attempts < 3)
      {
         // Prompt for PASSWORD successful
         System.out.println("Please enter PASSWORD: ");
         // Read PASSWORD successful
         input = new Scanner(System.in);
         password = input.nextLine();

         if (passwordIsValid(password))
         {
            return true;
         }// if
         attempts++;
         System.out.println("Password is not valid.");
      }// while
      
      return false;
   }// login
   

   
   /** validate USERNAME */
   public static boolean usernameIsValid(String username)
   {
      MemberCourier courier = new MemberCourier();
      
      if (courier.checkUsername(username))
      {
         return true;
      }// if

      return false;
   }// usernameIsValid
   


    /** validate PASSWORD */
   public static boolean passwordIsValid(String password)
   {
      MemberCourier courier = new MemberCourier();

      if (courier.checkPassword(password))
      {
         return true;
      }// if

      return false;
   }// passwordIsValid
   


   /** register new user */
   public static boolean registerUser()
   {
      System.out.println("Do you want to register? (Y/N)");
      Scanner input = new Scanner(System.in);
      String response = input.nextLine();
      boolean  success = true;

      if (!response.equalsIgnoreCase("Y"))
         return false;

      /** Register Member */
      String last_name;
      String first_name;
      String email;
      String password;
      String user;
      String street;
      String city;
      String state;
      String zip;
      String card_type;
      String card_no;
      String expiration;
      String name_on_card;

      // get last name
      System.out.println("Last Name: ");
      input = new Scanner(System.in);
      last_name= input.nextLine();
      // check last name
      // System.out.println("Last Name = " + last_name);

      // get first name
      System.out.println("First Name: ");
      input = new Scanner(System.in);
      first_name= input.nextLine();
      // check first name
      // System.out.println("First Name = " + first_name);
      
      // get email
      System.out.println("Email: ");
      input = new Scanner(System.in);
      email = input.nextLine();
      // check email
      // System.out.println("Email = " + email);

      // get password
      System.out.println("Password: ");
      input = new Scanner(System.in);
      password = input.nextLine();
      // check last name
      // System.out.println("Password = " + password);

      // get username
      System.out.println("Username: ");
      input = new Scanner(System.in);
      user = input.nextLine();
      // check username
      // System.out.println("Username = " + user);

      // get street
      System.out.println("Street: ");
      input = new Scanner(System.in);
      street = input.nextLine();
      // check street
      // System.out.println("Street = " + street);

      // get city
      System.out.println("City: ");
      input = new Scanner(System.in);
      city = input.nextLine();
      // check last name
      // System.out.println("city = " + city);

      // get state
      System.out.println("State ");
      input = new Scanner(System.in);
      state = input.nextLine();
      // check last name
      // System.out.println("state = " + state);

      // get zip
      System.out.println("Zip: ");
      input = new Scanner(System.in);
      zip = input.nextLine();
      // check last name
      // System.out.println("zip = " + zip);

      // get last name
      System.out.println("Card Type: ");
      input = new Scanner(System.in);
      card_type = input.nextLine();
      // check last name
      // System.out.println("card_type = " + card_type);

      // get card_no
      System.out.println("Card No: ");
      input = new Scanner(System.in);
      card_no = input.nextLine();
      // check last name
      // System.out.println("card_no = " + card_no);s
      // get expiration
      System.out.println("Expiration: ");
      input = new Scanner(System.in);
      expiration = input.nextLine();
      // check last name
       System.out.println("expiration = " + expiration);

      // get name_on_card
      System.out.println("Name on Card: ");
      input = new Scanner(System.in);
      name_on_card = input.nextLine();
      // check last name
      // System.out.println("name_on_card = " + name_on_card);
      

      Member   member = new Member(last_name,
                                   first_name,
                                   email,
                                   password,
                                   user,
                                   street,
                                   city,
                                   state,
                                   zip,
                                   card_type,
                                   card_no,
                                   expiration,
                                   name_on_card);


      /* INSERT into database*/
      MemberCourier courier = new MemberCourier();
      courier.insertMember(member, success);

      return success;
   }// registerUser

   
   
   /** displays menu */
   public static void displayMenu()
   {      
      boolean		cont = true;
      while (cont)
      {
    	  try
    	  {
	          System.out.println("\n***CHOOSE AN OPTION***");
	
		      // Display menu
		      System.out.println("1. SEARCH FOR BOOKS BY ISBN\n" +
		                         "2. SEARCH FOR BOOKS BY AUTHOR\n" +
		                         "3. SEARCH FOR BOOKS BY TITLE\n" +
		                         "4. SEARCH FOR BOOKS BY KEYWORDS\n" +
		                         "5. SHOW SHOPPING CART OR REMOVE BOOK ENTRIES FROM SHOPPING CART\n" +
		                         "6. SUBMIT ORDER\n" +
		                         "7. POST BOOKS FOR SALES\n" +
		                         "8. REMOVE BOOKS FROM SALES\n" +
		                         "9. END OF APPLICATION");
		                         
		      // Make selection
		      Scanner     input = new Scanner(System.in);
		      String      selection = input.nextLine();
		      int i = 1;
		
		      switch (Integer.parseInt(selection))
		      {
		         case 1: getBooksIsbn();
		                 break;
		         case 2: System.out.println("SEARCH FOR BOOKS BY AUTHOR");
		                 break;
		         case 3: System.out.println("SEARCH FOR BOOKS BY TITLE");
		                 break;
		         case 4: System.out.println("SEARCH FOR BOOKS BY KEYWORDS");
		                 break;
		         case 5: displayCart();
		                 break;
		         case 6: submitOrder();
		                 break;
		         case 7: postBooks();
		                 break;
		         case 8: removeBooks();
		                 break;
		         case 9: System.out.println("END OF APPLICATION");
		                 cont = false;
		                 break;
		      }// switch
    	  }// try
    	  catch (NumberFormatException e)
    	  {
    		  System.out.println("OOPS! Try Again");
    	  }// catch
      }// while
   }// displayMenu



   
   /** Get books for sale by ISBN */
   public static void getBooksIsbn()
   {
      // Get books from BOOKS_FOR_SALE relation
      BooksForSaleCourier		BFScourier = new BooksForSaleCourier();
      BookCourier             Bcourier = new BookCourier();
      ItemsCourier            Icourier = new ItemsCourier();
      String					   isbn;
      
      // Get isbn
      System.out.println("Please enter isbn: ");
      Scanner     input = new Scanner(System.in);

      isbn = input.nextLine();
      
      BookForSale 				post = BFScourier.getPost(isbn);
      Book  					   book = Bcourier.getBook(isbn);
      
      //Display book from BOOKS_FOR_SALE relation
      try
      {
         System.out.println("\n\n***BOOKS FOR SALE***");
            
         System.out.println("1. " +
                            "Seller: " + post.getSeller() +
                            "\n" +
                            "ISBN: " + post.getISBN() + 
                            " " +
                            "Title: " + book.getTitle() +
                            " " +
                            "Price: " + post.getPrice());
         System.out.println("2. Main Menu");
     
     
     
        // Make selection
         String      selection = input.nextLine();
   
         switch (Integer.parseInt(selection))
         {
            case 1: System.out.println("Are you sure you want to add this item to cart? (Y/N)");
                    input = new Scanner(System.in);
                    selection = input.nextLine();
                    if (selection.equalsIgnoreCase("Y"))
                        Icourier.addItem(post, username);
                    else
                        System.out.println("Book not added to cart");
                    break;
            case 2: System.out.println("END OF OPTION #1");
                    break;
         }// switch
     }// try
     catch(NumberFormatException e)
     {
        System.out.println("OOPS! Something went wrong!");
     }// catch
     catch(NullPointerException e)
     {
        System.out.println("OOPS! Something went wrong!");
     }// catch
   }// getBooksISBN
   
   /** OPTION #5. SHOW SHOPPING CART OR REMOVE BOOK ENTRIES FROM
    *             SHOPPING CART
    * Description: Allow the member to display or to update the content
    * of his/her shopping cart.
    *
    * The program displays the locked books in the BOOKS_FOR_SALE
    * relation. Each book entry is shown on 2 lines:
    *                Line #1: Seller's member name
    *                Line #2: ISBN, the book title, and the price of the
    *                         book
    * Each book is numbered starting at 1.The second line is indented 5
    * spaces.The program adds an extra entry for the member to go back
    * to the main menu.If the member selects the final number on the
    * list the program returns to the main menu the program assumes that
    * the member wants to remove the entry matching the number entered
    * by the member the program acquires a confirmation from the member
    * before the book entry is removed from the shopping cart if the
    * member confirms the removal the book is removed from the shopping
    * cart the program displays a new list for the member to make
    * selections else the shopping cart stay intact the program displays
    * the same list for the member to make selections. 
    * 
    * Consider the idea that you can lock rows in one transaction and
    * unlock them in another.
    * */
   public static void displayCart()
   {
      BooksForSaleCourier		BFScourier = new BooksForSaleCourier();
      BookCourier             Bcourier = new BookCourier();
      ItemsCourier            Icourier = new ItemsCourier();
      Item[] 				      items = null;
      Book                    book = null;
      BookForSale             post = null;
      String					   isbn;      
      
      //Display books from BOOKS_FOR_SALE relation
      //Display 10 at a time and offer a selection to continue to next page
      boolean 					   cont = true; 
      int						   index = 0;
	   while (cont)
	   {
		  try
		  {
			   System.out.println("\n\n***SHOPPING CART***");
	
			   int					count = 1;
            int 					listing = 0;    	  
		      while (count <= 10)
			  {
               // Get books from ITEMS relation
               items = Icourier.getItems(username);
               
              if (items != null)
              {
                 if (index < items.length)
                 {
                     post = BFScourier.getPost(items[index].getListingNumber());
                     book = Bcourier.getBook(post.getISBN());
                     listing = count;
                     System.out.println(listing +
                                    ". " +
                                    "Seller: " + post.getSeller() +
                                    "\n" +
                                    "ISBN: " + post.getISBN() + 
                                    " " +
                                    "Title: " + book.getTitle() +
                                    " " +
                                    "Price: " + post.getPrice());
                     index++;
                     count++;
                 }
                 else
                 {
                    count = 11;
                 }
              }
              else
              {
                 count = 11;
              }
			  }
			  System.out.println(11 +
					  			 ". Beginning");
			  System.out.println(12 +
					  			 ". Next");
			  System.out.println(13 +
			  			 		 ". Main Menu");
		  
            System.out.println("Enter the name of the book to remove: ");
            Scanner     input = new Scanner(System.in);
            String      selection = input.nextLine();

            // Make selection
            int i = 0;
            boolean found = false;
            while (i < items.length)
            {
               post = BFScourier.getPost(items[i].getListingNumber());
               book = Bcourier.getBook(post.getISBN());
               if (book.getTitle().equalsIgnoreCase(selection))
               {
                  found = true;
                  i = items.length;
               }
               else
               {
                  switch(Integer.parseInt(selection))
                  {
                     case 11:index = 0;
                             i = items.length;
                             break;
                     case 12:i = items.length;
                             break;
                     case 13:cont = false;
                             i = items.length;
                             break;
                  }
               }
               i++;
            }

            if (found)
            {
               System.out.println("Are you sure you want to delete this item? (Y/N)");
               input = new Scanner(System.in);
		         selection = input.nextLine();
               if (selection.equalsIgnoreCase("Y"))
               {
                  Icourier.removeItem(post, username);
                  index = 0;
               }
               else
                  index = 0;
            }
            else
            {
               index = 0;
            }
		  }
		  catch(Exception e)
		  {
			  System.out.println("OOPS! Try Again");
			  index = 0;
		  }
	  }
   }
   

   /** OPTION #6. SUBMIT ORDER
    * Allows the user to submit his/her order
    * The program displays the books in the ORDERS relation. Each book
    * entry is shown on 2 lines:
    *       Line #1: Seller's member name
    *       Line #2: ISBN, the book title, and the price of the book
    * Each book is numbered starting at 1.The second line is indented 5
    * spaces.The program adds an extra entry for the member to go back
    * to the main menu. If the member selects the final number on the
    * list the program returns to the main menu. The program acquires a
    * confirmation of submitting the order before it is submitted if the
    * member confirms the order then the order is submitted the shopping
    * cart is emptied the program returns to the main menu. Otherwise
    * the shopping cart stays intact. The program returns to the main menu */
   public static void submitOrder()
   {
      System.out.println("OPTION #6 called.");
      
      // Get orders from ORDERS relation
      BooksForSaleCourier		BFScourier = new BooksForSaleCourier();
      BookCourier             Bcourier = new BookCourier();
      ItemsCourier            Icourier = new ItemsCourier();
      OrdersCourier				Ocourier = new OrdersCourier();
      Book                    book = null;
      BookForSale             post = null;
      Item[] 				      items = null;
      String					   isbn;
      
     
      
      
      //Display books from BOOKS_FOR_SALE relation
      //Display 10 at a time and offer a selection to continue to next page
      boolean 					cont = true; 
      int						index = 0;
	   while (cont)
	   {   
		  try
		  {
			  System.out.println("\n\n***ORDER***");
	
			  int					count = 1;
            int 					listing = 0;    	  
		      while (count <= 10)
			  {
               // Get books from ITEMS relation
               items = Icourier.getItems(username);
               
              if (items != null)
              {
                 if (index < items.length)
                 {
                     post = BFScourier.getPost(items[index].getListingNumber());
                     book = Bcourier.getBook(post.getISBN());
                     listing = count;
                     System.out.println(listing +
                                    ". " +
                                    "Seller: " + post.getSeller() +
                                    "\n" +
                                    "ISBN: " + post.getISBN() + 
                                    " " +
                                    "Title: " + book.getTitle() +
                                    " " +
                                    "Price: " + post.getPrice());
                     index++;
                     count++;
                 }
                 else
                 {
                    count = 11;
                 }
              }
              else
              {
                 count = 11;
              }
			  }
			  System.out.println(11 +
					  			 ". Beginning");
			  System.out.println(12 +
					  			 ". Next");
			  System.out.println(13 +
			  			 		 ". Submit Order");
			  System.out.println(14 +
				 		 		 ". Main Menu");
		  
		  
			  // Make selection
		      Scanner     input = new Scanner(System.in);
		      String      selection = input.nextLine();
		
		      switch (Integer.parseInt(selection))
		      {
		         case 11: System.out.println("Beginning");
		         		  index = 0;
		         		  break;
		         case 12: System.out.println("Next");
		         		  break;
		         case 13: System.out.println("Are you sure you want to submit this order? (Y/N)");
				 	 	  input = new Scanner(System.in);
				 	 	  selection = input.nextLine();
				 	 	  if (selection.equalsIgnoreCase("Y"))
				 	 	  {
				 	 		  Ocourier.submitOrder(items[0].getListingNumber(), username);
				 	 		  System.out.println("Order Submitted");
				 	 	  }
				 	 	  else
				 	 		  System.out.println("Order not Submitted");
		         case 14: cont = false;
		      }
		  }
		  catch(NumberFormatException e)
		  {
			  System.out.println("OOPS! Try Again");
			  index = 0;
		  }
	  }
   }
   

   /** OPTION #7. POST BOOKS FOR SALES
    * Allows user to post books for sale
    * While the answer is ?yes?the program asks the ISBN of the book.
    * While the ISBN entered is not found in the BOOK relation. The
    * program asks the member to enter the ISBN again until it is found
    * the program asks the member to enter the condition of the book
    * sale price the program confirms with the member before the
    * information provided is inserted into the BOOK_FOR_SALE relation.
    * If the member confirms the book is inserted.The program asks the
    * member whether or not he/she wants to post another book for sale
    * the program returns to the main menu */
   public static void postBooks()
   {
      System.out.println("OPTION #7 called.");
      
      
      boolean		cont = true;
      while (cont)
      {
         Scanner		            input;
         String			         selection, condition, name;
         double			         price;
         BookCourier	            Bcourier = new BookCourier();
         BooksForSaleCourier     BFScourier = new BooksForSaleCourier();
         
    	 System.out.println("Do you want to post a book? (Y/N)");
		 input = new Scanner(System.in);
		 selection = input.nextLine();
		 
		 if (selection.equalsIgnoreCase("Y"))
		 {
			 System.out.println("ISBN: ");
			 input = new Scanner(System.in);
			 String			isbn = input.nextLine();
			 while (!Bcourier.checkISBN(isbn))
			 {
				 System.out.println("Not Valid\nISBN: ");
				 input = new Scanner(System.in);
			 }
			 
			 // get condition
			 System.out.println("Condition: ");
			 input = new Scanner(System.in);
			 condition = input.nextLine();
			 // check condition
			 //System.out.println("Condition = " + condition);
			 
			// get price
			System.out.println("Price: ");
			input = new Scanner(System.in);
			price = Double.parseDouble(input.nextLine());
			// check price
			//System.out.println("Price = " + price);
			
			System.out.println("Are you sure you want to post this book? (Y/N)");
			input = new Scanner(System.in);
			selection = input.nextLine();
			 
			if (selection.equalsIgnoreCase("Y"))
			{
				BookForSale       post = new BookForSale(1, username, isbn, condition, price);
				BFScourier.insertPost(post);
			}
			else
			{
				cont = false;
				System.out.println("Book not posted");
			}
		 }
		 else
		 {
			 cont = false;
			 System.out.println("Book not posted");
		 }
      }
   }
   

   /** OPTION #8. REMOVE BOOKS FROM SALES
    * Allows user to remove postings from the BOOKS_FOR_SALE relation.
    * While the answer is yes the program displays the books posted by
    * the member for sale. Each book entry is shown on 2 lines:
    *       Line #1: Seller?s member name
    *       Line #2: ISBN, the book title, and the price of the book
    * Each book is numbered starting at 1.The second line is indented 5
    * spaces.The program adds an extra entry for the member to go back
    * to the main menu.If the member selects the final number on the
    * list the program returns to the main menu. The program asks the
    * member which book to be removed by the member. The program
    * confirms with the member before the book is removed from the
    * BOOKS_FOR_SALE relation. If the member confirms the book is
    * deleted. The program asks the member whether or not he/she wants
    * to remove another posting from the BOOKS_FOR_SALE relation the
    * program returns to the main menu */
   public static void removeBooks()
   {
      System.out.println("OPTION #8 called.");
      
      // Get books from BOOKS_FOR_SALE relation
      BooksForSaleCourier		BFScourier = new BooksForSaleCourier();
      BookCourier             Bcourier = new BookCourier();
      BookForSale[]				posts = null;
      Book  					   book = null;
      
      
      //Display books from BOOKS_FOR_SALE relation
      //Display 10 at a time and offer a selection to continue to next page
      boolean 					cont = true; 
      int						index = 0;
	  while (cont)
	  {       
		  try
		  {
			  System.out.println("\n\n***YOUR POSTS***");
	
			  int					count = 1;
		      int 					listing = 0;    	  
		      while (count <= 10)
			  {
              posts = BFScourier.getUserPosts(username);
				  if (index < posts.length)
				  {
                  book = Bcourier.getBook(posts[index].getISBN());
						listing = count;
						System.out.println(listing +
							  			   ". " +
							  			   "Seller: " + posts[index].getSeller() +
							  			   "\n" +
							  			   "ISBN: " + posts[index].getISBN() + 
							  			   " " +
							  			   "Title: " + book.getTitle() +
							  			   " " +
							  			   "Price: " + posts[index].getPrice());
						index++;
						count++;
				  }
				  else
				  {
					  count = 11;
				  }
			  }
			  System.out.println(11 +
					  			 ". Beginning");
			  System.out.println(12 +
					  			 ". Next");
			  System.out.println(13 +
			  			 		 ". Main Menu");
		  
		  
		  
			   System.out.println("Enter the name of the book to remove: ");
            Scanner     input = new Scanner(System.in);
            String      selection = input.nextLine();

            // Make selection
            int      i = 0;
            boolean  found = false;
            long     listing_no = 0;
            while (i < posts.length)
            {
               book = Bcourier.getBook(posts[i].getISBN());
               if (book.getTitle().equalsIgnoreCase(selection))
               {
                  found = true;
                  listing_no = posts[i].getListingNumber();
                  i = posts.length;
               }
               else
               {
                  switch(Integer.parseInt(selection))
                  {
                     case 11:index = 0;
                             i = posts.length;
                             break;
                     case 12:i = posts.length;
                             break;
                     case 13:cont = false;
                             i = posts.length;
                             break;
                  }
               }
               i++;
            }

            if (found)
            {
               System.out.println("Are you sure you want to remove this post? (Y/N)");
               input = new Scanner(System.in);
		         selection = input.nextLine();
               if (selection.equalsIgnoreCase("Y"))
               {
                  BFScourier.removePost(listing_no, username);
                  index = 0;
                  cont = false;
               }
               else
                  index = 0;
            }
            else
            {
               index = 0;
            }
		  }
		  catch(NumberFormatException e)
		  {
			  System.out.println("OOPS! Try Again");
			  index = 0;
		  }
	  }
   }
   
}
