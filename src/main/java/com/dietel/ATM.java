//package com.dietel;
package com.dietel;
// ATM.java
// 

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* -------------------------------------------------------------------------
*            THIS IS THE ATM class.
* 
* what this class will do:
* 1. Represents an automated teller machine
* 2. instantiates other classes such as the Screen, keypad, CashDispenser,
 *     DepositSlot, BankDatabase classes.
*/ 

public class ATM 
{
	////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES
   private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   
   // Declare class object types
   private Screen screen; // ATM's screen
   private Keypad keypad; // ATM's keypad
   private CashDispenser cashDispenser; // ATM's cash dispenser
   private DepositSlot depositSlot; // ATM's deposit slot
   private BankDatabase bankDatabase; // account information database

   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int EXIT = 4;

   ////////////////////////////////////////////////////////////////////////////////
   //Class constructors from here...
   ////////////////////////////////////////////////////////////////////////////////

 //=========================================================================	
   /*  This CLASS CONSTRUCTOR.....
   *   This constructor does not take input arguments, but instead
   *     instantiates other classes such as the Screen, keypad, CashDispenser,
   *     DepositSlot, BankDatabase classes.
   */

   public ATM() 
   {
      userAuthenticated = false; // user is not authenticated to start
      currentAccountNumber = 0; // no current account number to start
      
      // Instantiates the objects used by the ATM.
      screen = new Screen(); // create screen
      keypad = new Keypad(); // create keypad 
      cashDispenser = new CashDispenser(); // create cash dispenser
      depositSlot = new DepositSlot(); // create deposit slot
      bankDatabase = new BankDatabase(); // create acct info database
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
      try
      {
         // welcome and authenticate user; perform transactions
         while ( true )
         {
            // loop while user is not yet authenticated
            while ( !userAuthenticated )
            {
               screen.displayMessageLine( "\nWelcome!" );
               authenticateUser(); // authenticate user
            } // end while

            performTransactions(); // user is now authenticated
            userAuthenticated = false; // reset before next ATM session
            currentAccountNumber = 0; // reset before next ATM session
            screen.displayMessageLine( "\nThank you! Goodbye!" );

         } // end while
      }// close the try block
      catch (Exception e)
      {
         System.out.println("there was a problem:"+e);
      }//close the catch block.


   } // end method run
   
   
   
   
//=========================================================================	
/*  This method.....
 * attempts to authenticate user against database
 */
   // 
   private void authenticateUser() 
   {
      screen.displayMessage( "\nPlease enter your account number: " );
      int accountNumber = keypad.getInput(); // input account number
      screen.displayMessage( "\nEnter your PIN: " ); // prompt for PIN
      int pin = keypad.getInput(); // input PIN
      
      // set userAuthenticated to boolean value returned by database
      userAuthenticated = 
         bankDatabase.authenticateUser( accountNumber, pin );
      
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
      Transaction currentTransaction;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while ( !userExited )
      {     
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenu();

         // decide how to proceed based on user's menu selection
         switch (mainMenuSelection) {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY, WITHDRAWAL, DEPOSIT ->
            // this is using a lambda style of case statement
            {

               // initialize as new object of chosen type
               currentTransaction =
                       createTransaction(mainMenuSelection);
               currentTransaction.execute(); // execute transaction
            }
            case EXIT -> { // user chose to terminate session
               screen.displayMessageLine("\nExiting the system...");
               userExited = true; // this ATM session should end
            }
            default -> // user did not enter an integer from 1-4
                    screen.displayMessageLine(
                            "\nYou did not enter a valid selection. Try again.");
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
      screen.displayMessageLine( "\nMain menu:" );
      screen.displayMessageLine( "1 - View my balance" );
      screen.displayMessageLine( "2 - Withdraw cash" );
      screen.displayMessageLine( "3 - Deposit funds" );
      screen.displayMessageLine( "4 - Exit\n" );
      screen.displayMessage( "Enter a choice: " );
      return keypad.getInput(); // return user's selection
   } // end method displayMainMenu
       
   
   
   
	//=========================================================================	
	/*  This method.....
	 *      Return object of specified Transaction subclass
	 *      Performs operations of either BALANCE_INQUIRY, WITHDRAWAL, DEPOSIT
	 *      Transaction type passed in.
	 */
   // 
   private Transaction createTransaction( int type )
   {
      // end switch
      Transaction temp = switch (type) {
         case BALANCE_INQUIRY -> // create new BalanceInquiry transaction
                 new BalanceInquiry(
                         currentAccountNumber,
                         screen,
                         bankDatabase);
         case WITHDRAWAL -> // create new Withdrawal transaction
                 new Withdrawal(
                         currentAccountNumber,
                         screen,
                         bankDatabase,
                         keypad,
                         cashDispenser);
         case DEPOSIT -> // create new Deposit transaction
                 new Deposit(
                         currentAccountNumber,
                         screen,
                         bankDatabase,
                         keypad,
                         depositSlot);
         default -> null; // temporary Transaction variable

         // determine which type of Transaction to create
      };

      return temp; // return the newly created object
   } // end method createTransaction
} // end class ATM



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