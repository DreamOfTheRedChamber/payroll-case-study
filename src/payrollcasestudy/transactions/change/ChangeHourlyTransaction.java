
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.paymentclassifications.HourlyClassification;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentschedule.PaymentSchedule;
import payrollcasestudy.entities.paymentschedule.WeeklyPaymentSchedule;

/**
 * Created by zhangshijie on 7/26/16.
 */
public class ChangeHourlyTransaction extends ChangeClassificationTransaction
{

	private double hourlySalary;

	public ChangeHourlyTransaction( int employeeId, double hourlySalary )
	{
		super( employeeId );
		this.hourlySalary = hourlySalary;
	}

	@Override
	PaymentClassification getNewPaymentClassification( )
	{
		return new HourlyClassification( hourlySalary );
	}

	@Override
	PaymentSchedule getNewPaymentSchedule( )
	{
		return new WeeklyPaymentSchedule( );
	}
}
