
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.entities.paymentclassifications.SalariedClassification;
import main.java.payrollcasestudy.entities.paymentschedule.MonthlyPaymentSchedule;
import main.java.payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * Created by zhangshijie on 7/26/16.
 */
public class ChangeSalariedTransaction extends ChangeClassificationTransaction
{

	private double newSalary;

	public ChangeSalariedTransaction( int employeeId, double newSalary )
	{
		super( employeeId );
		this.newSalary = newSalary;
	}

	@Override
	PaymentClassification getNewPaymentClassification( )
	{
		return new SalariedClassification( newSalary );
	}

	@Override
	PaymentSchedule getNewPaymentSchedule( )
	{
		return new MonthlyPaymentSchedule( );
	}
}
