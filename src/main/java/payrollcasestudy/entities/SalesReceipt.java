
package payrollcasestudy.entities;

import java.util.Calendar;

/**
 * Represents sales receipts for commissioned employees who are paid according to their sales
 */
public class SalesReceipt
{

	private Calendar date;
	private double amount;

	public SalesReceipt( Calendar date, double amount )
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
