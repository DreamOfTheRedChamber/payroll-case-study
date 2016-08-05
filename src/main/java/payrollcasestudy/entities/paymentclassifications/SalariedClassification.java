
package payrollcasestudy.entities.paymentclassifications;

import payrollcasestudy.entities.PayCheck;

/**
 * Created by zhangshijie on 7/22/16.
 */
public class SalariedClassification extends PaymentClassification
{

	private double salary;

	public SalariedClassification( double salary )
	{
		this.salary = salary;
	}

	@Override
	public double calculatePay( PayCheck payCheck )
	{
		return salary;
	}

}
