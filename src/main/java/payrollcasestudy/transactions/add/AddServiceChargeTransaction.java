
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

    public AddServiceChargeTransaction(int memberId, Calendar date, double amount) {
        Employee unionMember = database.getUnionMember(memberId);
        UnionAffiliation unionAffiliation = unionMember.getUnionAffiliation();
        unionAffiliation.addServiceCharge(date, amount);
    }

    @Override
    public void execute() 
    {
    }
}
