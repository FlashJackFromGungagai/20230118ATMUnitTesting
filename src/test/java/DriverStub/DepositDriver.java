package DriverStub;
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


public class DepositDriver extends TransactionStub
{
////////////////////////////////////////////////////////////////////////////////
	
	
	// DECLARE CLASS VARIABLES
   private double amount; // amount to deposit
   private KeypadStub keypad; // reference to keypad
   
   private DepositSlotDriver depositSlot; // reference to deposit slot
   // This was the old version
   // private DepositSlot depositSlot; // reference to deposit slot
   
   
   private final static int CANCELED = 0; // constant for cancel option
   
   
   // THIS IS ADDED CAPABILITY TO THIS CLASS
    //DepositSlotSimpTimedDriver
   private String sessionName = "ActiveSession";
   //private  DepositSlotSimpTimedDriver
	 
   private DepositSlotAdvTimedDriver DepositSlotTimed = new DepositSlotAdvTimedDriver(sessionName );
	  // this passes the name of the new Session.
   
  

   
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
   public DepositDriver(int userAccountNumber,
                        ScreenStub atmScreen,
                        BankDatabaseStub atmBankDatabase,
                        KeypadStub atmKeypad,
                        DepositSlotDriver atmDepositSlot )
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
	  boolean depositSlotState =false;
	   
      BankDatabaseStub bankDatabase = getBankDatabase(); // get reference
      ScreenStub screen = getScreen(); // get reference
      boolean envelopeReceived = false;

      amount = promptForDepositAmount(); // get deposit amount from user

      // check whether user entered a deposit amount or canceled
      if ( amount != CANCELED )
      {
    	  
    	  depositSlotState=DepositSlotTimed.activateSlot();
    	  // activate the desposit slot to receive the deposit envelope
    	  
    	  depositSlot.setMoneyReceivedProcessExecutedFalse();
    	  // this sets the flag to receive money that prevents
    	  // depositing money after depost process times out
    	  
    	  
    	  if (depositSlotState==true)
    	  //the deposit of funds can only occur if the the slot is active
    	  {
    	         // request deposit envelope containing specified amount
    	         screen.displayMessage( "\nPlease insert a deposit envelope containing " );
    	         screen.displayDollarAmount( amount );
    	         screen.displayMessageLine( "." );
    	         
    	        
    	         // this starts the timer

    	         // receive deposit envelope
    	         envelopeReceived = depositSlot.isEnvelopeReceived(depositSlotState);
    	         // this makes the call to the isEnvelopeReceived()
    	         //  in depositSlot
    	         //  if the envelope is received, depositSlot.isEnvelopeReceived();
    	         //	 will return true.
    	         
    	         // check whether deposit envelope was received
    	         if ( envelopeReceived )
    	         {  
    	            screen.displayMessageLine( "\nYour envelope has been " + 
    	               "received.\nNOTE: The money just deposited will not " + 
    	               "be available until we verify the amount of any " +
    	               "enclosed cash and your checks clear." );
    	            
    	            // credit account to reflect the deposit
    	            bankDatabase.credit( getAccountNumber(), amount ); 
    	      	  
    	            
    	            depositSlotState= DepositSlotTimed.deActivateSlot();
    	      	  // deactivate the desposit slot to not receive the deposit envelope
    	      	  
    	         } // end if ( envelopeReceived )
    	         else // deposit envelope not received
    	         {
    	            screen.displayMessageLine( "\nYou did not insert an " +
    	               "envelope, so the ATM has canceled your transaction." );
    	         } // end else
    	         
 
    	  }// end if (depositSlotState==true)
    	  

         
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
	   DepositSlotTimed.deActivateSlot();
	   // ensure you cannot receive the funds while entering the funds. 
	   
	  ScreenStub screen = getScreen(); // get reference to screen

      // display the prompt
      screen.displayMessage( "\nPlease enter a deposit amount in CENTS (or 0 to cancel): " );
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