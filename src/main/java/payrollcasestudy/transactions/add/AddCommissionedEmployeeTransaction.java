
package main.java.payrollcasestudy.transactions.add;

import main.java.payrollcasestudy.entities.paymentclassifications.CommissionedClassification;
import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.entities.paymentmethods.PaymentMethod;
import main.java.payrollcasestudy.entities.paymentschedule.BiWeeklyPaymentSchedule;
import main.java.payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction
{

	private double monthlySalary;
	private double commissionRate;

	public AddCommissionedEmployeeTransaction( int employeeId,
			String employeeName, String employeeAddress,
			PaymentMethod paymentMethod, double monthlySalary,
			double commissionRate )
	{
		super( employeeId, employeeName, employeeAddress, paymentMethod );
		this.monthlySalary = monthlySalary;
		this.commissionRate = commissionRate;
	}

	@Override
	protected PaymentSchedule getPaymentSchedule( )
	{
		return new BiWeeklyPaymentSchedule( );
	}

	@Override
	protected PaymentClassification getPaymentClassification( )
	{
		return new CommissionedClassification( monthlySalary, commissionRate );
	}
}
