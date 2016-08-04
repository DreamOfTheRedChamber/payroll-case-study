
package main.java.payrollcasestudy.transactions.change;

import main.java.payrollcasestudy.entities.Employee;

/**
 * Created by zhangshijie on 7/26/16.
 */
public class ChangeAddressTransaction extends ChangeEmployeeTransaction
{

	private String newAddress;

	public ChangeAddressTransaction( int employeeId, String newAddress )
	{
		super( employeeId );
		this.newAddress = newAddress;
	}

	@Override
	public void changeEmployee( Employee employee )
	{
		employee.setAddress( this.newAddress );
	}
}
