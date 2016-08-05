
package payrollcasestudy.transactions.add;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static payrollcasestudy.TestConstants.FLOAT_ACCURACY;

import org.junit.Rule;
import org.junit.Test;

import payrollcasestudy.DatabaseResource;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentclassifications.CommissionedClassification;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentschedule.BiWeeklyPaymentSchedule;
import payrollcasestudy.transactions.Transaction;

public class AddCommissionedEmployeeTransactionTest
{

	@Rule
	public DatabaseResource database = new DatabaseResource( );

	@Test
	public void testAddCommissionedEmployee( )
	{
		int employeeId = 1;
		Transaction addEmployeeTransaction = new AddCommissionedEmployeeTransaction(
				employeeId, "Michael", "Home", new HoldMethod( ), 200.0, 20.0 );
		addEmployeeTransaction.execute( );
		Employee employee = database.getInstance( ).getEmployee( employeeId );
		assertThat( employee.getName( ), is( "Michael" ) );

		PaymentClassification paymentClassification = employee
				.getPaymentClassification( );
		assertThat( paymentClassification,
				is( instanceOf( CommissionedClassification.class ) ) );
		CommissionedClassification commissionedClassification = (CommissionedClassification) paymentClassification;
		assertThat( commissionedClassification.getCommissionRate( ),
				is( closeTo( 20.0, FLOAT_ACCURACY ) ) );
		assertThat( commissionedClassification.getMonthlySalary( ),
				is( closeTo( 200.0, FLOAT_ACCURACY ) ) );

		assertThat( employee.getPaymentSchedule( ),
				is( instanceOf( BiWeeklyPaymentSchedule.class ) ) );
		assertThat( employee.getPaymentMethod( ),
				is( instanceOf( HoldMethod.class ) ) );
	}
}
