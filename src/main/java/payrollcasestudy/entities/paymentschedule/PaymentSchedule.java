
package payrollcasestudy.entities.paymentschedule;

import java.util.Calendar;

/**
 * Created by zhangshijie on 7/25/16.
 */
public interface PaymentSchedule
{

	/**
	 * the paydate for different payment schedule is already hardcoded/predefined
	 * @param payDate
	 * @return whether this day is the payDate
	 */
	public boolean isPayDate( Calendar payDate );

	/**
	 * employees with different payment schedule will have different pay period length. PayPeriodStartDate = payDate - payPeriodLength
	 * @param payDate
	 * @return the first day in current pay period
	 */
	public Calendar getPayPeriodStartDate( Calendar payDate );
}