
package payrollcasestudy.transactions.add;

import java.util.Calendar;

import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.affiliation.UnionAffiliation;
import payrollcasestudy.transactions.Transaction;

/**
 * transaction which adds a service charge deduction to employees from enrolled union affiliations
 */
public class AddServiceChargeTransaction implements Transaction
{

	PayrollDatabase database = PayrollDatabase.globalPayrollDatabase;

	private Calendar date;
	private double amount;
	private int memberId;

	public AddServiceChargeTransaction( int memberId, Calendar date,
			double amount )
	{
		this.date = date;
		this.amount = amount;
		this.memberId = memberId;
	}

	@Override
	public void execute( )
	{
		Employee unionMember = database.getUnionMember( memberId );
		UnionAffiliation unionAffiliation = unionMember.getUnionAffiliation( );
		unionAffiliation.addServiceCharge( date, amount );
	}
}
