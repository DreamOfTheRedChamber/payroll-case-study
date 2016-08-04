
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.affiliation.UnionAffiliation;

/**
 * Created by zhangshijie on 7/26/16.
 */
public abstract class ChangeAffiliationTransaction
		extends
			ChangeEmployeeTransaction
{

	public ChangeAffiliationTransaction( int employeeId )
	{
		super( employeeId );
	}

	@Override
	public void changeEmployee( Employee employee )
	{
		recordMembership( employee );
	}

	protected abstract UnionAffiliation getAffiliation( );

	protected abstract void recordMembership( Employee employee );
}
