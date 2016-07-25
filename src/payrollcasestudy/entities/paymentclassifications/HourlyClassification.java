package payrollcasestudy.entities.paymentclassifications;

import payrollcasestudy.entities.TimeCard;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * employees paid on an hourly rate
 */
public class HourlyClassification extends PaymentClassification {
    private Map<Calendar, TimeCard> timeCardMap = new HashMap<>();
    private double hourlyRate;
}
