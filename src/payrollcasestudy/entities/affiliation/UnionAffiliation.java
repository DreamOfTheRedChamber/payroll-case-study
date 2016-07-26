package payrollcasestudy.entities.affiliation;

import payrollcasestudy.entities.ServiceCharge;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class UnionAffiliation {
    private double dues;
    private int memberId;

    private Map<Calendar, ServiceCharge> serviceChargeMap = new HashMap<>();

    public static final UnionAffiliation NO_AFFILIATION = new UnionAffiliation( -1, 0 );

    public UnionAffiliation( int memberId, double dues ) {
        this.memberId = memberId;
        this.dues = dues;
    }

    public void addServiceCharge( Calendar date, double amount ) {
        this.serviceChargeMap.put( date, new ServiceCharge( date, amount) );
    }
}
