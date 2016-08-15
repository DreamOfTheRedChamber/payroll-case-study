
package payrollcasestudy.transactions.add;

import java.util.Calendar;

import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.SalesReceipt;
import payrollcasestudy.entities.paymentclassifications.CommissionedClassification;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.transactions.Transaction;

/**
 * transaction which adds a sales receipt to a commissioned employee
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
