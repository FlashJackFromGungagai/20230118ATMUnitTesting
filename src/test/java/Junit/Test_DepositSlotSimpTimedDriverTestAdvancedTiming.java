package Junit;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import DriverStub.DepositSlotDriver;
		import DriverStub.DepositSlotAdvTimedDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

//import AppUnderTest.ATM;

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE Test_DepositSlotSimpTimedDriverTestAdvancedTiming.
* 
* what this class will do:
* 1. 	Check that the Deposit Slot will not allow deposit to be received before 
*    	it's activated, but will allow deposits during the period of activation, 
*    	and will once again stop allowing deposits after the period of activation. 
*    	Use the provided Junit Test class. (May be one or more test methods).
*    
* 2.	The implied user stories as a result, iterating backwards, 
* 		that I understand shall be…
* 		
* 		USR01: As a bank manager, I want to ensure that customers cannot deposit 
* 		funds into their account during the deposit process from an ATM machine 
* 		when the customer account is not activated to receive funds; so that 
* 		all customer accounts are securely protected.
* 
* 		USR02: As a bank manager, I want to ensure that customers can deposit 
* 		funds into their account during the deposit process from an ATM machine 
* 		when the customer account is activated to receive funds; so that all 
* 		customer accounts are securely protected.
* 
* 		USR03: as a bank manager, , I want to ensure that customers cannot 
* 		deposit funds into their account during the deposit process from an 
* 		ATM machine after the defined customer account activation period has the 
* 		timed out [this shall be set by the bank customer account administration 
* 		staff]; so that all customer accounts are securely protected.
* 
* 3.	From this, the following Acceptance Criteria have been derived:
* 
* 		TC01: Verify that you cannot deposit funds when the customer account 
* 				is not activated to receive them.
* 
* 		TC02: Verify that you can deposit funds into your account when the 
* 				customer account is activated to receive them.
* 
* 		TC03: Verify that you cannot deposit funds when the customer 
* 				account activation period times out.
* 
* 		
* From this a special test environment has been created to develop and test
* modifications to the deposit.java, DepositSlot.java, DepositSlotTime.java classes
* with:
* 
* 4. all classes relating to the deposit process have been copied to this au.edu.rmit.ct package
*    to isolate them from the com.dietal classes
*    
* 5. we are making development changes to the deposit.java, DepositSlot.java,
* 		 DepositSlotTime.java classes that were originally in the com.dietal class
* 		 in order to comply with the User Requirements.
* 
* 6. the development deposit classes are:
* 		depositDev.java, DepositSlotDriver.java, DepositSlotTimeDev.java classes.
* 
* 7. These deposit development classes rely on a number of stub classes that 
* 		have been modified from their orginal com.dietal source classes.
* 
* 8. These stub classes are identified as "XXXStub.java. They are in the same package as the 
* 		test class for them, for this test these classes as well as the XXXDev.java classes
* 
* 
* 
* 

* 
* 
* 
* 
*            
*/ 
class Test_DepositSlotSimpTimedDriverTestAdvancedTiming
{
	////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES...
	//private static ATMStub theATM ;
	private static DepositSlotDriver DepositSlot;
	private static DepositSlotAdvTimedDriver DepositSlotTimed;
	private static  String sessionName ;
	private boolean slotIsActivated;
	private boolean depositFundsSuccess;
   
	//THIS IS THE CLASS CONSTRUCTOR....
	
	
	
	////////////////////////////////////////////////////////////////////////////////
	//Class Methods from here...
	////////////////////////////////////////////////////////////////////////////////


	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@Test
	public void test_TC01() throws Exception 
	{
		/*
		 * 
		 */
		
		// the expected result shall be you cannot deposit funds.
		slotIsActivated =false;
		DepositSlot = new DepositSlotDriver();
		sessionName = "ActiveSession";
		DepositSlotTimed = new DepositSlotAdvTimedDriver(sessionName);
		boolean testResult;
		
		
		System.out.println("TC01: Verify that you cannot deposit funds when the customer account \n"
				           +"       is not activated to receive them.");
		System.out.println();
		
		testResult = (depositFundsSuccess=false) == DepositSlot.isEnvelopeReceived(false) ;
		assertTrue(testResult );
		System.out.println(">>This means the isEnvelopeReceived() will return false  \n"
		          +"         when slotIsActivated is false .");
		System.out.println();
		
		if (testResult)
		{
			System.out.println("Result: Test validated");
		}
		else
		{
			System.out.println("Result: Test not validated");
		}
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println();
		

		
		
	} // end public void test_TC01()
	

	
	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@Test
	public void test_TC02() throws Exception
	{
		/*
		 * 
		 */
		slotIsActivated =true;
		DepositSlot = new DepositSlotDriver();
		sessionName = "ActiveSession";
		DepositSlotTimed = new DepositSlotAdvTimedDriver(sessionName);
		boolean testResult;
		
		
		System.out.println("TC02: Verify that you can deposit funds into your account when the \n"
				           + "      customer account is activated to receive them.");
		System.out.println();
		
		testResult = (depositFundsSuccess=true) == DepositSlot.isEnvelopeReceived(slotIsActivated) ;
		assertTrue( testResult );		
		
		
		System.out.println(">>This means the isEnvelopeReceived() will return true  \n"
		           +"         when slotIsActivated is true .");
		System.out.println();
		
		if (testResult)
		{
			System.out.println("Result: Test validated");
		}
		else
		{
			System.out.println("Result: Test not validated");
		}		
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println();
		
		
		
	} // end public void test_TC02()
	


   
	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@Test
	public void test_TC03() throws Exception
	{
		/*
		 * 
		 */
		
		slotIsActivated =true;
		DepositSlot = new DepositSlotDriver();
		sessionName = "ActiveSession";
		DepositSlotTimed = new DepositSlotAdvTimedDriver(sessionName);
		boolean firstDepositResult;
		// the result of the first deposit should be true, a sucessful deposit
		
		boolean SecondDepositResult;
		// the result of the second deposit should be false, an unsucessful deposit
		
		boolean testResult;
		
		System.out.println("TC03: Verify that you cannot deposit funds when the customer \n"
				           + "      account activation period times out.");
		System.out.println();
		
		firstDepositResult = ( (depositFundsSuccess=true) == DepositSlot.isEnvelopeReceived(true)  );
		// this test must be true
		SecondDepositResult= ( (depositFundsSuccess=false) == DepositSlot.isEnvelopeReceived(true)  ); 
		// this test must be true
		
		testResult = (firstDepositResult&&SecondDepositResult);
		
		assertTrue( testResult );
		
		
		System.out.println(">>This means the isEnvelopeReceived() will return true  \n"
		           +"         when slotIsActivated is true, the first time you call this method; \n "
		           +"         but isEnvelopeReceived() will return false, \n"
		           + "        when slotIsActivated is true, but you call this method a second time.");
		System.out.println();
		
		if (testResult)
		{
			System.out.println("Result: Test validated");
		}
		else
		{
			System.out.println("Result: Test not validated");
		}
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println();

		
	} // end
      
	   
	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		
	} // end
	
	

} // end DepositSlotTimedTestAdvancedTiming 
