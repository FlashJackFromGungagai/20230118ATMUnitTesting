package au.edu.rmit.ct;
//package main.java.com.dietel;


// Keypad.java
// Represents the keypad of the ATM

import java.util.Scanner; // program uses Scanner to obtain user input

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE Keypad class.
* 
* what this class will do:
* 1. get the keyboard input
*            
*/ 
public class KeypadStub
{
	////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES
   private Scanner input; // reads data from the command line
                         
   // no-argument constructor initializes the Scanner
  
   
   
 //=========================================================================	
   /*  This CLASS CONSTRUCTOR.....
   * 
   * Keypad()
   */
   // 
   // 
   public KeypadStub()
   {
      input = new Scanner( System.in );    
   } // end no-argument Keypad constructor

   
   
   
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
//////////////////////////////////////////////////////////////////////////////// 
   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * return an integer value entered by user 
	 */
   // 
   public int getInput()
   {
      return input.nextInt(); // we assume that user enters an integer  
   } // end method getInput
} // end class Keypad  



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