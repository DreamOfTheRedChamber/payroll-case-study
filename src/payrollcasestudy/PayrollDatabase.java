package payrollcasestudy;

import java.util.HashMap;
import java.util.Map;

import entities.Employee;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class PayrollDatabase 
{
    public static PayrollDatabase globalPayrollDatabase = new PayrollDatabase();
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private Map<Integer, Employee> unionMembers = new HashMap<>();

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

    public void addUnionMember( int memberId, Employee employee ) 
    {
        unionMembers.put( memberId, employee);
    }

    public void deleteUnionMember( int memberId ) 
    {
        unionMembers.remove( memberId );
    }
}
