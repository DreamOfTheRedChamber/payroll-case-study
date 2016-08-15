
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.affiliation.UnionAffiliation;

/**
 * transaction which removes an employee from an affiliation
 */
public class ChangeNoMemberTransaction extends ChangeAffiliationTransaction
{

	public ChangeNoMemberTransaction( int employeeId )
	{
		super( employeeId );
	}

	@Override
	protected UnionAffiliation getAffiliation( )
	{
		return UnionAffiliation.NO_AFFILIATION;
	}

	@Override
	protected void recordMembership( Employee employee )
	{
		int memberId = employee.getUnionAffiliation( ).getMemberId( );
		database.deleteUnionMember( memberId );
	}
}
