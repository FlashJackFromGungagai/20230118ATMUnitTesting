package DriverStub;

import AppUnderTest.Account;
// this imports the classes for  ATM, BalanceInquiry, BankDatabase, CashDispenser, Deposit etc

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	:mlittle@hadarach-consulting.mygbiz.com, 	Mob: +61 476 136 482
* 
* 
* -------------------------------------------------------------------------
*            THIS IS THE CustomerAccount extends Account class.
* 
* What this class will do:
* 1. This class extends the parent class, Account.
*            
*/ 


public class CustomerAccount extends Account
{
////////////////////////////////////////////////////////////////////////////////
	
	// DECLARE CLASS VARIABLES
	private String FamilyName;
	private String GivenName;
	private final int BSB;

////////////////////////////////////////////////////////////////////////////////
// CLASS CONSTRUCTOR from here...
////////////////////////////////////////////////////////////////////////////////


	public CustomerAccount(	int theAccountNumber,
							int thePIN, 
							double theAvailableBalance, 
							double theTotalBalance,
							String familyName, 
							String givenName, 
							int bsb) throws Exception 
	{
	
		super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
		
		if (thePIN < 1000) 
		{
			throw new Exception("Pin number too short, must be > 999 ");
		} else if (thePIN > 9999) 
		{
			throw new Exception("Pin number too big, must be <=9999");			
		}// end
		
		this.setFamilyName(familyName);
		this.setGivenName(givenName);
		this.BSB = bsb;
	}// end public CustomerAccount constructor

	
	
////////////////////////////////////////////////////////////////////////////////
//Class Methods from here...
////////////////////////////////////////////////////////////////////////////////

	
	
	
	//=========================================================================	
	/*  This method.....
	 * 
	 */	
	public int getBSB() 
	{
		return BSB;
	}// end public int getBSB() 

	
	
	
	//=========================================================================	
	/*  This method.....
	 * 
	 */
	public String getFamilyName() 
	{
		return FamilyName;
	}// end public String getFamilyName()

	
	
	
	//=========================================================================	
	/*  This method.....
	 * 
	 */
	public void setFamilyName(String familyName) 
	{
		this.FamilyName = familyName;
	}// end public void setFamilyName(String familyName) 

	
	
	
	//=========================================================================	
	/*  This method.....
	 * 
	 */
	public String getGivenName() 
	{
		return GivenName;
	}// end public String getGivenName() 

	
	
	
	//=========================================================================	
	/*  This method.....
	 * 
	 */
	public void setGivenName(String givenName) 
	{
		this.GivenName = givenName;
	}// end public void setGivenName(String givenName) 

}// end public class CustomerAccount extends Account 
