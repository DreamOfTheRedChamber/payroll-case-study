
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
import payrollcasestudy.entities.paymentclassifications.CommissionedClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentschedule.MonthlyPaymentSchedule;
import payrollcasestudy.transactions.add.AddEmployeeTransaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;

/**
 * 
 */

public class ChangeCommissionedTransactionTest
{

	@Rule
	public DatabaseResource database = new DatabaseResource( );

	@Test
	public void changeCommissionedTransactionTest( )
	{
		int employeeId = 3;
		AddEmployeeTransaction addEmployeeTransaction = new AddHourlyEmployeeTransaction(
				employeeId, "Lance", "Home", new HoldMethod( ), 24.3 );
		addEmployeeTransaction.execute( );

		ChangeCommissionedTransaction changeCommissionedTransaction = new ChangeCommissionedTransaction(
				employeeId, 20.0, 200 );
		changeCommissionedTransaction.execute( );

		Employee employee = database.getInstance( ).getEmployee( employeeId );
		assertThat( employee.getPaymentClassification( ),
				is( instanceOf( CommissionedClassification.class ) ) );
		CommissionedClassification paymentClassification = (CommissionedClassification) employee
				.getPaymentClassification( );
		assertThat( paymentClassification.getMonthlySalary( ),
				is( closeTo( 200.0, FLOAT_ACCURACY ) ) );
		assertThat( paymentClassification.getCommissionRate( ),
				is( closeTo( 20.0, FLOAT_ACCURACY ) ) );

		assertThat( employee.getPaymentSchedule( ),
				is( instanceOf( MonthlyPaymentSchedule.class ) ) );
	}

}
