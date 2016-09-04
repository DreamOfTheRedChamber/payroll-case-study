
package payrollcasestudy.transactions.add;

import payrollcasestudy.entities.paymentclassifications.CommissionedClassification;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;
import payrollcasestudy.entities.paymentschedule.BiWeeklyPaymentSchedule;
import payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * transaction that adds a commissioned employee to database
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
