
package payrollcasestudy.entities.paymentschedule;

import java.util.Calendar;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class BiWeeklyPaymentSchedule implements PaymentSchedule
{

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
		payPeriodStartDate.add( Calendar.DAY_OF_MONTH, -13 );
		return payPeriodStartDate;
	}

}
