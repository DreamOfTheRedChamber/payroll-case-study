package payrollcasestudy;

import payrollcasestudy.entities.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class PayrollDatabase {
    public static PayrollDatabase globalPayrollDatabase = new PayrollDatabase();
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee( int employeeId, Employee employee )
    {
        employeeMap.put( employeeId, employee );
    }

    public void deleteEmployee( int employeeId )
    {
        employeeMap.put( employeeId, null );
    }
}
