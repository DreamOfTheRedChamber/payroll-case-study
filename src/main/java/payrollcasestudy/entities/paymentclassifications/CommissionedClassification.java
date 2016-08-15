
package payrollcasestudy.entities.paymentclassifications;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import payrollcasestudy.entities.PayCheck;
import payrollcasestudy.entities.SalesReceipt;

/**
 * represents payment classification which is paid on a combination of monthly salary and commission rate
 */
public class CommissionedClassification extends PaymentClassification
{

	private double commissionRate;
	private double monthlySalary;
	private Map<Calendar, SalesReceipt> salesReceiptMap = new HashMap<>( );

	public double getMonthlySalary( )
	{
		return monthlySalary;
	}

	public double getCommissionRate( )
	{
		return commissionRate;
	}

	public CommissionedClassification(  double salary, double commissionRate )
	{
		this.commissionRate = commissionRate;
		this.monthlySalary = salary;
	}

	public SalesReceipt getSalesReceipt( Calendar date )
	{
		return salesReceiptMap.get( date );
	}
	
	public void addSalesReceipt( SalesReceipt salesReceipt )
	{
		salesReceiptMap.put( salesReceipt.getDate( ), salesReceipt );
	}

	@Override
	public double calculatePay( PayCheck payCheck )
	{
		double totalPay = monthlySalary;
		for ( SalesReceipt receipt : salesReceiptMap.values( ) )
		{
			if ( isInPayPeriod( receipt.getDate( ), payCheck ) )
			{
				totalPay += receipt.getAmount( ) * commissionRate;
			}
		}
		return totalPay;
	}

}