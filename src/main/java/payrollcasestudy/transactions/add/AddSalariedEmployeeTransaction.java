
package main.java.payrollcasestudy.transactions.add;

import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.entities.paymentclassifications.SalariedClassification;
import main.java.payrollcasestudy.entities.paymentmethods.HoldMethod;
import main.java.payrollcasestudy.entities.paymentschedule.MonthlyPaymentSchedule;
import main.java.payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * Created by zhangshijie on 7/25/16.
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
