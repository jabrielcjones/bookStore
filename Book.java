// file name -- Book.java

// This file contains the definition of the Book class.
/** Jabriel C. Jones */
/** CSCI 340 Sp. 2012 */

public class Book
{
   private String ISBN;
   private String title;
   private String author;
   private String publisher;
   private int edition;
   private String keywords;

   public Book(String ISBN,
               String title,
               String author,
               String publisher,
               int edition,
               String keywords)
   {
      this.ISBN = ISBN;
      this.title = title;
      this.author = author;
      this.publisher = publisher;
      this.edition = edition;
      this.keywords = keywords;
   } // set value constructor


   /*
      Return book's ISBN
   */
   public String getISBN()
   {
      return ISBN;
   }


   /*
      Return book's title
   */
   public String getTitle()
   {
      return title;
   }


   /*
      Return book's author
   */
   public String getAuthor()
   {
      return author;
   }


   /*
      Return book's publisher
   */
   public String getPublisher()
   {
      return publisher;
   }


   /*
      Return book's edition
   */
   public int getEdition()
   {
      return edition;
   }


   /*
      Return book's keyword'
   */
   public String getKeywords()
   {
      return keywords;
   }
} // class Book
