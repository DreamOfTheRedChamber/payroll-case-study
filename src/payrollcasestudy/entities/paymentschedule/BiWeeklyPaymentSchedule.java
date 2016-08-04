
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
		return true;
	}

	@Override
	public Calendar getPayPeriodStartDate( Calendar payDate )
	{
		Calendar payPeriodStartDate = (Calendar) payDate.clone( );
		payPeriodStartDate.add( Calendar.DAY_OF_MONTH, -13 );
		return payPeriodStartDate;
	}

}
