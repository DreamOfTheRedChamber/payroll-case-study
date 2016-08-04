
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.paymentclassifications.CommissionedClassification;
import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.entities.paymentschedule.MonthlyPaymentSchedule;
import main.java.payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * Created by zhangshijie on 7/26/16.
 */
public class ChangeCommissionedTransaction
		extends
			ChangeClassificationTransaction
{

	private double commissionRate;
	private int monthlySalary;

	public ChangeCommissionedTransaction( int employeeId, double commissionRate,
			int monthlySalary )
	{
		super( employeeId );
		this.commissionRate = commissionRate;
		this.monthlySalary = monthlySalary;
	}

	@Override
	PaymentClassification getNewPaymentClassification( )
	{
		return new CommissionedClassification( monthlySalary, commissionRate );
	}

	@Override
	PaymentSchedule getNewPaymentSchedule( )
	{
		return new MonthlyPaymentSchedule( );
	}
}
