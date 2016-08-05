
package payrollcasestudy.transactions.change;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import payrollcasestudy.DatabaseResource;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;

/**
 * 
 */

public class ChangeNameTransactionTest
{

	@Rule
	public DatabaseResource databaseResource = new DatabaseResource( );

	@Test
	public void testChangeNameTransaction( )
	{
		int employeeId = 2;
		AddHourlyEmployeeTransaction addEmployeeTransaction = new AddHourlyEmployeeTransaction(
				employeeId, "Bill", "Home", new HoldMethod( ), 15.25 );
		addEmployeeTransaction.execute( );

		ChangeNameTransaction changeNameTransaction = new ChangeNameTransaction(
				employeeId, "Bob" );
		changeNameTransaction.execute( );

		Employee employee = databaseResource.getInstance( )
				.getEmployee( employeeId );
		assertThat( employee.getName( ), is( "Bob" ) );
	}
}
