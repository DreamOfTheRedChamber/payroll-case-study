
package payrollcasestudy.transactions.delete;

import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.transactions.Transaction;

/**
 * transaction which delete an employee from the database
 */
public class DeleteEmployeeTransaction implements Transaction
{

	private int employeeId;

	public DeleteEmployeeTransaction( int employeeId )
	{
		this.employeeId = employeeId;
	}

	@Override
	public void execute( )
	{
		PayrollDatabase database = PayrollDatabase.globalPayrollDatabase;
		database.deleteEmployee( employeeId );
	}
}
