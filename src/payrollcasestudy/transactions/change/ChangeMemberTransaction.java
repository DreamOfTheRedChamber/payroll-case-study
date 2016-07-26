package payrollcasestudy.transactions.change;

import payrollcasestudy.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.affiliation.UnionAffiliation;

/**
 * Created by zhangshijie on 7/26/16.
 */
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    private int memberId;
    private double dues;

    public ChangeMemberTransaction(int employeeId, int memberId, double dues) {
        super(employeeId);
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    protected UnionAffiliation getAffiliation() {
        return new UnionAffiliation( memberId, dues );
    }

    @Override
    protected void recordMembership(Employee employee) {
        PayrollDatabase.globalPayrollDatabase.addUnionMember( memberId, employee );
    }
}
