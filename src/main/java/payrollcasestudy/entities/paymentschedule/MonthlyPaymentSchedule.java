
package main.java.payrollcasestudy.entities.paymentschedule;

import java.util.Calendar;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class MonthlyPaymentSchedule implements PaymentSchedule
{

	@Override
	public boolean isPayDate( Calendar payDate )
	{
		return true;
	}

	@Override
	public Calendar getPayPeriodStartDate( Calendar payDate )
	{
		Calendar firstOfMonth = (Calendar) payDate.clone( );
		firstOfMonth.set( Calendar.DAY_OF_MONTH, 1 );
		return firstOfMonth;
	}
}
