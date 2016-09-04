
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * transaction which changes employees' payment classification ( payment schedule accordingly ) 
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
