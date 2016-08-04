
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;

/**
 * Created by zhangshijie on 7/26/16.
 */
public class ChangeHoldTransaction extends ChangeMethodTransaction
{

	public ChangeHoldTransaction( int employeeId )
	{
		super( employeeId );
	}

	@Override
	PaymentMethod getNewPaymentMethod( )
	{
		return new HoldMethod( );
	}
}
