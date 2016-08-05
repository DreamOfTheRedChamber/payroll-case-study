
package payrollcasestudy.transactions.change;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static payrollcasestudy.TestConstants.*;

import org.junit.Rule;
import org.junit.Test;

import payrollcasestudy.DatabaseResource;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentclassifications.SalariedClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentschedule.MonthlyPaymentSchedule;
import payrollcasestudy.transactions.add.AddCommissionedEmployeeTransaction;
import payrollcasestudy.transactions.add.AddEmployeeTransaction;

/**
 * 
 */

public class ChangeSalariedTransactionTest
{

	@Rule
	public DatabaseResource databaseResource = new DatabaseResource( );

	@Test
	public void testChangeHourlyTransaction( ) throws Exception
	{
		int employeeId = 3;
		AddEmployeeTransaction addEmployeeTransaction = new AddCommissionedEmployeeTransaction(
				employeeId, "Lance", "Home", new HoldMethod( ), 2500, 3.2 );
		addEmployeeTransaction.execute( );

		ChangeSalariedTransaction changeSalariedTransaction = new ChangeSalariedTransaction(
				employeeId, 3000.0 );
		changeSalariedTransaction.execute( );

		Employee employee = databaseResource.getInstance( )
				.getEmployee( employeeId );
		assertThat( employee.getPaymentClassification( ),
				is( instanceOf( SalariedClassification.class ) ) );
		SalariedClassification paymentClassification = (SalariedClassification) employee
				.getPaymentClassification( );
		assertThat( paymentClassification.getSalary( ),
				is( closeTo( 3000, FLOAT_ACCURACY ) ) );
		assertThat( employee.getPaymentSchedule( ),
				is( instanceOf( MonthlyPaymentSchedule.class ) ) );
	}

}
