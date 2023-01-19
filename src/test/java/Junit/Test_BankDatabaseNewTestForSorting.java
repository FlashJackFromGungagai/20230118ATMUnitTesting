/**
 * 
 */
package Junit;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;

import DriverStub.BankDatabaseNew;
import DriverStub.CustomerAccount;
import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.TestMethodOrder;

//import au.edu.rmit.ct.*;
//import com.dietel.*;


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
class Test_BankDatabaseNewTestForSorting
{
	////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES...
	
	// list of customer test accounts
	private static CustomerAccount ca00;
	// this is used by the constructor to instantiate the customer account
	private static  CustomerAccount ca01; 
	private static  CustomerAccount ca02;
	private static  CustomerAccount ca03;
	private static  CustomerAccount ca04;
	private static  CustomerAccount ca05;
	private static  CustomerAccount ca06;
	private static  CustomerAccount ca07;
	private static  CustomerAccount ca08;
	private static  CustomerAccount ca09; 
	
	// this is the array list for the Customer Accounts
	private static ArrayList<CustomerAccount> customers;
	
	// this is the array list for the sorted Customer Accounts
	private static ArrayList<CustomerAccount> customers_temp;
	
	// this is the bank database containing the array list of customer accounts
	private static BankDatabaseNew BanksDbnew_Testing;
	
	
   
	//THIS IS THE CLASS CONSTRUCTOR....
	// This is no class constructor.
	
	
	////////////////////////////////////////////////////////////////////////////////
	//Class Methods from here...
	////////////////////////////////////////////////////////////////////////////////

	   
	   
	   
	//=========================================================================	
	/*  This method.....
	 *   Setup: create test customer accounts and add to the Bank Database 
	 */	
	@BeforeAll
	@DisplayName("Setup: create test customer accounts and add to the Bank Database " )
	static void setUpBeforeClass() throws Exception 
	{
		// Declare the test variables
		//Initial test data
		ca00 = new CustomerAccount (03451, 1432, 0100.0, 0300.0, "little", 		"mike", 	634);
		ca01 = new CustomerAccount (12345, 2321, 1000.0, 1200.0, "george", 		"erin", 	627);
		ca02 = new CustomerAccount (22345, 3321, 2000.0, 2200.0, "considine", 	"janet", 	634);
		ca03 = new CustomerAccount (32345, 4321, 3000.0, 3200.0, "ley", 		"andrew", 	624);
		ca04 = new CustomerAccount (42345, 5321, 4000.0, 4200.0, "russel", 		"peter", 	636);
		ca05 = new CustomerAccount (52345, 6321, 5000.0, 5200.0, "armstrong", 	"gerald", 	724);
		ca06 = new CustomerAccount (62345, 7321, 6000.0, 6200.0, "mcbride", 	"margaret", 621);
		ca07 = new CustomerAccount (72345, 8321, 7000.0, 7200.0, "francis", 	"kate", 	625);
		ca08 = new CustomerAccount (82345, 9321, 8000.0, 8200.0, "prowse", 		"tim", 		632);
		ca09 = new CustomerAccount (92345, 1021, 9000.0, 9200.0, "michaels", 	"thomas", 	646);
		
		customers = new ArrayList<CustomerAccount>() ;
		
		customers.add(ca00);
		// this seeds the customer account with a customer account
		// in order to instantiate the Bank New Database.
		BanksDbnew_Testing = new BankDatabaseNew(customers);
		
		// This now adds the remaining customer accounts to the BankDatabaseNew(customers)
		BanksDbnew_Testing.add(ca01);
		BanksDbnew_Testing.add(ca02);
		BanksDbnew_Testing.add(ca03);
		BanksDbnew_Testing.add(ca04);
		BanksDbnew_Testing.add(ca05);
		BanksDbnew_Testing.add(ca06);
		BanksDbnew_Testing.add(ca07);
		BanksDbnew_Testing.add(ca08);
		BanksDbnew_Testing.add(ca09);
		
	}// end static void setUpBeforeClass()


	
	
	//=========================================================================	
	/*  This method tests.....
	 *   TC01:Verify Sort By BSB sorts Customer Accounts by BSB Ascending 
	 *  
	 */	
	 	
	@Test
	@Order(1)
	@DisplayName("TC01:Verify Sort By BSB sorts Customer Accounts by BSB Ascending " )
	void testTC01() throws Exception
	{

		// implementation from here
		BanksDbnew_Testing.sortByBSB();  
		customers_temp = (ArrayList<CustomerAccount>) BanksDbnew_Testing.export();
		//     assertEquals("A", result.get(0).name);
		assertEquals(621, customers_temp.get(0).getBSB() );
		assertEquals(624, customers_temp.get(1).getBSB() );
		assertEquals(625, customers_temp.get(2).getBSB() );
		assertEquals(627, customers_temp.get(3).getBSB() );
		assertEquals(632, customers_temp.get(4).getBSB() );
		assertEquals(634, customers_temp.get(5).getBSB() );
		assertEquals(634, customers_temp.get(6).getBSB() );
		assertEquals(636, customers_temp.get(7).getBSB() );
		assertEquals(646, customers_temp.get(8).getBSB() );
		assertEquals(724, customers_temp.get(9).getBSB() );
		
		
	}// end	 


	
	
	//=========================================================================	
	/*  This method tests.....
	 *   Verify Sort By Family Name sorts Customer Accounts by Customer Family Name
	 *  
	 */	
	 	
	@Test
	@Order(2)
	@DisplayName("TC02:Verify Sort By Family Name sorts Customer Accounts by Customer Family Name " )
	void testTC02() throws Exception
	{

		// implementation from here
		BanksDbnew_Testing.sortByName();  
		customers_temp = (ArrayList<CustomerAccount>) BanksDbnew_Testing.export();
		//     assertEquals("A", result.get(0).name);
		assertEquals("armstrong", 	customers_temp.get(0).getFamilyName() );
		assertEquals("considine", 	customers_temp.get(1).getFamilyName() );
		assertEquals("francis", 	customers_temp.get(2).getFamilyName() );
		assertEquals("george", 	customers_temp.get(3).getFamilyName() );
		assertEquals("ley", 		customers_temp.get(4).getFamilyName() );
		assertEquals("little", 	customers_temp.get(5).getFamilyName() );
		assertEquals("mcbride", 	customers_temp.get(6).getFamilyName() );
		assertEquals("michaels", 	customers_temp.get(7).getFamilyName() );
		assertEquals("prowse", 	customers_temp.get(8).getFamilyName() );
		assertEquals("russel", 	customers_temp.get(9).getFamilyName() );
		
		
	}// end



	
	
	//=========================================================================	
	/*  This method tests.....
	 *   Verify Sort By Total Amount sorts Customer Accounts by Customer Total Amount
	 *  
	 */	
	 	

	@Test
	@Order(3)
	@DisplayName("TC03:Verify Sort By Total Amount sorts Customer Accounts by Customer Total Amount " )
	void testTC03() throws Exception
	{

		// implementation from here
		BanksDbnew_Testing.sortByTotalBalance();  
		//BanksDbnew_Testing.export()
		
		//customers_temp = (ArrayList<CustomerAccount>) BanksDbnew_Testing.export();
		//     assertEquals("A", result.get(0).name);
		assertEquals(300.0, 	BanksDbnew_Testing.export().get(0).getTotalBalance(),0.00  );
		assertEquals(1200.0, 	BanksDbnew_Testing.export().get(1).getTotalBalance(),0.00  );
		assertEquals(2200.0, 	BanksDbnew_Testing.export().get(2).getTotalBalance(),0.00  );
		assertEquals(3200.0, 	BanksDbnew_Testing.export().get(3).getTotalBalance(),0.00  );
		assertEquals(4200.0, 	BanksDbnew_Testing.export().get(4).getTotalBalance(),0.00  );
		assertEquals(5200.0, 	BanksDbnew_Testing.export().get(5).getTotalBalance(),0.00  );
		assertEquals(6200.0, 	BanksDbnew_Testing.export().get(6).getTotalBalance(),0.00  );
		assertEquals(7200.0, 	BanksDbnew_Testing.export().get(7).getTotalBalance(),0.00  );
		assertEquals(8200.0, 	BanksDbnew_Testing.export().get(8).getTotalBalance(),0.00  );
		assertEquals(9200.0, 	BanksDbnew_Testing.export().get(9).getTotalBalance(),0.00  );
		
		
	}// end


	
	
	//=========================================================================	
	/*  This method tests.....
	 *   
	 *  
	 */	
	 	
	@Test
	@Order(4)
	@DisplayName("TC04: " )
	void testTC04() throws Exception
	{

		// if assertAvailBal1000 is true, and asserttotalBal1700 is true
		// the the test is also true, and passes.

	}// end	 	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		
	}// end 




}
