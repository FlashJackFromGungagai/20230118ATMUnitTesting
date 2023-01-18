package au.edu.rmit.ct;


//import static org.junit.Assert.assertTrue; // this is no longer needed.
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
//import java.util.List;

//import org.junit.Assert; // this is no longer needed.
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


//  this is an un-used import statement
import au.edu.rmit.ct.*;

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE BankDatabaseNewTestConstructors class.
* 
* what this class will do:
* 1. This criterion is linked to a learning outcome1 - Test the Constructors
* 2. Provide at least three differently purposed Junit test cases to test 
*    a.	The public BankDatabaseNew() Constructor in the BankDatabaseNew class 
*    
*    b. The BankDatabaseNew(ArrayList<CustomerAccount> seedCustomers) throws Exception 
*         Constructors in the BankDatabaseNew class 
*    		 
*    b. the add(CustomerAccount ca) method in the BankDatabaseNew class
*    
* 
*            
*/ 

class BankDatabaseNewTestForConstructors_S9905648
{
	

	  	//THIS IS THE CLASS CONSTRUCTOR....	
		// no declared test class variables for this 
	
	
	
	   
	   
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////

	   
	   
	   
	//=========================================================================	
	/*  This method set up the test environment to execute tests 
	 *   on the BankDatabaseNew class, basic constructor
	 *    public BankDatabaseNew()   
	 *   
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		
	}// end setUpBeforeClass() throws Exception 
 */	

////////////////////////////////////////////////////////////////////////////////
// Test the  BankDatabaseNew() default constructor
	   
	   
	//=========================================================================	
	/*  This method sets up the BankDatabaseNew() default constructor
	 *   
	
	@BeforeEach
	//  void setUp()

	public void BankDatabaseNewDefaultConstructor_SetUp() throws Exception 
	{
		//List<CustomerAccount> customers = new ArrayList<>();
		//customers = new ArrayList<CustomerAccount>(seedCustomers);
		//BankDatabaseNew tc01 = new BankDatabaseNew();
		
	}// end etUp() throws Exception 

 */	
	   
	   
	   
	//=========================================================================	
	/*  This method validates the methods operate correctly
	 *   after BankDatabaseNew() default constructor default constructor operates
	 *   
	 *   The test case it is: verify that creating an instance of the default 
	 *   constructor, Will create and be an instanceof 
	 *   BankDatabaseNew” and that instance shall be empty.
	 *   
	 *   
	 */	
	@Test
	@Order(1)
	@DisplayName("1. Verify that the default constructor operates correctly by creating an empty class instance of"
			         + "the BankDatabaseNew class? If test passes, has")
	public void BankDatabaseNewDefaultConstructor_test() throws Exception
	{
		//fail("Not yet implemented");
	
		BankDatabaseNew tc01 = new BankDatabaseNew();
		//assertEquals("au.edu.rmit.ct.BankDatabaseNew",tc01.getClass() );
		//assertEquals(true,tc01.isEmpty() );
		boolean assertInstanceCreatedtest = false;
		boolean assertInstanceIsEmptytest =false;
		
		
		assertInstanceCreatedtest =  tc01 instanceof BankDatabaseNew;
		assertInstanceIsEmptytest = tc01.isEmpty();
		

		assertTrue(assertInstanceCreatedtest ==  assertInstanceIsEmptytest  );
		
		
		
		
		
		
	}// end test()
	

	   
	   
	   
	//=========================================================================	
	/*  This method clears up after executing the test case
	 *  the BankDatabaseNew() default constructor
	 *   
	 
	@AfterEach
	void BankDatabaseNewDefaultConstructor_tearDown() throws Exception 
	{
		
	}// end tearDown() throws Exception
	
	*/	

////////////////////////////////////////////////////////////////////////////////
//Test the BankDatabaseNew(ArrayList<CustomerAccount> seedCustomers) 
//  Constructor 




	//=========================================================================	
	/*  This method.....
	 *   
		
	@BeforeEach
	void BankDatabaseNewDetailedConstructor_setUp() throws Exception 
	{
		
	}// end etUp() throws Exception 
	
	 */


	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 * 		Test case: 	Verify that you can create an instance of the 
	 *  				BankDatabaseNew(ArrayList<CustomerAccount> seedCustomers) 
	 *  				constructor	and that it will have
	 *  				1. It is an instanceof the BankDatabaseNew class
	 *  				2. It has a size of 1
	 *  						
	 *   
	*/
	@Test
	@Order(2)
	@DisplayName("2. Verify you can create an instance of the BankDatabaseNew(ArrayList<CustomerAccount> seedCustomers) " )
	void BankDatabaseNewDetailedConstructor_test() throws Exception 
	{
		
		int instantiatedClassSize =1;
		CustomerAccount sdCustomers = new CustomerAccount (12345, 4321, 1000.0, 1200.0, "little", "mike", 0634);
		ArrayList<CustomerAccount> cstomers = new ArrayList<CustomerAccount>() ;
		
		//BankDatabaseNew(  sdCustomers) ;
		cstomers.add(sdCustomers);
		BankDatabaseNew tc02 = new BankDatabaseNew(cstomers);
		
		boolean assertInstanceCreatedtest = false;
		boolean assertInstanceSizeIs1test = false;
		
		
		assertInstanceCreatedtest =  tc02 instanceof BankDatabaseNew;
		assertInstanceSizeIs1test = (tc02.size()==instantiatedClassSize);
		assertTrue(assertInstanceCreatedtest ==  assertInstanceSizeIs1test  );
		
		
		//fail("Not yet implemented");
		
	}// end test()
	
	 
	

	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   
	 *   
	 	
	 	
	@AfterEach
	void BankDatabaseNewDetailedConstructor_tearDown() throws Exception 
	{
		
	}// end tearDown() throws Exception
	
	*/
	
	
////////////////////////////////////////////////////////////////////////////////
//Test the test Add method in the BankDatabaseNew class




	//=========================================================================	
	/*  This method.....
	 *   
		
	@BeforeEach
	void testAdd_setUp() throws Exception 
	{
		//CustomerAccount aCustomer = new CustomerAccount (12345, 54321, 1000.0, 1200.0, "little", "mike", 0634);
		//CustomerAccount sdCustomers = new CustomerAccount (12334, 4322, 1010.0, 1230.0, "George", "Erin", 0634);
	}// end etUp() throws Exception 

	 */
	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *  Verify that adding a Customer Account will increase the size of the
	 *  instance to two.
	 *   
	 */	
	 	
	@Test
	@Order(3)
	@DisplayName("3. Verify you can create an instance of the BankDatabaseNew(ArrayList<CustomerAccount> seedCustomers) " )
	void testAdd_test() throws Exception 
	{
		//CustomerAccount aCustomer 	= new CustomerAccount (23451, 5432, 1010.0, 1300.0, "little", "mike", 0634);
		CustomerAccount ca = new CustomerAccount (12345, 4321, 1000.0, 1200.0, "george", "erin", 0624);
		
		//int instantiatedClassSize =2;
		CustomerAccount sdCustomers = new CustomerAccount (23451, 5432, 1010.0, 1300.0, "little", "mike", 0634);
		
		ArrayList<CustomerAccount> cstomers = new ArrayList<CustomerAccount>() ;
		
		//BankDatabaseNew(  sdCustomers) ;
		cstomers.add(sdCustomers);
		BankDatabaseNew tc03 = new BankDatabaseNew(cstomers);
		
		tc03.add(ca);
		assertEquals(2,tc03.size() );
		
		//fail("Not yet implemented");
		
	}// end test()
	
	 
	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   
		
	@AfterEach
	void testAdd_tearDown() throws Exception 
	{
		
	}// end tearDown() throws Exception	   
	
	 */
	
	
	
////////////////////////////////////////////////////////////////////////////////
//tearDownAfterClass() close down the test class.




	   
	//=========================================================================	
	/*  This method.....
	 *   
	 	
	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		
	}// end tearDownAfterClass() throws Exception

	   */
	   
	   

	
	
	

}// end BankDatabaseNewTestConstructors
