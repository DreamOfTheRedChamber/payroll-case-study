
package payrollcasestudy.transactions.add;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import payrollcasestudy.DatabaseResource;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.affiliation.UnionAffiliation;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentclassifications.SalariedClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentschedule.MonthlyPaymentSchedule;
import payrollcasestudy.transactions.Transaction;

import static payrollcasestudy.TestConstants.*;

/**
 * 
 */

public class AddSalariedEmployeeTransactionTest
{

	@Rule
	public DatabaseResource databaseResource = new DatabaseResource( );

	@Test
	public void testAddSalariedEmployee( )
	{
		int employeeId = 1;
		Transaction addEmployeeTransaction = new AddSalariedEmployeeTransaction(
				employeeId, "Bob", "Home", 1000.0, new HoldMethod( ) );
		addEmployeeTransaction.execute( );

		Employee employee = databaseResource.getInstance( )
				.getEmployee( employeeId );
		assertThat( employee.getName( ), is( "Bob" ) );

		PaymentClassification paymentClassification = employee
				.getPaymentClassification( );
		assertThat( paymentClassification,
				is( instanceOf( SalariedClassification.class ) ) );
		SalariedClassification salariedClassification = (SalariedClassification) paymentClassification;
		assertThat( salariedClassification.getSalary( ),
				closeTo( 1000.0, FLOAT_ACCURACY ) );

		assertThat( employee.getPaymentSchedule( ),
				is( instanceOf( MonthlyPaymentSchedule.class ) ) );
		assertThat( employee.getPaymentMethod( ),
				is( instanceOf( HoldMethod.class ) ) );
		assertThat( employee.getUnionAffiliation( ),
				is( UnionAffiliation.NO_AFFILIATION ) );
	}
}
