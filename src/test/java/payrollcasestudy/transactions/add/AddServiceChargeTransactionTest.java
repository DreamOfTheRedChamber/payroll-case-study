
package payrollcasestudy.transactions.add;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static payrollcasestudy.TestConstants.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Rule;
import org.junit.Test;

import payrollcasestudy.DatabaseResource;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.ServiceCharge;
import payrollcasestudy.entities.affiliation.UnionAffiliation;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.transactions.Transaction;

/**
 * 
 */

public class AddServiceChargeTransactionTest
{

	@Rule
	public DatabaseResource database = new DatabaseResource( );

	@Test
	public void testAddServiceCharge( )
	{
		int employeeId = 2;
		Transaction addEmployeeTransaction = new AddHourlyEmployeeTransaction(
				employeeId, "Bill", "Home", new HoldMethod( ), 15.25 );
		addEmployeeTransaction.execute( );

		Employee employee = database.getInstance( ).getEmployee( employeeId );
		assertThat( employee, is( notNullValue( ) ) );

		int memberId = 86;
		UnionAffiliation unionAffiliation = new UnionAffiliation( memberId,
				12.5 );
		employee.setUnionAffiliation( unionAffiliation );
		database.getInstance( ).addUnionMember( memberId, employee );
		assertThat( database.getInstance( ).getUnionMember( memberId ),
				is( notNullValue( ) ) );

		Calendar date = new GregorianCalendar( 2001, 11, 01 );
		AddServiceChargeTransaction addServiceChargeTransaction = new AddServiceChargeTransaction(
				memberId, date, 12.95 );
		addServiceChargeTransaction.execute( );
		ServiceCharge serviceCharge = unionAffiliation.getServiceCharge( date );
		assertThat( serviceCharge, is( notNullValue( ) ) );
		assertThat( serviceCharge.getAmount( ),
				is( closeTo( 12.95, FLOAT_ACCURACY ) ) );

	}
}
