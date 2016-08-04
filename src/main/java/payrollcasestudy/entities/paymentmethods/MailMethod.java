
package main.java.payrollcasestudy.entities.paymentmethods;

import main.java.payrollcasestudy.entities.PayCheck;

/**
 * paycheck directly mailed to postal address
 */
public class MailMethod implements PaymentMethod
{

	private String postalAddress;

	public MailMethod( String postalAddress )
	{
		this.postalAddress = postalAddress;
	}

	@Override
	public void pay( PayCheck payCheck )
	{
		payCheck.setField( "postalAddress", postalAddress );
		payCheck.setField( "Disposition", "Mail" );
	}
}
