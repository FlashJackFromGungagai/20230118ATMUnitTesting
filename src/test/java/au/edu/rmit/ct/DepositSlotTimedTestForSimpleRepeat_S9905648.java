package au.edu.rmit.ct;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE Withdrawal extends Transaction class.
* 
* what this class will do:
* 1. 
*            
*/
class DepositSlotTimedTestForSimpleRepeat_S9905648
{
	////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES...
	private static DepositSlotTimed tc01_DepositSlotTimed;
	private static String DespositSlotTestThread ="" ;
	private static long customWtTime = 1200; // default wait time
   
	//THIS IS THE CLASS CONSTRUCTOR....
	
	
	
	////////////////////////////////////////////////////////////////////////////////
	//Class Methods from here...
	////////////////////////////////////////////////////////////////////////////////

	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		
		//BankDatabaseNew tc01 = new BankDatabaseNew();
		//DepositSlotTimed(String name, long customWaitTime) throws Exception
		DespositSlotTestThread = "tmp";
		customWtTime = 5000;
		tc01_DepositSlotTimed = new DepositSlotTimed(DespositSlotTestThread , customWtTime) ;
		
	}// end


	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@BeforeEach
	void setUp() throws Exception 
	{
		
	}// end


	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@Test
	@Order(1)
	@RepeatedTest(10)
	@DisplayName("TC01:Find the boundary (error margin) where around 5 of the tests fail" )
	void testTC01() throws Exception 
	{
		//fail("Not yet implemented");
		tc01_DepositSlotTimed.checkTimer();
		
	} // end

	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   
		
	@AfterEach
	void tearDown() throws Exception 
	{
		
	}// end

	   */ 
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		
	}// end
	
	

} // end
