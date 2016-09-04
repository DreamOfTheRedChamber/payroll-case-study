
package payrollcasestudy.entities.paymentmethods;

import payrollcasestudy.entities.PayCheck;

/**
 * represents the payment method which is directly mailed to postal address
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
