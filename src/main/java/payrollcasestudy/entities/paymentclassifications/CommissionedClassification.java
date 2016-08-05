
package payrollcasestudy.entities.paymentclassifications;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import payrollcasestudy.entities.PayCheck;
import payrollcasestudy.entities.SalesReceipt;

/**
 * employees paid based on sales receipts which record the date and amount of
 * the sale
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

	public CommissionedClassification( double commissionRate, double salary )
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