
package payrollcasestudy.transactions.add;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static payrollcasestudy.TestConstants.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Rule;
import org.junit.Test;

import payrollcasestudy.DatabaseResource;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.SalesReceipt;
import payrollcasestudy.entities.paymentclassifications.CommissionedClassification;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.transactions.Transaction;

/**
 * 
 */

public class AddSalesReceiptTransactionTest
{

	@Rule
	public DatabaseResource database = new DatabaseResource( );

	@Test
	public void testAddSalesReceipt( )
	{
		int employeeId = 2;
		AddCommissionedEmployeeTransaction addCommissionedEmployee = new AddCommissionedEmployeeTransaction(
				employeeId, "Bill", "Home", new HoldMethod( ), 15.25, 0.5 );
		addCommissionedEmployee.execute( );

		Calendar date = new GregorianCalendar( 2001, 11, 31 );
		Transaction salesReceiptTransaction = new AddSalesReceiptTransaction(
				date, 1000, employeeId );
		salesReceiptTransaction.execute( );

		Employee employee = database.getInstance( ).getEmployee( employeeId );
		assertThat( employee, is( notNullValue( ) ) );
		PaymentClassification paymentClassification = employee
				.getPaymentClassification( );
		CommissionedClassification commissionedClassification = (CommissionedClassification) paymentClassification;

		SalesReceipt receipt = commissionedClassification
				.getSalesReceipt( date );
		assertThat( receipt, is( notNullValue( ) ) );
		assertThat( receipt.getAmount( ),
				is( closeTo( 1000.0, FLOAT_ACCURACY ) ) );
	}
}
