
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
import payrollcasestudy.entities.paymentclassifications.HourlyClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentschedule.WeeklyPaymentSchedule;
import payrollcasestudy.transactions.add.AddCommissionedEmployeeTransaction;
import payrollcasestudy.transactions.add.AddEmployeeTransaction;

/**
 * 
 */

public class ChangeHourlyTransactionTest
{

	@Rule
	public DatabaseResource databaseResource = new DatabaseResource( );

	@Test
	public void testChangeHourlyTransaction( )
	{
		int employeeId = 3;
		AddEmployeeTransaction addEmployeeTransaction = new AddCommissionedEmployeeTransaction(
				employeeId, "Lance", "Home", new HoldMethod( ), 2500, 3.2 );
		addEmployeeTransaction.execute( );

		ChangeHourlyTransaction changeHourlyTransaction = new ChangeHourlyTransaction(
				employeeId, 27.52 );
		changeHourlyTransaction.execute( );

		Employee employee = databaseResource.getInstance( )
				.getEmployee( employeeId );
		assertThat( employee.getPaymentClassification( ),
				is( instanceOf( HourlyClassification.class ) ) );
		HourlyClassification paymentClassification = (HourlyClassification) employee
				.getPaymentClassification( );
		assertThat( paymentClassification.getHourlyRate( ),
				is( closeTo( 27.52, FLOAT_ACCURACY ) ) );
		assertThat( employee.getPaymentSchedule( ),
				is( instanceOf( WeeklyPaymentSchedule.class ) ) );
	}

}
