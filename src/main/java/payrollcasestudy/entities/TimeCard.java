
package payrollcasestudy.entities;

import java.util.Calendar;

/**
 * Represents time cards for hourly employees who are paid by the amount of working hour
 */
public class TimeCard
{

	private Calendar date;
	private double hours;

	public TimeCard( Calendar date, double hours )
	{
		this.date = date;
		this.hours = hours;
	}

	public Calendar getDate( )
	{
		return date;
	}

	public double getHours( )
	{
		return hours;
	}
}
