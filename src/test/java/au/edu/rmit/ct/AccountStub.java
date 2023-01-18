package au.edu.rmit.ct;
// 
// 

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE Account class.
* 
* what this class will do:
* 1. Represents a bank account
*            
*/ 



public class AccountStub 
{
////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private double availableBalance; // funds available for withdrawal
   private double totalBalance; // funds available + pending deposits


 //=========================================================================	
   /*  This CLASS CONSTRUCTOR.....
   * Account constructor initializes attributes
   */
   // 
   // 
   // 
   public AccountStub( 	int theAccountNumber, 
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
      if ( userPIN == pin )
      {
    	  // set the session..ActiveSession

    	  //this activates the slot.
    	  
         return true;
      }
    	  
      else
         return false;
   } // end method validatePIN

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * returns account number
	 * returns available balance
	 */
  // 
   // 
   public double getAvailableBalance()
   {
      return availableBalance;
   } // end getAvailableBalance

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * returns account number
	 */
  // 
   // returns the total balance
   public double getTotalBalance()
   {
      return totalBalance;
   } // end method getTotalBalance

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * returns account number
	 * credits an amount to the account
	 */
  // 
   // 
   public void credit( double amount )
   {
      totalBalance += amount; // add to total balance
   } // end method credit

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * 
	 */
  // returns account number
   // debits an amount from the account
   public void debit( double amount )
   {
      availableBalance -= amount; // subtract from available balance
      totalBalance -= amount; // subtract from total balance
   } // end method debit

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * 
	 */
   // returns account number
   public int getAccountNumber()
   {
      return accountNumber;  
   } // end method getAccountNumber
} // end class Account


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