
package main.java.payrollcasestudy.entities;

import java.util.Calendar;

/**
 * Created by zhangshijie on 7/25/16.
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
