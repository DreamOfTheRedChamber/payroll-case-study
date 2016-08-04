
package payrollcasestudy.entities.paymentmethods;

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
}
