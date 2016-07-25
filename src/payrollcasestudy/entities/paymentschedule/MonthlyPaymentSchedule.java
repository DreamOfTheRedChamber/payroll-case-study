package payrollcasestudy.entities.paymentschedule;

import java.util.Calendar;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class MonthlyPaymentSchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(Calendar payDate)
    {
        return true;
    }
}
