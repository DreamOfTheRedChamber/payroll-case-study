
package payrollcasestudy.boundaries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import payrollcasestudy.entities.Employee;

/**
 * database which stores employee/member ids to employees mapping
 */
public class PayrollDatabase
{

	public static PayrollDatabase globalPayrollDatabase = new PayrollDatabase( );
	private Map<Integer, Employee> employeeMap = new HashMap<>( );
	private Map<Integer, Employee> unionMembers = new HashMap<>( );

	public void addEmployee( int employeeId, Employee employee )
	{
		employeeMap.put( employeeId, employee );
	}

	public void deleteEmployee( int employeeId )
	{
		employeeMap.put( employeeId, null );
	}

	public Employee getEmployee( int employeeId )
	{
		return employeeMap.get( employeeId );
	}

	public Employee getUnionMember( int memberId )
	{
		return unionMembers.get( memberId );
	}
	
	public void addUnionMember( int memberId, Employee employee )
	{
		unionMembers.put( memberId, employee );
	}

	public void deleteUnionMember( int memberId )
	{
		unionMembers.remove( memberId );
	}

	public Set<Integer> getAllEmployeeIds( )
	{
		return employeeMap.keySet( );
	}
	
    public void clear()
    {
        employeeMap.clear();
        unionMembers.clear();
    }

}
