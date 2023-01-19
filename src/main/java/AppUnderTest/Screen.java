package AppUnderTest;
//package main.java.com.dietel;

// Screen.java
// Represents the screen of the ATM


////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE Screen class.
* 
* what this class will do:
* 1. Display string Message on screen without CR
* 2. Display string Message on screen with CR
* 3. Display the Dollar amount.
*            
*/ 
public class Screen
{
	// Default constructor... no constructor method.
   
	
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////	
	   
	   
	   
	//=========================================================================	
	/*  This method.....
	* display a dollar amount
	* displays a message without a carriage return
	*/
	// 
	// 
   public void displayMessage( String message )

   {
      System.out.print( message ); 
   } // end method displayMessage
	
   
   
   
   //=========================================================================	
	/*  This method.....
	 * display a dollar amount
	 * display a message with a carriage return
	 */
   // 
   // 
   public void displayMessageLine( String message )

   {
      System.out.println( message );   
   } // end method displayMessageLine
	
   
   
   
   //=========================================================================	
	/*  This method.....
	 * display as a dollar formatted amount
	 */
   // 
   public void displayDollarAmount( double amount )
   {
      System.out.printf( "$%,.2f", amount );   
   } // end method displayDollarAmount 
} // end class Screen



/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/