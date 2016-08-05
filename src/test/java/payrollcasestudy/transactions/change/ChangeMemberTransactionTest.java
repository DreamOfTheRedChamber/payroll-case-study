
package payrollcasestudy.transactions.change;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import payrollcasestudy.DatabaseResource;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.affiliation.UnionAffiliation;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.transactions.add.AddEmployeeTransaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;

import static payrollcasestudy.TestConstants.*;

/**
 * 
 */

public class ChangeMemberTransactionTest
{

	@Rule
	public DatabaseResource databaseResource = new DatabaseResource( );

	@Test
	public void testChangeMemberTransaction( )
	{
		int employeeId = 2;
		int memberId = 7734;
		AddEmployeeTransaction addEmployeeTransaction = new AddHourlyEmployeeTransaction(
				employeeId, "Bill", "Home", new HoldMethod( ), 15.25 );
		addEmployeeTransaction.execute( );

		ChangeMemberTransaction changeMemberTransaction = new ChangeMemberTransaction(
				employeeId, memberId, 99.42 );
		changeMemberTransaction.execute( );

		Employee employee = databaseResource.getInstance( )
				.getEmployee( employeeId );
		assertThat( employee.getUnionAffiliation( ), is( notNullValue( ) ) );

		UnionAffiliation unionAffiliation = employee.getUnionAffiliation( );
		assertThat( unionAffiliation.getDues( ),
				is( closeTo( 99.42, FLOAT_ACCURACY ) ) );

		Employee member = databaseResource.getInstance( )
				.getUnionMember( memberId );
		assertThat( member, is( employee ) );
	}
}
