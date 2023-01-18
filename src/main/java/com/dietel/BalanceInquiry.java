package com.dietel;
//package main.java.com.dietel;
// BalanceInquiry.java
// Represents a balance inquiry ATM transaction

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE BalanceInquiry extends Transaction.
* 
* what this class will do:
* 1.    Creates a child class called BalanceInquiry
* 2.    Extends the transaction parent class
*            
*/ 



public class BalanceInquiry extends Transaction
{

    ////////////////////////////////////////////////////////////////////////////////
    //This CLASS CONSTRUCTOR.....
    /*
     * BalanceInquiry constructor
     * passes userAccountNumber, atmScreen, atmBankDatabase
     * to the parent Transaction class
     */
    ////////////////////////////////////////////////////////////////////////////////


   public BalanceInquiry( 	int userAccountNumber, 
		   					Screen atmScreen, 
		   					BankDatabase atmBankDatabase )
   {
      super( userAccountNumber, atmScreen, atmBankDatabase );
      // passes userAccountNumber, atmScreen, atmBankDatabase
      // to the parent Transaction class

   } // end BalanceInquiry constructor
   
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////  

	//=========================================================================	
	/*  This method.....
	 * performs the transaction, executes the transaction
	 */
   // 
   public void execute()
   {
      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();

      // get the available balance for the account involved
      double availableBalance = 
         bankDatabase.getAvailableBalance( getAccountNumber() );

      // get the total balance for the account involved
      double totalBalance = 
         bankDatabase.getTotalBalance( getAccountNumber() );
      
      // display the balance information on the screen
      screen.displayMessageLine( "\nBalance Information:" );
      screen.displayMessage( " - Available balance: " ); 
      screen.displayDollarAmount( availableBalance );
      screen.displayMessage( "\n - Total balance:     " );
      screen.displayDollarAmount( totalBalance );
      screen.displayMessageLine( "" );
   } // end method execute
} // end class BalanceInquiry



/* *************************************************************************
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