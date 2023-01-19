package AppUnderTest;
//package main.java.com.dietel;
// CashDispenser.java
// Represents the cash dispenser of the ATM

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE CashDispenser class.
* 
* what this class will do:
* 1. Check if there is sufficient cash
* 2. Dispense the cash
*            
*/ 
public class CashDispenser 
{
////////////////////////////////////////////////////////////////////////////////
   
	// DECLARE CLASS VARIABLES
	// the default initial number of bills in the cash dispenser
   private final static int INITIAL_COUNT = 500;
   private int count; // number of $20 bills remaining
   
   
   
 //=========================================================================	
   /*  This CLASS CONSTRUCTOR.....
   * 
   * no-argument CashDispenser constructor initializes count to default
   */
   // 
   // 
   // 
   public CashDispenser()
   {
      count = INITIAL_COUNT; // set count attribute to default
   } // end CashDispenser constructor

   
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////

   
   
	//=========================================================================	
	/*  This method.....
	 * simulates dispensing of specified amount of cash
	 * Not that it dispenses only $20 bills
	 */
   // 
   public void dispenseCash( int amount )
   {
      int billsRequired = amount / 20; // number of $20 bills required
      count -= billsRequired; // update the count of bills
   } // end method dispenseCash

   
   
	//=========================================================================	
	/*  This method.....
	 * indicates whether cash dispenser can dispense desired amount
	 * The amounts have to multiples of $20 bills required
	 */
   // 
   public boolean isSufficientCashAvailable( int amount )
   {
      int billsRequired = amount / 20; // number of $20 bills required

      if ( count >= billsRequired  )
         return true; // enough bills available
      else 
         return false; // not enough bills available
   } // end method isSufficientCashAvailable
} // end class CashDispenser



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