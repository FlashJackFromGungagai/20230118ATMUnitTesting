package com.dietel;
//package main.java.com.dietel;
// Transaction.java
// Abstract superclass Transaction represents an ATM transaction

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE Transaction class.
* 
* what this class will do:
* 1. Transaction is a parent class to other child classes.
*            
*/ 
public abstract class Transaction
{
////////////////////////////////////////////////////////////////////////////////	
	
	// DECLARE CLASS VARIABLES
   private int accountNumber; // indicates account involved
   private Screen screen; // ATM's screen
   private BankDatabase bankDatabase; // account info database


	//=========================================================================	
	/*  This CLASS CONSTRUCTOR.....
	 * Transaction constructor invoked by subclasses using super()
	 * in child sub classes.
	 */
   // 
   // 
   public Transaction( 	int userAccountNumber, 
		   				Screen atmScreen, 
		   				BankDatabase atmBankDatabase )
   {
      accountNumber = userAccountNumber;
      screen = atmScreen;
      bankDatabase = atmBankDatabase;
   } // end Transaction constructor

   

////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////
   
   
   
	//=========================================================================	
	/*  This method.....
	 * return account number 
	 */
   // 
   public int getAccountNumber()
   {
      return accountNumber; 
   } // end method getAccountNumber

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * return reference to screen
	 */
   // 
   public Screen getScreen()
   {
      return screen;
   } // end method getScreen

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * return reference to bank database
	 */
   // 
   public BankDatabase getBankDatabase()
   {
      return bankDatabase;
   } // end method getBankDatabase

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * perform the transaction (overridden by each subclass)
	 */
   // 
   abstract public void execute();
} // end class Transaction



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