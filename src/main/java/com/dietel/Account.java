package com.dietel;

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS the parent Account class.
* 
* what this class will do:
    validatePIN( int userPIN ): determines whether a user-specified PIN matches PIN in Account
    getAvailableBalance(): returns the available balance
    getTotalBalance(): returns the total balance for the account number provided
    credit( double amount ): credits an amount to the account total balance
    debit( double amount ): debits an amount from the account total balance
    getAccountNumber(): returns the account number
*            
*/ 


public class Account 
{
////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private double availableBalance; // funds available for withdrawal
   private double totalBalance; // funds available + pending deposits


    ////////////////////////////////////////////////////////////////////////////////
    //Class constructors from here...
    ////////////////////////////////////////////////////////////////////////////////
 //=========================================================================	
   /*  This CLASS CONSTRUCTOR.....
   * This constructor initializes the account class taking in attributes for:
   *    Account Number
   *    Customer PIN
   *    The account available balance for the account number
   *    The account total balance for the account number
   */

   public Account( 	int theAccountNumber, 
		   			int thePIN, 
		   			double theAvailableBalance, 
		   			double theTotalBalance )
   {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
   } // end Account constructor

////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////   
   
   
	//=========================================================================	
	/*  This method.....
	 * determines whether a user-specified PIN matches PIN in Account
	 */
   // 
   public boolean validatePIN( int userPIN )
   {
       //noinspection RedundantIfStatement
       if ( userPIN == pin )
         return true;
      else
         return false;
   } // end method validatePIN

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * returns the available balance
	 */
  // 
   // 
   public double getAvailableBalance()
   {
      return availableBalance;
   } // end getAvailableBalance

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * returns the total balance for the account number provided
	 */
  // 
   // returns the total balance
   public double getTotalBalance()
   {
      return totalBalance;
   } // end method getTotalBalance

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * credits an amount to the account total balance
	 */
  // 
   // 
   public void credit( double amount )
   {
      totalBalance += amount; // add to total balance
   } // end method credit

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * debits an amount from the account total balance
	 */

   public void debit( double amount )
   {
      availableBalance -= amount; // subtract from available balance
      totalBalance -= amount; // subtract from total balance
   } // end method debit

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 *  returns the account number
	 */
   // returns account number
   public int getAccountNumber()
   {
      return accountNumber;  
   } // end method getAccountNumber
} // end class Account


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