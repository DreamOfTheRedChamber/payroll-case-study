
package payrollcasestudy.entities;

import java.util.Calendar;

import payrollcasestudy.entities.affiliation.UnionAffiliation;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;
import payrollcasestudy.entities.paymentschedule.PaymentSchedule;

/**
 * Represents employees who are payees of this payroll system
 */
public class Employee
{

	private int employeeId;
	private String name;
	private String address;
	private PaymentClassification paymentClassification;
	private PaymentMethod paymentMethod;
	private PaymentSchedule paymentSchedule;
	private UnionAffiliation unionAffiliation = UnionAffiliation.NO_AFFILIATION;

	public UnionAffiliation getUnionAffiliation( )
	{
		return unionAffiliation;
	}

	public void setUnionAffiliation( UnionAffiliation unionAffiliation )
	{
		this.unionAffiliation = unionAffiliation;
	}

	public PaymentClassification getPaymentClassification( )
	{
		return paymentClassification;
	}

	public void setPaymentClassification(
			PaymentClassification paymentClassification )
	{
		this.paymentClassification = paymentClassification;
	}

	public PaymentSchedule getPaymentSchedule( )
	{

		return paymentSchedule;
	}

	public void setPaymentSchedule( PaymentSchedule paymentSchedule )
	{
		this.paymentSchedule = paymentSchedule;
	}

	public PaymentMethod getPaymentMethod( )
	{
		return paymentMethod;
	}

	public void setPaymentMethod( PaymentMethod paymentMethod )
	{
		this.paymentMethod = paymentMethod;
	}

	public String getAddress( )
	{
		return address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	public String getName( )
	{

		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public Employee( int employeeId, String name, String address )
	{
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}

	public boolean isPayDate( Calendar payDate )
	{
		return paymentSchedule.isPayDate( payDate );
	}

	public Calendar getPayPeriodStartDay( Calendar payDate )
	{
		return paymentSchedule.getPayPeriodStartDate( payDate );
	}

	/**
	 * 
	 * @param payCheck
	 */
	public void payDay( PayCheck payCheck )
	{
		double grossPay = paymentClassification.calculatePay( payCheck );
		double deductions = unionAffiliation.calculateDeduction( payCheck );
		double netPay = grossPay - deductions;
		payCheck.setGrossPay( grossPay );
		payCheck.setDeductions( deductions );
		payCheck.setNetPay( netPay );
		
		paymentMethod.pay( payCheck );
	}
}
