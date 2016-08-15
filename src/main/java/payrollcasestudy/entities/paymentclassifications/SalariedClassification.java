
package payrollcasestudy.entities.paymentclassifications;

import payrollcasestudy.entities.PayCheck;

/**
 * represent payment classification which is based on a flat salary
 */
public class SalariedClassification extends PaymentClassification
{

	private double salary;

	public SalariedClassification( double salary )
	{
		this.salary = salary;
	}

	public double getSalary()
	{
		return salary;
	}
	
	@Override
	public double calculatePay( PayCheck payCheck )
	{
		return salary;
	}
	
}
