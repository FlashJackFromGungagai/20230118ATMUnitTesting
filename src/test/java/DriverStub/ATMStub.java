//package com.dietel;
package DriverStub;
// ATM.java
// 

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE ATMStub class.
* 
* what this class will do:
* 1. 	This class has been editied so that it acts as a stub class
* 		in order to test and develop the deposit.class
*            
*/ 



public class ATMStub 
{
	////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES
   private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   
   // Declare class object types
   private ScreenStub screen; // ATM's screen
   private KeypadStub keypad; // ATM's keypad
  // private CashDispenser cashDispenser; // ATM's cash dispenser
   
   //private DepositSlot depositSlot; // ATM's deposit slot
   // this was the previous link to the previous of DepositSlot
   private DepositSlotDev depositSlot; // ATM's deposit slot
   // This is pointing to the development version of DepositSlot
   
   private BankDatabaseStub bankDatabase; // account information database

   // constants corresponding to main menu options
   //all options except depost have been commented out.
   //private static final int BALANCE_INQUIRY = 1;
  // private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int EXIT = 4;

   
 //=========================================================================	
   /*  This CLASS CONSTRUCTOR.....
   * 
   *   1. no-argument ATM constructor initializes instance variables
   */
   // 
   // 
   // 
   public ATMStub() throws Exception
   {
      userAuthenticated = false; // user is  authenticated to start
      // normal state is userAuthenticated = false;
      // to authenticate user.
      // this has been edited to bypass the Authenticated user method
      // 
      
      
      currentAccountNumber = 0; // no current account number to start
      
      // Instantiates the objects used by the ATM.
      screen = new ScreenStub(); // create screen
      keypad = new KeypadStub(); // create keypad 
     // cashDispenser = new CashDispenser(); // create cash dispenser
      depositSlot = new DepositSlotDev(); // create deposit slot
      bankDatabase = new BankDatabaseStub(); // create acct info database
   } // end no-argument ATM constructor

   
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////
   
   
   
   
//=========================================================================	
/*  This method.....
 * starts the ATM
 */
   //  
   public void run()
   {
      // welcome and authenticate user; perform transactions
      while ( true )
      {
         // loop while user is not yet authenticated
    	  
         while ( !userAuthenticated ) 
         {
            screen.displayMessageLine( "\nWelcome!" );       
            authenticateUser(); // authenticate user
         } // end while ( !userAuthenticated ) 
         
         
         
         performTransactions(); // user is now authenticated 
         userAuthenticated = false; // reset before next ATM session
         currentAccountNumber = 0; // reset before next ATM session 
         screen.displayMessageLine( "\nThank you! Goodbye!" );
         
      } // end while ( true )
      
      
   } // end method run()
   
   
   
   
//=========================================================================	
/*  This method.....attempts to authenticate user against database
 * 	This has been stubbed out
 * accounts[ 0 ] = new AccountStub( 12345, 54321, 1000.0, 1200.0 );
 * 
 */
   // 
   private void authenticateUser() 
   {
      screen.displayMessage( "\nPlease enter your account number: 12345" );
      //int accountNumber = keypad.getInput(); // input account number
      // this has been stubbed out
      int accountNumber = 12345;
      // the accountNumber has been hard coded 
      
      screen.displayMessage( "\nEnter your PIN: 54321" ); // prompt for PIN
      //int pin = keypad.getInput(); // input PIN
      // this has been stubbed out
      int pin = 54321;
      
      
      // set userAuthenticated to boolean value returned by database
      userAuthenticated = bankDatabase.authenticateUser( accountNumber, pin );
      
      // check whether authentication succeeded
      if ( userAuthenticated )
      {
         currentAccountNumber = accountNumber; // save user's account #
      } // end if
      else
         screen.displayMessageLine( 
             "Invalid account number or PIN. Please try again." );
   } // end method authenticateUser
   
   
   
   
//=========================================================================	
/*  This method.....
 * display the main menu and perform transactions
 */
   // 
   private void performTransactions() 
   {
      // local variable to store transaction currently being processed
      TransactionStub currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while ( !userExited )
      {     
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenu();
    	  // the call to this method displayMainMenu(); has been commented out
    	  //int mainMenuSelection = 3;
    	  // this has been hard coded to choose to deposit always
         

         // decide how to proceed based on user's menu selection
         switch ( mainMenuSelection )
         {
            // user chose to perform one of three transaction types
            //case BALANCE_INQUIRY: 
         	// The case BALANCE_INQUIRY has been commented out
         	// as it is not needed in this stub
         
            //case WITHDRAWAL: 
      		// The case WITHDRAWAL has been commented out
      		// as it is not needed in this stub        	
            	
            	
            /*
             * This has been hard coded to only perform
             * Deposit operations	
             */
            case DEPOSIT:

               // initialize as new object of chosen type
               currentTransaction = 
                  createTransaction( mainMenuSelection );

               currentTransaction.execute(); // execute transaction
               break; 
               
            
               
            case EXIT: // user chose to terminate session
               screen.displayMessageLine( "\nExiting the system..." );
               userExited = true; // this ATM session should end
               break;
               
               
            default: // user did not enter an integer from 1-4
               screen.displayMessageLine( 
                  "\nYou did not enter a valid selection. Try again." );
               break;
              
               
         } // end switch
      } // end while
   } // end method performTransactions
   
   
   
   
   
   
//=========================================================================	
/*  This method.....
 * display the main menu and return an input selection
 */
   // 
   private int displayMainMenu()
   {
	   screen.displayMessageLine( "   " );
	   screen.displayMessageLine( "\nMain menu:" );
      //screen.displayMessageLine( "1 - View my balance" );
      //screen.displayMessageLine( "2 - Withdraw cash" );
      screen.displayMessageLine( "3 - Deposit funds" );
      screen.displayMessageLine( "4 - Exit\n" );
      screen.displayMessage( "Enter a choice: " );
      return keypad.getInput(); // return user's selection
   } // end method displayMainMenu
       
   
   
   
	//=========================================================================	
	/*  This method.....
	 * return object of specified Transaction subclass
	 */
   // 
   private TransactionStub createTransaction( int type )
   {
      TransactionStub temp = null; // temporary Transaction variable
      
      // determine which type of Transaction to create     
      switch ( type )
      {
      /* 
      
         case BALANCE_INQUIRY: // create new BalanceInquiry transaction
            temp = new BalanceInquiry( 
            							currentAccountNumber, 
            							screen, 
            							bankDatabase );
            break;
            
         case WITHDRAWAL: // create new Withdrawal transaction
            temp = new Withdrawal( 
            							currentAccountNumber, 
            							screen, 
            							bankDatabase, 
            							keypad, 
            							cashDispenser );
            break; 
         
          * 
       */   
            
         case DEPOSIT: // create new Deposit transaction
            temp = new DepositDev( 
            							currentAccountNumber, 
            							screen, 
            							bankDatabase, 
            							keypad, 
            							depositSlot );
            break;
      } // end switch

      return temp; // return the newly created object
   } // end method createTransaction
} // end class ATM



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