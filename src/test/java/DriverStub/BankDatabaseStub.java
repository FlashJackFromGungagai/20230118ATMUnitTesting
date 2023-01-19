package DriverStub;
import AppUnderTest.*;
//package main.java.com.dietel;
// BankDatabase.java
// Represents the bank account information database


////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE BankDatabase class.
* 
* what this class will do:
* 1.  getAccount( int accountNumber ) returtns the currrentAccount
* 2.  boolean authenticateUser( int userAccountNumber, int userPIN )
*            
*/ 



public class BankDatabaseStub
{
////////////////////////////////////////////////////////////////////////////////
   private Account accounts[]; 
   // array of Accounts

   
   
 //=========================================================================	
   /*  This CLASS CONSTRUCTOR.....
   * no-argument BankDatabase constructor initializes accounts
   */
   // 
   // 
   public BankDatabaseStub()
   {
      accounts = new Account[ 3 ]; // just 2 accounts for testing
      accounts[ 0 ] = new Account( 12345, 54321, 1000.0, 1200.0 );
      accounts[ 1 ] = new Account( 98765, 56789, 200.0, 200.0 );
   } // end no-argument BankDatabase constructor

   
   
   
////////////////////////////////////////////////////////////////////////////////
//			Class Methods from here...
////////////////////////////////////////////////////////////////////////////////
   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * retrieve Account object containing specified account number
	 */
   // 
   private Account getAccount( int accountNumber )
   {
      // loop through accounts searching for matching account number
      for ( Account currentAccount : accounts )
      {
         // return current account if match found
         if ( currentAccount.getAccountNumber() == accountNumber )
            return currentAccount;
      } // end for

      return null; // if no matching account was found, return null
   } // end method getAccount
   
   
   
	//=========================================================================	
	/*  This method.....
	 * determine whether user-specified account number and PIN match
	 * those of an account in the database
	 * 
	 */

   // 
   // 
   public boolean authenticateUser( int userAccountNumber, int userPIN )
   {
      // attempt to retrieve the account with the account number
	   Account userAccount = getAccount( userAccountNumber );

      // if account exists, return result of Account method validatePIN
      if ( userAccount != null )
         return userAccount.validatePIN( userPIN );
      else
         return false; // account number not found, so return false
   } // end method authenticateUser

   // return available balance of Account with specified account number
   
   
	//=========================================================================	
	/*  This method.....
	 * gets the available balance
	 */
   public double getAvailableBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getAvailableBalance();
   } // end method getAvailableBalance

   // return total balance of Account with specified account number
   
   
	//=========================================================================	
	/*  This method.....
	 * gets the total balance
	 */
   public double getTotalBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getTotalBalance();
   } // end method getTotalBalance

   // credit an amount to Account with specified account number
   
   
	//=========================================================================	
	/*  This method.....
	 *  credits an amount to the account
	 */
   public void credit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).credit( amount );
   } // end method credit

   // debit an amount from of Account with specified account number
   
   
	//=========================================================================	
	/*  This method.....
	 * debits an amount from the account
	 */
   public void debit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).debit( amount );
   } // end method debit
   
} // end class BankDatabase



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