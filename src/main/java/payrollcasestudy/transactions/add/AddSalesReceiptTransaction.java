
package main.java.payrollcasestudy.transactions.add;

import java.util.Calendar;

import main.java.payrollcasestudy.boundaries.PayrollDatabase;
import main.java.payrollcasestudy.entities.Employee;
import main.java.payrollcasestudy.entities.SalesReceipt;
import main.java.payrollcasestudy.entities.paymentclassifications.CommissionedClassification;
import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.transactions.Transaction;

/**
 * Created by zhangshijie on 7/26/16.
 */
public class AddSalesReceiptTransaction implements Transaction
{

	private Calendar date;
	private double amount;
	private int employeeId;

	public AddSalesReceiptTransaction( Calendar date, double amount,
			int employeeId )
	{
		this.date = date;
		this.amount = amount;
		this.employeeId = employeeId;
	}

	@Override
	public void execute( )
	{
		Employee employee = PayrollDatabase.globalPayrollDatabase
				.getEmployee( employeeId );
		if ( employee != null )
		{
			PaymentClassification paymentClassification = employee
					.getPaymentClassification( );
			if ( paymentClassification instanceof CommissionedClassification )
			{
				CommissionedClassification commissionedClassification = (CommissionedClassification) paymentClassification;
				commissionedClassification
						.addSalesReceipt( new SalesReceipt( date, amount ) );
			}
		}
	}
}
