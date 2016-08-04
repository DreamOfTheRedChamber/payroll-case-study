
package main.java.payrollcasestudy.transactions.add;

import java.util.Calendar;

import main.java.payrollcasestudy.boundaries.PayrollDatabase;
import main.java.payrollcasestudy.entities.Employee;
import main.java.payrollcasestudy.entities.affiliation.UnionAffiliation;
import main.java.payrollcasestudy.transactions.Transaction;

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
