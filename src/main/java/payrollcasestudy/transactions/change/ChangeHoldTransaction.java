
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.paymentmethods.HoldMethod;
import main.java.payrollcasestudy.entities.paymentmethods.PaymentMethod;

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
