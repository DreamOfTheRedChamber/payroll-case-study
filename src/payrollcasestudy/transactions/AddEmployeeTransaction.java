package payrollcasestudy.transactions;

import payrollcasestudy.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;
import payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * Created by zhangshijie on 7/25/16.
 */
public abstract class AddEmployeeTransaction implements Transaction {
    private int employeeId;
    private String employeeName;
    private String employeeAddress;

    @Override
    public void execute()
    {
        PaymentClassification paymentClassification = getPaymentClassification();
        PaymentSchedule paymentSchedule = getPaymentSchedule();
        PaymentMethod paymentMethod = getPaymentMethod();

        Employee employee = new Employee( employeeId, employeeName, employeeAddress );
        employee.setPaymentClassification( paymentClassification );
        employee.setPaymentMethod( paymentMethod );
        employee.setPaymentSchedule( paymentSchedule );

        PayrollDatabase.globalPayrollDatabase.addEmployee( employeeId, employee );
    }

    protected abstract PaymentSchedule getPaymentSchedule();
    protected abstract PaymentClassification getPaymentClassification();
    protected abstract PaymentMethod getPaymentMethod();
}
