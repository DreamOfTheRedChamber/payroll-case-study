
package payrollcasestudy.transactions.add;

import java.util.Calendar;

import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.affiliation.UnionAffiliation;
import payrollcasestudy.transactions.Transaction;

/**
 * Created by zhangshijie on 7/26/16.
 */
public class AddServiceChargeTransaction implements Transaction
{

	PayrollDatabase database = PayrollDatabase.globalPayrollDatabase;

	private Calendar date;
	private double amount;
	private int employeeId;

	public AddServiceChargeTransaction( Calendar date, double amount,
			int employeeId )
	{
		this.date = date;
		this.amount = amount;
		this.employeeId = employeeId;
	}

	@Override
	public void execute( )
	{
		Employee employee = database.getEmployee( employeeId );
		if ( employee != null )
		{
			UnionAffiliation affiliation = employee.getUnionAffiliation( );
			if ( affiliation != UnionAffiliation.NO_AFFILIATION )
			{
				affiliation.addServiceCharge( date, amount );
			}
		}
	}
}
