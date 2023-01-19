/**
 *  Update of the Deposit Slot to simulate Timed activation of the slot
 *  
 */

package DriverStub;

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*  THIS IS THE DepositSlotTimed extends AppUnderTest.DepositSlot implements Runnable
* 
* what this class will do:
* 1. 
*            
*/

import AppUnderTest.DepositSlot;

public class DepositSlotTimedDev extends DepositSlot implements Runnable
{
////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES
	private Thread t;
	private String threadName;
	
	private boolean modeActive = false;
	// when modeActive is false, 
	// Slot is deactivated
	//
	// when modeActive is true,
	// Slot is activated
	
	private long waitTime = 4000; // default wait time
	
	private boolean debug = false; //set to false to suppress debug methods.
	// when set to true, this class prints debug messages.
	// when set to false, this class will not print debug messages.

	
	
	// CLASS CONSTRUCTOR
	DepositSlotTimedDev(String name) 
	{
		threadName = name;
		if(debug) System.out.println("Creating " + threadName);
	} // end 

	
	
	
	
	
	// CLASS CONSTRUCTOR
	DepositSlotTimedDev(String name, long customWaitTime) throws Exception 
	{
		if(customWaitTime > 5000)
			throw new IllegalWaitTimeException("Your custom wait time of "+ customWaitTime+ " is too high");
		threadName = name;
		this.waitTime = customWaitTime;
		if(debug)  System.out.println("Creating " + threadName);
		
	}// end DepositSlotTimed(String name, long customWaitTime) throws Exception 
	
	
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////
	

	
	//=========================================================================	
	/*  This method.....
	 * 
	 */
	public void run() 
	{
		if(debug)  System.out.println("Running " + threadName);
		try {
				if(debug)  System.out.println("Thread: " + threadName + "set to run");
				this.activateSlot(); // allow deposits to be received - activate the slot
				Thread.sleep(waitTime); // ... by wait_time
				
			} // end try block
		
		catch (InterruptedException e) 
			{
				if(debug)  System.out.println("Thread " + threadName + " interrupted.");
				
			}// end catch block
		
		finally 
			{
				if(debug) System.out.println("Thread " + threadName + " exiting.");
				deActivateSlot(); // at end of the wait time deactivate the slot.
			
			}// end finally block
		
	}// end public void run() 
	
	
	
	
	//=========================================================================	
	/*  This method.....checks if open for Deposit.
	 *  Access changed to public.
	 */
	public boolean isOpenForDeposit() 
	{
		return this.modeActive;
		// if modeActive= true, Slot is activated
		// if modeActive= false, Slot is deactivated
		
		
	}// end boolean isOpenForDeposit() 
	
	
	
	
	//=========================================================================	
	/*  This method.....checks if the envelope can be received
	 *  Access changed to public.
	 */
	public boolean receiveEnvelope() 
	{
		if (modeActive == false) 
		{
			return false;
		} else 
		{
			return true;
		}
	}// end boolean receiveEnvelope()
	
	
	
	
	//=========================================================================	
	/*  This method.....this method activates the slot with the timer.
	 *  Access changed to public.
	 */
	public void activateSlotWithTimedShut() 
	{
		this.start();
		
	}// end void activateSlotWithTimedShut() 
	
	
	
	
	//=========================================================================	
	/*  This method. starts a timer thread
	 *  Access changed to public.
	 */	
	public void start() 
	{
		if(debug) System.out.println("Starting " +  threadName );
	    if (t == null) 
	    {
		
	    	t = new Thread (this, threadName );
			if(debug) System.out.println("Created new t Thread " +  threadName );
    		t.start ();
    		
	    }// close  if (t == null)
	    
	}// end private void start() 
	
	
	
	
	//=========================================================================	
	/*  This method.....activates  the slot.
	 * It was originally Private, changed to public
	 *  Access changed to public.
	 *  method changed from void to boolean
	 */
	public boolean activateSlot() 
	{
		this.modeActive = true; // or set error.
		// this.run();
		// this call to run() has been commented out so that 
		// it does not cause an overflow error.
		return modeActive;
		
	}// end private void activateSlot()
	
	
	
	
	//=========================================================================	
	/*  This method.....deActivates the slot.
	 *  Access changed to public.
	 *  method changed from void to boolean
	 */
	public boolean deActivateSlot() 
	{ // sets deposit slot to be available for deposits
		this.modeActive = false;
		return modeActive;
	}// end private void deActivateSlot()
	
	
	
	
	//=========================================================================	
	/*  This method.....
	 * 
	 */
	public void checkTimer() 
	{
		this.run();
		
	}// end public void checkTimer() 
	
}// end public class DepositSlotTimed extends main.java.AppUnderTest.DepositSlot implements Runnable
