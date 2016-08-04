
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.Employee;
import main.java.payrollcasestudy.entities.paymentmethods.PaymentMethod;

/**
 * Created by zhangshijie on 7/26/16.
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
