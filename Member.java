// file name -- Member.java

// This file contains the definition of the Member class.
/** Jabriel C. Jones */
/** CSCI 340 Sp. 2012 */

public class Member
{
   private String last_name;
   private String first_name;
   private String email;
   private String password;
   private String user;
   private String street;
   private String city;
   private String state;
   private String zip;
   private String card_type;
   private String card_no;
   private String expiration;
   private String name_on_card;

   public Member(String last_name,
                 String first_name,
                 String email,
                 String password,
                 String user,
                 String street,
                 String city,
                 String state,
                 String zip,
                 String card_type,
                 String card_no,
                 String expiration,
                 String name_on_card)
   {
      this.last_name = last_name;
      this.first_name = first_name;
      this.email = email;
      this.password = password;
      this.user = user;
      this.street = street;
      this.city = city;
      this.state = state;
      this.zip = zip;
      this.card_type = card_type;
      this.card_no = card_no;
      this.expiration = expiration;
      this.name_on_card = name_on_card;
   } // set value constructor


   /*
      Return member's last name'
   */
   public String getLastName()
   {
      return last_name;
   }


   /*
      Return member's first name'
   */
   public String getFirstName()
   {
      return first_name;
   }


   /*
      Return member's email
   */
   public String getEmail()
   {
      return email;
   }


   /*
      Return member's password
   */
   public String getPassword()
   {
      return password;
   }


   /*
      Return member's user name'
   */
   public String getUser()
   {
      return user;
   }


   /*
      Return member's street'
   */
   public String getStreet()
   {
      return street;
   }


   /*
      Return member's city
   */
   public String getCity()
   {
      return city;
   }


   /*
      Return member's state
   */
   public String getState()
   {
      return state;
   }


   /*
      Return member's zip
   */
   public String getZip()
   {
      return zip;
   }


   /*
      Return member's credit card type
   */
   public String getCardType()
   {
      return card_type;
   }


   /*
      Return member's credit card number
   */
   public String getCardNumber()
   {
      return card_no;
   }


   /*
      Return member's credit card expiration date
   */
   public String getExpiration()
   {
      return expiration;
   }


   /*
      Return member's name on credit card
   */
   public String getNameOnCard()
   {
      return name_on_card;
   }
} // class Member
