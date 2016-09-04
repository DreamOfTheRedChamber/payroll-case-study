
package payrollcasestudy.transactions.add;

import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;
import payrollcasestudy.entities.paymentschedule.PaymentSchedule;
import payrollcasestudy.transactions.Transaction;

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

	/**
	 * create employee, set its composite attributes and save to database
	 */
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
