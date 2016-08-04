
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.paymentmethods.DirectMethod;
import main.java.payrollcasestudy.entities.paymentmethods.PaymentMethod;

/**
 * Created by zhangshijie on 7/26/16.
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
