
package payrollcasestudy.entities.paymentmethods;

import payrollcasestudy.entities.PayCheck;

/**
 * Created by zhangshijie on 7/22/16.
 */
public interface PaymentMethod
{
    void pay(PayCheck payCheck);
}
