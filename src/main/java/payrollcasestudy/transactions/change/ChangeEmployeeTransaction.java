
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.boundaries.PayrollDatabase;
import main.java.payrollcasestudy.entities.Employee;
import main.java.payrollcasestudy.transactions.Transaction;

/**
 * Created by zhangshijie on 7/26/16.
 */
public abstract class ChangeEmployeeTransaction implements Transaction
{

	PayrollDatabase database = PayrollDatabase.globalPayrollDatabase;
	private int employeeId;

	public ChangeEmployeeTransaction( int employeeId )
	{
		this.employeeId = employeeId;
	}

	@Override
	public void execute( )
	{
		Employee employee = database.getEmployee( employeeId );
		changeEmployee( employee );
	}

	public abstract void changeEmployee( Employee employee );

}
