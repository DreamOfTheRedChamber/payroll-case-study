
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;

/**
 * transaction which changes an employee's payment method to paychecks being held by payment master
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
