package payrollcasestudy.transactions.delete;

import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.transactions.Transaction;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class DeleteEmployeeTransaction implements Transaction {

   private int employeeId;

    public DeleteEmployeeTransaction(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        PayrollDatabase database = PayrollDatabase.globalPayrollDatabase;
        database.deleteEmployee( employeeId );
    }
}
