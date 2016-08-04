
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.Employee;
import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * Created by zhangshijie on 7/26/16.
 */
public abstract class ChangeClassificationTransaction
		extends
			ChangeEmployeeTransaction
{

	public ChangeClassificationTransaction( int employeeId )
	{
		super( employeeId );
	}

	@Override
	public void changeEmployee( Employee employee )
	{
		PaymentClassification classification = getNewPaymentClassification( );
		employee.setPaymentClassification( classification );
		PaymentSchedule schedule = getNewPaymentSchedule( );
		employee.setPaymentSchedule( schedule );
	}

	abstract PaymentClassification getNewPaymentClassification( );

	abstract PaymentSchedule getNewPaymentSchedule( );
}
