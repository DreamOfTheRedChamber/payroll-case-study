package payrollcasestudy.entities.paymentschedule;

import java.util.Calendar;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class WeeklyPaymentSchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(Calendar payDate)
    {
        return true;
    }
    
    @Override
    public Calendar getPayPeriodStartDate(Calendar payDate) 
    {
        Calendar monday = (Calendar) payDate.clone();
        monday.roll(Calendar.DAY_OF_MONTH, -5);
        return monday;
    }
}
