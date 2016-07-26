package payrollcasestudy.entities.paymentclassifications;

import payrollcasestudy.entities.TimeCard;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * employees paid on an hourly rate
 */
public class HourlyClassification extends PaymentClassification {
    private Map<Calendar, TimeCard> timeCardMap;
    private double hourlyRate;

    public HourlyClassification( double hourlyRate ) {
        this.hourlyRate = hourlyRate;
        timeCardMap = new HashMap<>();
    }

    public void addTimeCard( TimeCard timeCard ) {
        timeCardMap.put( timeCard.getDate(), timeCard );
    }
}
