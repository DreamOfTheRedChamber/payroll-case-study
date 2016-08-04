
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.paymentmethods.MailMethod;
import main.java.payrollcasestudy.entities.paymentmethods.PaymentMethod;

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
