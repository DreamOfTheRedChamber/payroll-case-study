package payrollcasestudy.entities.affiliation;

import payrollcasestudy.entities.ServiceCharge;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class UnionAffiliation implements Affiliation {
    private double dues;
    private Map<Calendar, ServiceCharge> serviceChargeMap = new HashMap<>();
}
