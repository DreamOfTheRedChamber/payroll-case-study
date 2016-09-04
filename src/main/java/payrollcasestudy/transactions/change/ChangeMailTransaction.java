
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.paymentmethods.MailMethod;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;

/**
 * transaction which changes employees' payment method to mailing paychecks to their addresses
 */
public class ChangeMailTransaction extends ChangeMethodTransaction
{

	private String address;

	public ChangeMailTransaction( int employeeId, String address )
	{
		super( employeeId );
		this.address = address;
	}

	@Override
	PaymentMethod getNewPaymentMethod( )
	{
		return new MailMethod( address );
	}
}
