
package payrollcasestudy.transactions.add;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Rule;
import org.junit.Test;

import payrollcasestudy.DatabaseResource;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.TimeCard;
import payrollcasestudy.entities.paymentclassifications.HourlyClassification;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.transactions.Transaction;

public class AddTimeCardTransactionTest
{

	@Rule
	public DatabaseResource database = new DatabaseResource( );

	@Test
	public void testTimeCardTransaction( )
	{
		int employeeId = 2;
		AddHourlyEmployeeTransaction addHourlyEmployee = new AddHourlyEmployeeTransaction(
				employeeId, "Billy", "Home", new HoldMethod( ), 15.25 );
		addHourlyEmployee.execute( );

		Calendar date = new GregorianCalendar( 2001, 10, 31 );
		Transaction timeCardTransaction = new AddTimeCardTransaction( date,
				8.0,
				employeeId );
		timeCardTransaction.execute( );

		Employee employee = database.getInstance( ).getEmployee( employeeId );
		assertThat( employee, is( notNullValue( ) ) );

		PaymentClassification paymentClassification = employee
				.getPaymentClassification( );
		HourlyClassification hourlyPaymentClassification = (HourlyClassification) paymentClassification;
		assertThat( hourlyPaymentClassification, is( notNullValue( ) ) );

		TimeCard timeCard = hourlyPaymentClassification.getTimeCard( date );
		assertNotNull( timeCard );
		assertThat( timeCard.getHours( ), is( 8.0 ) );

	}
}
