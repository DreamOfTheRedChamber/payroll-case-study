
package payrollcasestudy.entities.paymentclassifications;

import java.util.Calendar;

import payrollcasestudy.entities.PayCheck;

/**
 * Created by zhangshijie on 7/22/16.
 */
public abstract class PaymentClassification
{
	/**
	 * 
	 * @param payCheck
	 * @return amount should be paid in this pay period
	 */
	public abstract double calculatePay( PayCheck payCheck );

	/**
	 * judge whether records (timecards, salesreceipt, and union affiliation service charges) should be taken into considered in this pay roll
	 * @param date
	 * @param payCheck
	 * @return
	 */
	public static boolean isInPayPeriod( Calendar date, PayCheck payCheck )
	{
		Calendar payPeriodStart = payCheck.getPayPeriodStart( );
		Calendar payPeriodEnd = payCheck.getPayPeriodEnd( );
		return date.equals( payPeriodEnd )
				|| date.equals( payPeriodStart )
				|| ( date.after( payPeriodStart )
						&& date.before( payPeriodEnd ) );
	}
}
