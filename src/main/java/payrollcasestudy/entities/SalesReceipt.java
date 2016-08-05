
package payrollcasestudy.entities;

import java.util.Calendar;

/**
 * Created by zhangshijie on 7/25/16.
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
