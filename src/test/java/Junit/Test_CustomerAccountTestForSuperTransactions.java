package Junit;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import DriverStub.BankDatabaseNew;
import DriverStub.CustomerAccount;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

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


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Test_CustomerAccountTestForSuperTransactions
{
	////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES...
	
	// list of customer test accounts
	private static CustomerAccount ca00;
	// this is used by the constructor to instantiate the customer account
	private static  CustomerAccount ca01; 
	//private static  CustomerAccount ca02;
	//private static  CustomerAccount ca03;
	//private static  CustomerAccount ca04;
	//private static  CustomerAccount ca05;
	//private static  CustomerAccount ca06;
	//private static  CustomerAccount ca07;
	//private static  CustomerAccount ca08;
	//private static  CustomerAccount ca09; 
	
	// this is the array list for the Customer Accounts
	private static ArrayList<CustomerAccount> customers;
	
	// this is the bank database containing the array list of customer accounts
	private static BankDatabaseNew BanksDbnew_Testing;
	
	
   
	//THIS IS THE CLASS CONSTRUCTOR....
	// This is no class constructor.
	
	
	////////////////////////////////////////////////////////////////////////////////
	//Class Methods from here...
	////////////////////////////////////////////////////////////////////////////////

	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@BeforeAll
	@DisplayName("Setup: create test customer accounts and add to the Bank Database " )
	static void setUpBeforeClass() throws Exception 
	{
		// Declare the test variables
		//Initial test data
		ca00 = new CustomerAccount (03451, 1432, 0100.0, 0300.0, "little", 		"mike", 	0634);
		ca01 = new CustomerAccount (12345, 2321, 1000.0, 1200.0, "george", 		"erin", 	0624);
		//ca02 = new CustomerAccount (22345, 3321, 2000.0, 2200.0, "considine", 	"janet", 	0624);
		//ca03 = new CustomerAccount (32345, 4321, 3000.0, 3200.0, "ley", 		"andrew", 	0624);
		//ca04 = new CustomerAccount (42345, 5321, 4000.0, 4200.0, "russel", 		"peter", 	0624);
		//ca05 = new CustomerAccount (52345, 6321, 5000.0, 5200.0, "armstrong", 	"gerald", 	0624);
		//ca06 = new CustomerAccount (62345, 7321, 6000.0, 6200.0, "mcbride", 	"margaret", 0624);
		//ca07 = new CustomerAccount (72345, 8321, 7000.0, 7200.0, "francis", 	"kate", 	0624);
		//ca08 = new CustomerAccount (82345, 9321, 8000.0, 8200.0, "prowse", 		"tim", 		0624);
		//ca09 = new CustomerAccount (92345, 1021, 9000.0, 9200.0, "michaels", 	"thomas", 	0624);
		
		customers = new ArrayList<CustomerAccount>() ;
		
		customers.add(ca00);
		// this seeds the customer account with a customer account
		// in order to instantiate the Bank New Database.
		BanksDbnew_Testing = new BankDatabaseNew(customers);
		
		// This now adds the remaining customer accounts to the BankDatabaseNew(customers)
		BanksDbnew_Testing.add(ca01);
		//BanksDbnew_Testing.add(ca02);
		//BanksDbnew_Testing.add(ca03);
		//BanksDbnew_Testing.add(ca04);
		//BanksDbnew_Testing.add(ca05);
		//BanksDbnew_Testing.add(ca06);
		//BanksDbnew_Testing.add(ca07);
		//BanksDbnew_Testing.add(ca08);
		//BanksDbnew_Testing.add(ca09);

	} // end
	
	


	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   
		
	@BeforeEach
	void setUp() throws Exception 
	{
		
	}// end
	*/

	    
	   
	   
	//=========================================================================	
	/*  This test method tests.....
	 *   Verify that the user Account Number is 12345 
	 */	
	@Test
	@Order(1)
	@DisplayName("TC01. Verify that the user Account Number is 12345 " )
	void testTC01() throws Exception
	{
		//Account Number :12345
		assertEquals(12345, ca01.getAccountNumber()  );

	}// end

    
	   
	   
	//=========================================================================	
	/*  This test method tests.....
	 *   Verify that the available balance is $1000
	 	 */
	
	@Test
	@Order(2)
	@DisplayName("TC02: Verify that the available balance is $1000 " )
	void testTC02()  throws Exception
	{
		assertEquals(1000.00,BanksDbnew_Testing.export().get(1).getAvailableBalance(),0.00  );
		// this test assertsEquals( Double expectedValue, double actualValue, double delta)  
		
	}// end

   
	   
	   
	//=========================================================================	
	/*  This test method tests.....
	 *  Verifty that the total balance is $1200
	 *   
	 *   
		*/
		
	@Test
	@Order(3)
	@DisplayName("TC03: Verifty that the total balance is $1200 " )
	void testTC03()  throws Exception
	{
		//fail("Not yet implemented");
		assertEquals(1200.00,BanksDbnew_Testing.export().get(1).getTotalBalance(),0.00  );
	}// end	   

    
	    
	   
	//=========================================================================	
	/*  This method tests.....
	 *  Verify that crediting $500, expected available: $1000, total Balance: $1700 
	 */	
	 	
	@Test
	@Order(4)
	@DisplayName("TC04: Verify that crediting $500, expected available: $1000, total Balance: $1700" )
	void testTC04() throws Exception
	{
		boolean assertAvailBal1000 = false;
		boolean asserttotalBal1700 =false;
		double availBal = 0.00;
		double totalBal = 0.00;
		
		BanksDbnew_Testing.export().get(1).credit(500.00);
		availBal = BanksDbnew_Testing.export().get(1).getAvailableBalance();
		//System.out.println("AvailableBalance:"+ availBal);
		totalBal = BanksDbnew_Testing.export().get(1).getTotalBalance();
		//System.out.println("TotalBalance:" + totalBal);
		
		assertAvailBal1000 = (availBal == 1000.00); 
		asserttotalBal1700 = (totalBal == 1700.00); 
		
		assertTrue(assertAvailBal1000&&asserttotalBal1700);
		// if assertAvailBal1000 is true, and asserttotalBal1700 is true
		// the the test is also true, and passes.

	}// end	   
	   
	
	
	//=========================================================================	
	/*  This method tests.....
	 *  verify that when I indicated to get the total balance in the test 
	 *  account, the ATM machine shell display the total balance in the account 
	 */	
	 	
	@Test
	@Order(5)
	@DisplayName("TC05: Verify that debiting $600, expected available: $400, total Balance: $1100" )
	void testTC05() throws Exception
	{
		boolean assertAvailBal400 = false;
		boolean asserttotalBal1100 =false;
		double availBal = 0.00;
		double totalBal = 0.00;
		
		BanksDbnew_Testing.export().get(1).debit(600.00);
		
		availBal = BanksDbnew_Testing.export().get(1).getAvailableBalance();
		//System.out.println("AvailableBalance:"+ availBal);
		totalBal = BanksDbnew_Testing.export().get(1).getTotalBalance();
		//System.out.println("TotalBalance:" + totalBal);
		
		assertAvailBal400 = (availBal == 400.00); 
		asserttotalBal1100 = (totalBal == 1100.00); 
		
		assertTrue( assertAvailBal400 && asserttotalBal1100);
		// if assertAvailBal1000 is true, and asserttotalBal1700 is true
		// the the test is also true, and passes.

	}// end	 
	   

	//=========================================================================	
	/*  This method tests.....
	 *  verify that when I indicated to get the total balance in the test 
	 *  account, the ATM machine shell display the total balance in the account 
	 */	
	 	
	@Test
	@Order(6)
	@DisplayName("TC06: Verify that debiting $700, expected available: $-300, total Balance: $400" )
	void testTC06() throws Exception
	{
		boolean assertAvailBalNeg300 = false;
		boolean asserttotalBal400 =false;
		double availBal = 0.00;
		double totalBal = 0.00;
		
		BanksDbnew_Testing.export().get(1).debit(700.00);
		
		availBal = BanksDbnew_Testing.export().get(1).getAvailableBalance();
		System.out.println("AvailableBalance:"+ availBal);
		totalBal = BanksDbnew_Testing.export().get(1).getTotalBalance();
		System.out.println("TotalBalance:" + totalBal);
		
		assertAvailBalNeg300 = (availBal == -300.00); 
		asserttotalBal400 = (totalBal == 400.00); 
		
		assertTrue( assertAvailBalNeg300 && asserttotalBal400);
		// if assertAvailBal1000 is true, and asserttotalBal1700 is true
		// the the test is also true, and passes.

	}// end	 
	   

	//=========================================================================	
	/*  This method tests.....
	 *  verify that when I indicated to get the total balance in the test 
	 *  account, the ATM machine shell display the total balance in the account 
	 */	
	 	
	@Test
	@Order(7)
	@DisplayName("TC07: Verify that crediting $200, expected available balance:$-300, total Balance: $600" )
	void testTC07() throws Exception
	{
		boolean assertAvailBalNeg300 = false;
		boolean asserttotalBal600 =false;
		double availBal = 0.00;
		double totalBal = 0.00;
		
		BanksDbnew_Testing.export().get(1).credit(200.00);
		
		availBal = BanksDbnew_Testing.export().get(1).getAvailableBalance();
		//System.out.println("AvailableBalance:"+ availBal);
		totalBal = BanksDbnew_Testing.export().get(1).getTotalBalance();
		//System.out.println("TotalBalance:" + totalBal);
		
		assertAvailBalNeg300 = (availBal == -300.00); 
		asserttotalBal600 = (totalBal == 600.00); 
		
		assertTrue( assertAvailBalNeg300 && asserttotalBal600);
		// if assertAvailBal1000 is true, and asserttotalBal1700 is true
		// the the test is also true, and passes.

	}// end	 	
	   

	//=========================================================================	
	/*  This method tests.....
	 *  verify that when I indicated to get the total balance in the test 
	 *  account, the ATM machine shell display the total balance in the account 
	 */	
	 	
	@Test
	@Order(8)
	@DisplayName("TC08: Verify that debiting $100, expected available balance:$-400, total Balance: $500" )
	void testTC08() throws Exception
	{
		boolean assertAvailBalNeg400 = false;
		boolean asserttotalBal500 =false;
		double availBal = 0.00;
		double totalBal = 0.00;
		
		BanksDbnew_Testing.export().get(1).credit(200.00);
		
		availBal = BanksDbnew_Testing.export().get(1).getAvailableBalance();
		System.out.println("AvailableBalance:"+ availBal);
		totalBal = BanksDbnew_Testing.export().get(1).getTotalBalance();
		System.out.println("TotalBalance:" + totalBal);
		
		assertAvailBalNeg400 = (availBal == -300.00); 
		asserttotalBal500 = (totalBal == 600.00); 
		
		assertTrue( assertAvailBalNeg400 && asserttotalBal500);
		// if assertAvailBal1000 is true, and asserttotalBal1700 is true
		// the test is also true, and passes.

	}// end	 		
	
	
	//=========================================================================	
	/*  This method.....
	 *   
	 */	
	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		// not implemented.
		
	}// end
	
	
	

}// end
