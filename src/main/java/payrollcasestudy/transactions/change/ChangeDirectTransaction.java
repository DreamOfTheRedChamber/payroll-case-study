
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.paymentmethods.DirectMethod;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;

/**
 * transaction which changes employees' payment method to paychecks being directly deposit to bank account
 */
public class ChangeDirectTransaction extends ChangeMethodTransaction
{

	private String bankName;
	private String accountNumber;

	public ChangeDirectTransaction( int employeeId, String bankName,
			String accountNumber )
	{
		super( employeeId );
		this.bankName = bankName;
		this.accountNumber = accountNumber;
	}

	@Override
	PaymentMethod getNewPaymentMethod( )
	{
		return new DirectMethod( bankName, accountNumber );
	}
}
