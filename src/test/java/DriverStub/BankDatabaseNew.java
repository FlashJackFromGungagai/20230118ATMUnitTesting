package DriverStub;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import AppUnderTest.BankDatabase;
// this imports the classes for account, ATM, BalanceInquiry, BankDatabase, CashDispenser, Deposit etc

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE BankDatabaseNew class.
* 
* What this class will do:
* 	1. This extends the parent class BankDatabase [inheritance].
* 	2. It has methods for:
* 		> adding a customer account
* 		> Checking if an account is empty.
* 		> Returning the number of customer account objects
* 		> Sorting Customer Accounts by Total Balance, BSB, Name, etc
* 		> Authenticating an account [this overrides the parent class].
* 		> Export the array list of of customer accounts
*            
*/ 

public class BankDatabaseNew extends BankDatabase
{
////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES
	private  List<CustomerAccount> customers = new ArrayList<>();
	// "customers" is an array list.

	////////////////////////////////////////////////////////////////////////////////
	//Class constructors from here...
	////////////////////////////////////////////////////////////////////////////////

	public BankDatabaseNew() 
	// CLASS CONSTRUCTOR
	{
		// default, contains no implementation.
 
	}// close class constructor.
	
	
	public BankDatabaseNew(ArrayList<CustomerAccount> seedCustomers) throws Exception 
	//	'seedCustomers' is of type arrayList<CustomerAccount>
	//	 This is public as it is a class constructor that takes in the variable "seedCustomers"
	//		This constructor instantiates the new database with a seed customer so it in not null.
	{
		if(seedCustomers.isEmpty())
			throw new Exception ("Trying to seed database with empty source");
		customers = new ArrayList<>(seedCustomers);
		// this was previously customers = new ArrayList<CustomerAccount>(seedCustomers);
		// changed by Mike Little 2023-01-11--1654.
	}// // close class constructor.
	
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////
	
	
	//=========================================================================	
	/*  This method.....clears an empty database.
	 * 2023-01-11==1654MJL: this method was commented out as it is not being use
	 * at present.
	 *

	void clear() throws Exception 
	{
		if(this.isEmpty())
			throw new Exception("Trying to clear an empty database");
		customers.clear();
		
	}// close void clear() throws Exception 
	
	*/
	//=========================================================================	
	/*  This method.....
	 * 		Adds a customer account object to the bank Database
	 */
	public void add(CustomerAccount aCustomer) throws Exception
	{
		CustomerAccount ca = getAccount(aCustomer.getAccountNumber());
		if( ca == null) 
		{
			customers.add(aCustomer);			
		}
		else 
		{
			throw new Exception ("Customer number already exists");
		}

	}// close oid add(CustomerAccount aCustomer) throws Exception 
	
	
	//=========================================================================	
	/*  This method.....
	 * 		Tests whether the customer object isEmpty, that is null.
	 * 			It returns a TRUE if the customer object is empty.
	 */
	public boolean isEmpty()
	{
		return customers.isEmpty();
	}// close boolean isEmpty()
	
	//=========================================================================	
	/*  This method.....
	 * 		Returns the number of customer account objects
	 */
	public int size()
	{

		return customers.size();

	}// close int size() 

	
	//=========================================================================	
	/*  This method.....
	 * 		Sorts by the total balances of the customer accounts.
	 */
	public void sortByTotalBalance()
	{
		// Sort by Total balance, then by Family name.
		Comparator<CustomerAccount> sortByNameComparator = Comparator.comparing(CustomerAccount::getTotalBalance);
		customers.sort(sortByNameComparator);		
	}// close void sortByTotalBalance() 
	
	
	//=========================================================================	
	/*  This method.....
	 * 		Sorts by the BSB of the customer accounts.
	 */
	public void sortByBSB()
	{
		// Sort by BSB and then Family Name
		Comparator<CustomerAccount> sortByNameComparator = Comparator.comparing(CustomerAccount::getBSB)
		      .thenComparing(CustomerAccount::getFamilyName);
		customers.sort(sortByNameComparator);	
		
	}// close void sortByBSB() 
	
	
	//=========================================================================	
	/*  This method.....
	 * 	Sorts by the Family name of the customer accounts.
	 */
	public void sortByName()
	{
		// next set the comparator
		Comparator<CustomerAccount> sortByNameComparator = Comparator.comparing(CustomerAccount::getFamilyName)
		      .thenComparing(CustomerAccount::getGivenName);
		customers.sort(sortByNameComparator);
		
	}// close void sortByName() 
	

	//=========================================================================	
	/*  This method.....
	 * 		overrides public boolean authenticateUser( int userAccountNumber, int userPIN )
	 * 			in BankDatabase... keep the signature, but remove the implementation?
	 * 				>> keep this for now, and later test what happens if you remove
	 * 					the implementation... it is the same code for method.
	 *
	 * 		Determine whether user-specified account number and PIN match
	 *      those of an account in the database.
	 *      Returns a Boolean value.
	 *
	 *
	 */
	public boolean authenticateUser(int userAccountNumber, int userPIN) 
	{
		// attempt to retrieve the account with the account number
		CustomerAccount userAccount = getAccount(userAccountNumber);

		// if account exists, return result of Account method validatePIN
		if (userAccount != null)
			return userAccount.validatePIN(userPIN);
		else
			return false; // account number not found, so return false
		
	} // end method authenticateUser

	
	//=========================================================================	
	/*  This method.....
	 * 		returns the CurrentAccount
	 * 		it is private, as it called by a public method in the class
	 * 			and so it's scope should be restricted.
	 */
	private CustomerAccount getAccount(int accountNumber) 
	{
		// loop through accounts searching for matching account number
		for (CustomerAccount currentAccount : customers) 
		{
			// return current account if match found
			if (currentAccount.getAccountNumber() == accountNumber)
				return currentAccount;
		} // end for

		return null; // if no matching account was found, return null
		
	}// close private CustomerAccount getAccount(int accountNumber) 
	
	
	//=========================================================================	
	/*  This method.....
	 * 		it is used to return the arraylist of customer accounts
	 * 		it is used for this test...
	 * 			assertEquals(300.0, BanksDbnew_Testing.export().get(0).getTotalBalance(),0.00  );
	 */
 	public List<CustomerAccount> export()
 	{
		return  new ArrayList<>( customers); // returns a copy only of customer data.
	} // List<CustomerAccount> export() 
 
}// close public class BankDatabaseNew extends BankDatabase
