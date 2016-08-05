
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.paymentmethods.MailMethod;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;

/**
 * Created by zhangshijie on 7/26/16.
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
