//  file name -- ConsoleIO.java

//  type -- implementation (contains class methods)

//  classes used -- System, BufferedReader, InputStreamReader
//                  String, Float

//  This program implements the class ConsoleIO which has the
//  following operations:

//    operations:
//    int readInt()
//    double readDouble()
//    String readString()
//    clearScreen()


import java.io.*;
import java.text.*;

public class ConsoleIO
{
   // ==============================================================
   //   purpose -- Read in an integer value from the keyboard using
   //              a BufferedReader object
   //   preconditions -- stdin has been instantiated for buffered
   //              read access
   //   postconditions -- returns an integer value read from the
   //              keyboard
   // ==============================================================
   public static int readInt() throws IOException
   {
      String tempString;
      InputStreamReader input_stream = new InputStreamReader(System.in);
      BufferedReader stdin = new BufferedReader(input_stream);

      tempString = stdin.readLine();
      return (Integer.parseInt(tempString));
   }   // method readInt


   // ==============================================================
   //   purpose -- read in a double value from the keyboard
   //              using a BufferedReader object
   //   preconditions -- stdin has been instantiated for buffered
   //              read access
   //   postconditions -- returns a double value read from the
   //              keyboard
   // ==============================================================
   public static double readDouble() throws IOException
   {
      String tempString;
      InputStreamReader input_stream = new InputStreamReader(System.in);
      BufferedReader stdin = new BufferedReader(input_stream);

      tempString = stdin.readLine();
      return (Double.parseDouble(tempString));
   }   // method readDouble


   // ==============================================================
   //   purpose -- read in a string from the keyboard using a
   //              BufferedReader object
   //   preconditions -- stdin has been instantiated for buffered
   //              read access
   //   postconditions -- returns a string read from the keyboard
   // ==============================================================
   public static String readString() throws IOException
   {
      InputStreamReader input_stream = new InputStreamReader(System.in);
      BufferedReader stdin = new BufferedReader(input_stream);
      return stdin.readLine();
   }   // method readString


   // ==============================================================
   //   purpose -- Clear the screen
   //   preconditions -- none
   //   postconditions -- the terminal screen is cleared using the
   //              ANSI escape sequence
   // ==============================================================
   public static void clearScreen()
   {
      int[] command = {27, 91, 72, 27, 91, 50, 74};
      int index;

      for (index = 0; index < command.length; index++)
      {
         System.out.print((char) command[index]);
      }  // for index
      System.out.flush();
   }   // method clearScreen


   // ==============================================================
   //   purpose -- Display formatted long value
   //   preconditions -- width is non-negative
   //   postconditions -- the long value is displayed based on the
   //              specified width
   // ==============================================================
   public static void print(long value,
                            int width)
   {
      DecimalFormat format;
      String temp, format_string;
      int length;

      if (width > 0)
      {
         temp = Long.toString(value);
         length = temp.length();
         for (int k = 1; k <= width - length; k++)
            System.out.print(" ");
         System.out.print(value);
      } // if
      else
         System.out.println("Width specified " + width +
                            " is not positive");
   } // method print


   // ==============================================================
   //   purpose -- Display formatted long value with newline character
   //   preconditions -- width is non-negative
   //   postconditions -- the long value is displayed based on the
   //              specified width
   // ==============================================================
   public static void println(long value,
                                int width)
   {
      if (width > 0)
      {
         print(value, width);
         System.out.println();
      } // if
      else
         System.out.println("Width specified " + width +
                            " is not positive");
   } // method println


   // ==============================================================
   //   purpose -- Display formatted int value
   //   preconditions -- width is non-negative
   //   postconditions -- the int value is displayed based on the
   //              specified width
   // ==============================================================
   public static void print(int value,
                            int width)
   {
      DecimalFormat format;
      String temp, format_string;
      int length;

      if (width > 0)
      {
         temp = Integer.toString(value);
         length = temp.length();
         for (int k = 1; k <= width - length; k++)
            System.out.print(" ");
         System.out.print(value);
      } // if
      else
         System.out.println("Width specified " + width +
                            " is not positive");
   } // method print


   // ==============================================================
   //   purpose -- Display formatted int value with newline character
   //   preconditions -- width is non-negative
   //   postconditions -- the int value is displayed based on the
   //              specified width
   // ==============================================================
   public static void println(int value,
                                int width)
   {
      if (width > 0)
      {
         print(value, width);
         System.out.println();
      } // if
      else
         System.out.println("Width specified " + width +
                            " is not positive");
   } // method println


   // ==============================================================
   //   purpose -- Display formatted flaot value
   //   preconditions -- width is non-negative
   //   postconditions -- the flaot value is displayed based on the
   //              specified width and number of decimal places
   // ==============================================================
   public static void print(float value,
                            int width,
                            int decimal)
   {
      DecimalFormat format;
      String temp, format_string, prefix;
      int length, index;

      if (width > 0)
      {
         if (width <= decimal)
            System.out.println("Number of decimal places " + decimal +
                               " is not smaller than width " + width);
         else
         {
            temp = Float.toString(value);
            index = temp.indexOf(".");
            prefix = temp.substring(0, index);
            length = prefix.length();
            for (int k = 1; k <= width - length - 1 - decimal; k++)
               System.out.print(" ");
            if (decimal == 0)
               format_string = "0";
            else
               format_string = "0.";
            for (int k = 1; k <= decimal; k++)
               format_string = format_string + "0";
            format = new DecimalFormat(format_string);
            System.out.print(format.format(value));
         }
      } // if
      else
         System.out.println("Width specified " + width +
                            " is not positive");
   } // method print


   // ==============================================================
   //   purpose -- Display formatted float value with newline character
   //   preconditions -- width is non-negative
   //   postconditions -- the float value is displayed based on the
   //              specified width and number of decimal places
   // ==============================================================
   public static void println(float value,
                                int width,
                                int decimal)
   {
      if (width > 0)
      {
         print(value, width, decimal);
         System.out.println();
      } // if
      else
         System.out.println("Width specified " + width +
                            " is not positive");
   } // method println


   // ==============================================================
   //   purpose -- Display formatted double value
   //   preconditions -- width is non-negative
   //   postconditions -- the double value is displayed based on the
   //              specified width and number of decimal places
   // ==============================================================
   public static void print(double value,
                            int width,
                            int decimal)
   {
      DecimalFormat format;
      String temp, format_string, prefix;
      int length, index;

      if (width > 0)
      {
         if (width <= decimal)
            System.out.println("Number of decimal places " + decimal +
                                 " is not smaller than width " + width);
         else
         {
            temp = Double.toString(value);
            index = temp.indexOf(".");
            prefix = temp.substring(0, index);
            length = prefix.length();
            for (int k = 1; k <= width - length - 1 - decimal; k++)
               System.out.print(" ");
            if (decimal == 0)
               format_string = "0";
            else
               format_string = "0.";
            for (int k = 1; k <= decimal; k++)
               format_string = format_string + "0";
            format = new DecimalFormat(format_string);
            System.out.print(format.format(value));
         }
      } // if
      else
         System.out.println("Width specified " + width +
                              " is not positive");
   } // method print


   // ==============================================================
   //   purpose -- Display formatted double value with newline character
   //   preconditions -- width is non-negative
   //   postconditions -- the double value is displayed based on the
   //              specified width and number of decimal places
   // ==============================================================
   public static void println(double value,
                                int width,
                                int decimal)
   {
      if (width > 0)
      {
         print(value, width, decimal);
         System.out.println();
      } // if
      else
         System.out.println("Width specified " + width +
                            " is not positive");
   } // method println


   // ==============================================================
   //   purpose -- Display formatted string
   //   preconditions -- width is non-negative
   //   postconditions -- the string is displayed based on the
   //              specified width
   // ==============================================================
   public static void print(String value,
                            int width)
   {
      if (width > 0)
      {
         System.out.print(value);
         if (width > value.length())
         {
            for (int k = 1; k <= width - value.length(); k++)
               System.out.print(" ");
         } // if
      } // if
      else
         System.out.println("Width specified " + width +
                            " is not positive");
   } // method print


   // ==============================================================
   //   purpose -- Display formatted string with newline character
   //   preconditions -- width is non-negative
   //   postconditions -- the string is displayed based on the
   //              specified width
   // ==============================================================
   public static void println(String value,
                                int width)
   {
      if (width > 0)
      {
         print(value, width);
         System.out.println();
      } // if
      else
         System.out.println("Width specified " + width +
                            " is not positive");
   } // method println

}  // class ConsoleIO
