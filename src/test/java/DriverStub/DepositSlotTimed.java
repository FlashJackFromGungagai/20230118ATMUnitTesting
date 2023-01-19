/**
 *  Update of the Deposit Slot to simulate Timed activation of the slot
 *  
 */

package DriverStub;
import AppUnderTest.DepositSlot;
// this is used to import the DepositSlot class that is in com.dietel.* and to extend it

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE BankDatabaseNew class.
* 
* what this class will do:
* 1. 
*            
*/ 

//public class DepositSlotTimed extends AppUnderTest.DepositSlot implements Runnable
public class DepositSlotTimed extends DepositSlot implements Runnable
{
	////////////////////////////////////////////////////////////////////////////////
	// DECLARE CLASS VARIABLES
	////////////////////////////////////////////////////////////////////////////////
	private Thread threadInstance;
	// a new instance of the Thread object

	private String threadName;
	// the name of a new thread instance

	private boolean slotOpenState = false;
	// this determines of the deposit slot is open or closed.
	// if slotOpenState = false the deposit slot is closed.
	// if slotOpenState = true the deposit slot is open.

	private long waitTime = 1200; // default wait time

	private boolean debug = true;
	// If debug = true execution will produce diagnostic messages.



	////////////////////////////////////////////////////////////////////////////////
	//CLASS CONSTRUCTORS from here...
	////////////////////////////////////////////////////////////////////////////////

	// Class constructor taking the thread name
	/*
	public DepositSlotTimed(String name)
	{
		threadName = name;
		if(debug) System.out.println("Creating " + threadName);
	} // end

	 */

	// CLASS CONSTRUCTOR
	public DepositSlotTimed(String name, long customWaitTime)
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
	 *		Multi-threading in Java is done by defining run() and invoking start().
	 */
	public void run()
	{
		if(debug)  System.out.println("Running " + threadName);
		try {
				if(debug)  System.out.println("Thread: " + threadName + "set to run");
				this.closedSlotToOpen(); // allow deposits to be received - activate the slot
				Thread.sleep(waitTime); // ... by wait_time

			} // end try block

		catch (InterruptedException e)
			{
				if(debug)  System.out.println("Thread " + threadName + " interrupted.");

			}// end catch block

		finally
			{
				if(debug) System.out.println("Thread " + threadName + " exiting.");
				this.openSlotToClosed(); // at end of the wait time deactivate the slot.

			}// end finally block

	}// end public void run()




	//=========================================================================
	/*  This method.....
	 *  determines whether the deposit slot is open or closed for a deposit
	 */
	public boolean isOpenForDeposit()
	{
		return this.slotOpenState;

	}// end boolean isOpenForDeposit()




	//=========================================================================
	/*  This method.....
	 * 		determines if the deposit in the envelope has been received or not
	 * 		If the deposit envelope has been received by the ATM it is true
	 */
	public boolean haveReceivedEnvelope()
	{
		if (slotOpenState== false)
		// slotOpenState == false
		{
			return false;
		} else {
			return true;
		}
	}// end boolean receiveEnvelope()




	//=========================================================================
	/*  This method.....
	 * 		Will start a thread, but does not change the mode of the slot
	 */
	public void openClosedSlot()
	{
		this.start();

	}// end void openClosedSlot()




	//=========================================================================
	/*  This method.....
	 * 		Will start a new thread instance
	 * 		Multi-threading in Java is done by defining run() and invoking start().
	 * 		The start() method internally calls the run() method of Runnable
	 * 		interface to execute the code specified in the run() method in a separate thread
	 */
	private void start()
	{
		if(debug) System.out.println("Starting " +  threadName );
	    if (threadInstance == null)
		{

			threadInstance = new Thread (this, threadName );
			if(debug) System.out.println("Created new t Thread " +  threadName );
			threadInstance.start ();
	    }
	}// end private void start()




	//=========================================================================
	/*  This method.....
	 *
	 */
	private void closedSlotToOpen()
	{
		this.slotOpenState = true; // or set error.
		// this.run();
		// this call to run() has been commented out so that
		// it does not cause an overflow error.

	}// end private void openClosedSlot()




	//=========================================================================
	/*  This method.....
	 *
	 */
	private void openSlotToClosed()
	{ // sets deposit slot to be not available for deposits
		this.slotOpenState = false;
	}// end private void closeOpenSlot()




	//=========================================================================
	/*  This method.....
	 *
	 */
	public void checkTimer()
	{
		this.run();

	}// end public void checkTimer()

}// end public class DepositSlotTimed extends main.java.AppUnderTest.DepositSlot implements Runnable
