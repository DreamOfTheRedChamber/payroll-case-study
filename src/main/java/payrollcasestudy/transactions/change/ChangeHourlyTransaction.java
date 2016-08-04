
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.paymentclassifications.HourlyClassification;
import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.entities.paymentschedule.PaymentSchedule;
import main.java.payrollcasestudy.entities.paymentschedule.WeeklyPaymentSchedule;

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
