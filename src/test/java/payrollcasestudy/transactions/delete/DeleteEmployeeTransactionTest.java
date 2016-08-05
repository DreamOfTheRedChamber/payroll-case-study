
package payrollcasestudy.transactions.delete;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import payrollcasestudy.DatabaseResource;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.transactions.add.AddCommissionedEmployeeTransaction;

/**
 * 
 */

public class DeleteEmployeeTransactionTest
{

	@Rule
	public DatabaseResource database = new DatabaseResource( );

	@Test
	public void testDeleteEmployees( )
	{
		int employeeId = 3;
		AddCommissionedEmployeeTransaction addEmployeeTransaction = new AddCommissionedEmployeeTransaction(
				employeeId, "Lance", "Home", new HoldMethod( ), 2500.0, 3.2 );
		addEmployeeTransaction.execute( );

		Employee employee = database.getInstance( ).getEmployee( employeeId );
		assertThat( employee, is( notNullValue( ) ) );

		DeleteEmployeeTransaction deleteTransaction = new DeleteEmployeeTransaction(
				employeeId );
		deleteTransaction.execute( );

		employee = database.getInstance( ).getEmployee( employeeId );
		assertThat( employee, is( nullValue( ) ) );
	}
}
