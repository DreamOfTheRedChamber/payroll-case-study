
package payrollcasestudy.transactions.add;

import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentclassifications.SalariedClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentschedule.MonthlyPaymentSchedule;
import payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * transaction that adds a salaried employee to database
 */
public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction
{

	private double salary;

	public AddSalariedEmployeeTransaction( int employeeId, String name,
			String address, double salary, HoldMethod holdMethod )
	{
		super( employeeId, name, address, holdMethod );
		this.salary = salary;
	}

	@Override
	protected PaymentSchedule getPaymentSchedule( )
	{
		return new MonthlyPaymentSchedule( );
	}

	@Override
	protected PaymentClassification getPaymentClassification( )
	{
		return new SalariedClassification( salary );
	}

}
