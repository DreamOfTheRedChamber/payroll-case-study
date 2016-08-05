
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
import payrollcasestudy.entities.paymentclassifications.HourlyClassification;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentschedule.WeeklyPaymentSchedule;
import payrollcasestudy.transactions.Transaction;

public class AddHourlyEmployeeTransactionTest
{

	@Rule
	public DatabaseResource database = new DatabaseResource( );

	@Test
	public void testAddHourlyEmployee( )
	{
		int employeeId = 1;
		Transaction addEmployeeTransaction = new AddHourlyEmployeeTransaction(
				employeeId, "Steve", "Home", new HoldMethod( ), 20.0 );
		addEmployeeTransaction.execute( );
		Employee employee = database.getInstance( ).getEmployee( employeeId );
		assertThat( employee.getName( ), is( "Steve" ) );

		PaymentClassification paymentClassification = employee
				.getPaymentClassification( );
		assertThat( paymentClassification,
				is( instanceOf( HourlyClassification.class ) ) );
		HourlyClassification hourlyClassification = (HourlyClassification) paymentClassification;
		assertThat( hourlyClassification.getHourlyRate( ),
				is( closeTo( 20.0, FLOAT_ACCURACY ) ) );

		assertThat( employee.getPaymentSchedule( ),
				is( instanceOf( WeeklyPaymentSchedule.class ) ) );
		assertThat( employee.getPaymentMethod( ),
				is( instanceOf( HoldMethod.class ) ) );
	}

}
