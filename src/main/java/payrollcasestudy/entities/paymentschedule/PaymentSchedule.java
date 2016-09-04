
package payrollcasestudy.entities.paymentschedule;

import java.util.Calendar;

/**
 * represents the schedule of employees being paid
 */
public interface PaymentSchedule
{

	/**
	 * judges whether employees should be paid on this <code>payDate</code> according to their payment schedule
	 * @param payDate
	 * @return whether this day is the payDate
	 */
	public boolean isPayDate( Calendar payDate );

	/**
	 * gets the first date of this payment round. PayPeriodStartDate = payDate - payPeriodLength
	 * @param payDate
	 * @return the first day in current pay period
	 */
	public Calendar getPayPeriodStartDate( Calendar payDate );
}