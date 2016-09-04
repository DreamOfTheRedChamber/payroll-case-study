
package payrollcasestudy.entities.paymentschedule;

import java.util.Calendar;

/**
 * represents schedule which is paid weekly
 */
public class WeeklyPaymentSchedule implements PaymentSchedule
{
	private final static int LENGTH_OF_WEEK = 5;
	
	@Override
	public boolean isPayDate( Calendar payDate )
	{
        return payDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
	}

	@Override
	public Calendar getPayPeriodStartDate( Calendar payDate )
	{
		Calendar monday = (Calendar) payDate.clone( );
		monday.roll( Calendar.DAY_OF_MONTH, -LENGTH_OF_WEEK );
		return monday;
	}
}
