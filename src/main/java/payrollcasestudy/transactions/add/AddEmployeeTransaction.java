
package main.java.payrollcasestudy.transactions.add;

import main.java.payrollcasestudy.boundaries.PayrollDatabase;
import main.java.payrollcasestudy.entities.Employee;
import main.java.payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import main.java.payrollcasestudy.entities.paymentmethods.PaymentMethod;
import main.java.payrollcasestudy.entities.paymentschedule.PaymentSchedule;
import main.java.payrollcasestudy.transactions.Transaction;

/**
 * Created by zhangshijie on 7/25/16.
 */
public abstract class AddEmployeeTransaction implements Transaction
{

	private int employeeId;
	private String employeeName;
	private String employeeAddress;
	private PaymentMethod paymentMethod;

	public AddEmployeeTransaction( int employeeId, String employeeName,
			String employeeAddress, PaymentMethod paymentMethod )
	{
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.paymentMethod = paymentMethod;
	}

	@Override
	public void execute( )
	{
		Employee employee = new Employee( employeeId,
				employeeName,
				employeeAddress );
		employee.setPaymentMethod( paymentMethod );

		PaymentClassification paymentClassification = getPaymentClassification( );
		employee.setPaymentClassification( paymentClassification );
		PaymentSchedule paymentSchedule = getPaymentSchedule( );
		employee.setPaymentSchedule( paymentSchedule );

		PayrollDatabase.globalPayrollDatabase.addEmployee( employeeId,
				employee );
	}

	protected abstract PaymentSchedule getPaymentSchedule( );

	protected abstract PaymentClassification getPaymentClassification( );
}
