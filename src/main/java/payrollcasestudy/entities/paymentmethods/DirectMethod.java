
package payrollcasestudy.entities.paymentmethods;

import payrollcasestudy.entities.PayCheck;

/**
 * represents the payment method directly deposited into the bank account of choice
 */
public class DirectMethod implements PaymentMethod
{

	private String bankName;
	private String accountNumber;

	public DirectMethod( String bankName, String accountNumber )
	{
		this.bankName = bankName;
		this.accountNumber = accountNumber;
	}

	@Override
	public void pay( PayCheck payCheck )
	{
		payCheck.setField( "bankName", bankName );
		payCheck.setField( "accountNumber", accountNumber );
		payCheck.setField( "Disposition", "Direct" );
	}
}
