
package main.java.payrollcasestudy.entities.paymentschedule;

import java.util.Calendar;

/**
 * Created by zhangshijie on 7/25/16.
 */
public interface PaymentSchedule
{

	public boolean isPayDate( Calendar payDate );

	public Calendar getPayPeriodStartDate( Calendar payDate );
}
