
package main.java.payrollcasestudy.transactions.add;

import main.java.payrollcasestudy.entities.paymentclassifications.HourlyClassification;
import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.entities.paymentmethods.PaymentMethod;
import main.java.payrollcasestudy.entities.paymentschedule.PaymentSchedule;
import main.java.payrollcasestudy.entities.paymentschedule.WeeklyPaymentSchedule;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction
{

	private double hourlyRate;

	public AddHourlyEmployeeTransaction( int employeeId, String employeeName,
			String employeeAddress, PaymentMethod paymentMethod,
			double hourlyRate )
	{
		super( employeeId, employeeName, employeeAddress, paymentMethod );
		this.hourlyRate = hourlyRate;
	}

	@Override
	protected PaymentSchedule getPaymentSchedule( )
	{
		return new WeeklyPaymentSchedule( );
	}

	@Override
	protected PaymentClassification getPaymentClassification( )
	{
		return new HourlyClassification( hourlyRate );
	}
}
