
package main.java.payrollcasestudy.transactions.add;

import java.util.Calendar;

import main.java.payrollcasestudy.boundaries.PayrollDatabase;
import main.java.payrollcasestudy.entities.Employee;
import main.java.payrollcasestudy.entities.TimeCard;
import main.java.payrollcasestudy.entities.paymentclassifications.HourlyClassification;
import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.transactions.Transaction;

/**
 * Created by zhangshijie on 7/25/16.
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
