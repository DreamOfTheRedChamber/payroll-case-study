
package payrollcasestudy.entities.paymentmethods;

/**
 * payments could be directly deposited into the bank account of choice
 */
public class DirectMethod implements PaymentMethod
{

	private String bankName;
	private String accountNumber;

	public DirectMethod( String bankName, String accountNumber )
	{
		this.bankName = bankName;
		this.accountNumber = accountNumber;
	}
}
