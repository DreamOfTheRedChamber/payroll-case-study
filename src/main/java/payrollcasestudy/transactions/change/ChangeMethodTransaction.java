
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;

/**
 * transaction which changes the payment method of an employee
 */
public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction
{

	public ChangeMethodTransaction( int employeeId )
	{
		super( employeeId );
	}

	@Override
	public void changeEmployee( Employee employee )
	{
		PaymentMethod paymentMethod = getNewPaymentMethod( );
		employee.setPaymentMethod( paymentMethod );
	}

	abstract PaymentMethod getNewPaymentMethod( );
}
