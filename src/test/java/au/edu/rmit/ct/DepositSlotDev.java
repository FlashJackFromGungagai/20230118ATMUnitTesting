package au.edu.rmit.ct;
//package main.java.com.dietel;


// DepositSlot.java
// Represents the deposit slot of the ATM

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE DepositSlot class.
* 
* what this class will do:
* 1. returns a Boolean 'True' value when a deposit envelope is deposited.
*            
*/ 

public class DepositSlotDev 
{
	// There is no CONSTRUCTOR in the orignal class
	//  Constructors will be added.
	
	   // THIS IS ADDED CAPABILITY TO THIS CLASS
    //DepositSlotTimed 
   private String sessionName ;
   //private  DepositSlotTimed 
	 
   private DepositSlotTimedDev  DepositSlotTimed ;
	  // this passes the name of the new Session.
   
   //private boolean MoneyReceivedDeposited =false;
   private boolean MoneyReceivedProcessExecuted;
   
   public DepositSlotDev() throws Exception
   {
	   sessionName = "ActiveSession";
	   long WaitTime=4000;
	   DepositSlotTimed = new DepositSlotTimedDev(sessionName,WaitTime  );
	   MoneyReceivedProcessExecuted = false;
   }
	
   
	//=========================================================================	
	/*  This method.....
	 *  sets the MoneyReceivedProcessExecuted flag back to False
	 *  so money can be received.
	 * 
	 * 
	 * 
	 * 
	 */
   public void setMoneyReceivedProcessExecutedFalse()
   {
	   MoneyReceivedProcessExecuted = false;
	   
   }// end public void setMoneyReceivedProcessExecutedFalse()
   
   
   
   
	//=========================================================================	
	/*  This method.....
	 * indicates whether envelope was received (always returns true, 
	 * because this is only a software simulation of a real deposit slot)
	 * 
	 * this is where the call to DepositSlotTime class will be made
	 * 
	 */
	// 
   // 
   public boolean isEnvelopeReceived(boolean slotIsActivated)
   {

	   //long startTime = System.currentTimeMillis();
	  // long endTime = startTime+5000;
	   boolean SlotOPenTimeCompleted=false;
	   boolean MoneyReceivedDeposited =false;
	   
	   if (MoneyReceivedProcessExecuted == false)
	   // this is meant to ensure this process is only executed once
	   {
		  
		   // MoneyReceivedDeposited is only true if the slot is active and 
		  // the timer the slot has opened for 5000 milliseconds.
		   if (slotIsActivated ==true)
		   {
			    this.DepositSlotTimed.checkTimer();
			    SlotOPenTimeCompleted=true;

			   
		   }// end  if (slotIsActivated ==true)
		   

	   
		   if ( (slotIsActivated ==true)&& ( SlotOPenTimeCompleted==true  ) )
		   {
			   MoneyReceivedDeposited = true;
			   MoneyReceivedProcessExecuted= true;
			   
		   }// end if  if ( (slotIsActivated ==true)&& ( SlotOPenTimeCompleted==true  ) )
		   
		   else 
		   {
			   MoneyReceivedDeposited = false;
			   
		   }//  else if ( (slotIsActivated ==true)&& ( SlotOPenTimeCompleted==true  ) )

		   
		   
	   }//end if (MoneyReceivedProcessExecuted == false)
	   
	   return MoneyReceivedDeposited;
	   

   } // end method isEnvelopeReceived
} // end class DepositSlot



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