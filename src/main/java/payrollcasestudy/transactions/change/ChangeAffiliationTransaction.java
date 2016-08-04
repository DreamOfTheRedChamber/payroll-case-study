
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.Employee;
import main.java.payrollcasestudy.entities.affiliation.UnionAffiliation;

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
