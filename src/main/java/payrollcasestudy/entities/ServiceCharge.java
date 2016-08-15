
package payrollcasestudy.entities;

import java.util.Calendar;

/**
 * Represents service charges for employees who are enrolled in specific affiliations
 */
public class ServiceCharge
{

	private Calendar date;
	private double amount;

	public ServiceCharge( Calendar date, double amount )
	{
		this.date = date;
		this.amount = amount;
	}

	public Calendar getDate( )
	{
		return date;
	}

	public double getAmount( )
	{
		return amount;
	}
}
