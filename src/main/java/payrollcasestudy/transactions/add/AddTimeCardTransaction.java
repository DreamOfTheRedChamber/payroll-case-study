
package payrollcasestudy.transactions.add;

import java.util.Calendar;

import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.TimeCard;
import payrollcasestudy.entities.paymentclassifications.HourlyClassification;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.transactions.Transaction;

/**
 * transaction which adds a time card to an hourly paid employee
 */
public class AddTimeCardTransaction implements Transaction
{

	private Calendar date;
	private double hours;
	private int employeeId;

	public AddTimeCardTransaction( Calendar date, double hours, int employeeId )
	{
		this.date = date;
		this.hours = hours;
		this.employeeId = employeeId;
	}

	@Override
	public void execute( )
	{
		Employee employee = PayrollDatabase.globalPayrollDatabase
				.getEmployee( employeeId );
		if ( employee != null )
		{
			PaymentClassification paymentClassification = employee
					.getPaymentClassification( );
			if ( paymentClassification instanceof HourlyClassification )
			{
				HourlyClassification classification = (HourlyClassification) paymentClassification;
				classification.addTimeCard( new TimeCard( date, hours ) );
			}
		}
	}
}
