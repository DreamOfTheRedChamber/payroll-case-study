
package payrollcasestudy.entities.paymentschedule;

import java.util.Calendar;

/**
 * represents schedule which is paid biweekly
 */
public class BiWeeklyPaymentSchedule implements PaymentSchedule
{
	private final static int LENGTH_OF_BIWEEK = 13;

	@Override
	public boolean isPayDate( Calendar payDate )
	{
        boolean evenCalendarWeek = payDate.get(Calendar.WEEK_OF_YEAR) % 2 == 0;
        return payDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && evenCalendarWeek;
	}

	@Override
	public Calendar getPayPeriodStartDate( Calendar payDate )
	{
		Calendar payPeriodStartDate = (Calendar) payDate.clone( );
		payPeriodStartDate.add( Calendar.DAY_OF_MONTH, -LENGTH_OF_BIWEEK );
		return payPeriodStartDate;
	}

}
