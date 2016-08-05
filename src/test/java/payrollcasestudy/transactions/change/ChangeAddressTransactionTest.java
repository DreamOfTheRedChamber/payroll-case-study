
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

public class ChangeAddressTransactionTest
{

	@Rule
	public DatabaseResource databaseResource = new DatabaseResource( );

	@Test
	public void testChangeAddressTransaction( )
	{
		int employeeId = 2;
		AddHourlyEmployeeTransaction addEmployeeTransaction = new AddHourlyEmployeeTransaction(
				employeeId, "Bill", "Home", new HoldMethod( ), 15.25 );
		addEmployeeTransaction.execute( );

		ChangeAddressTransaction changeAddressTransaction = new ChangeAddressTransaction(
				employeeId, "Mars" );
		changeAddressTransaction.execute( );

		Employee employee = databaseResource.getInstance( )
				.getEmployee( employeeId );
		assertThat( employee.getAddress( ), is( "Mars" ) );

	}
}
