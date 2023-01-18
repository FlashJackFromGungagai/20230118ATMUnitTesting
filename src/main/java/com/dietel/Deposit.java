package com.dietel;
//package main.java.com.dietel;
// Deposit.java
// Represents a deposit ATM transaction


////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE Deposit extends Transaction class.
* 
* what this class will do:
* 1. extends Transaction class
* 2. Prompts for the deposiot amount
* 3. Makes the deposit.
*            
*/ 


public class Deposit extends Transaction
{
////////////////////////////////////////////////////////////////////////////////
	
	
	// DECLARE CLASS VARIABLES
   private double amount; // amount to deposit
   private Keypad keypad; // reference to keypad
   private DepositSlot depositSlot; // reference to deposit slot
   private final static int CANCELED = 0; // constant for cancel option

   
 //=========================================================================	
   /*  This CLASS CONSTRUCTOR.....
   *  
   *  Deposit constructor
   *  initialize superclass variables
   *    super( userAccountNumber, atmScreen, atmBankDatabase );
   *    passes up to the transaction parent class.
   */
   // 
   // 
   // 
   public Deposit( 	int userAccountNumber, 
		   			Screen atmScreen, 
		   			BankDatabase atmBankDatabase, 
		   			Keypad atmKeypad, 
		   			DepositSlot atmDepositSlot )
   {
      // initialize superclass variables
      super( userAccountNumber, atmScreen, atmBankDatabase );
      // 

      // initialize references to keypad and deposit slot
      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
   } // end Deposit constructor

   
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////
   
   
	//=========================================================================	
	/*  This method.....
	 * perform transaction.. deposits the funds into the account.
	 */
   // 
   public void execute()
   {
      BankDatabase bankDatabase = getBankDatabase(); // get reference
      Screen screen = getScreen(); // get reference

      amount = promptForDepositAmount(); // get deposit amount from user

      // check whether user entered a deposit amount or canceled
      if ( amount != CANCELED )
      {
         // request deposit envelope containing specified amount
         screen.displayMessage( 
            "\nPlease insert a deposit envelope containing " );
         screen.displayDollarAmount( amount );
         screen.displayMessageLine( "." );

         // receive deposit envelope
         boolean envelopeReceived = depositSlot.isEnvelopeReceived();

         // check whether deposit envelope was received
         if ( envelopeReceived )
         {  
            screen.displayMessageLine( "\nYour envelope has been " + 
               "received.\nNOTE: The money just deposited will not " + 
               "be available until we verify the amount of any " +
               "enclosed cash and your checks clear." );
            
            // credit account to reflect the deposit
            bankDatabase.credit( getAccountNumber(), amount ); 
         } // end if
         else // deposit envelope not received
         {
            screen.displayMessageLine( "\nYou did not insert an " +
               "envelope, so the ATM has canceled your transaction." );
         } // end else
      } // end if 
      else // user canceled instead of entering amount
      {
         screen.displayMessageLine( "\nCanceling transaction..." );
      } // end else
   } // end method execute

   
   
   
   
	//=========================================================================	
	/*  This method.....
	 *  prompt user to enter a deposit amount in cents 
	 */
   // 
   private double promptForDepositAmount()
   {
      Screen screen = getScreen(); // get reference to screen

      // display the prompt
      screen.displayMessage( "\nPlease enter a deposit amount in " + 
         "CENTS (or 0 to cancel): " );
      int input = keypad.getInput(); // receive input of deposit amount
      
      // check whether the user canceled or entered a valid amount
      if ( input == CANCELED ) 
         return CANCELED;
      else
      {
         return ( double ) input / 100; // return dollar amount 
      } // end else
   } // end method promptForDepositAmount
} // end class Deposit



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