
package main.java.payrollcasestudy.entities.paymentmethods;

import main.java.payrollcasestudy.entities.PayCheck;

/**
 * Created by zhangshijie on 7/22/16.
 */
public interface PaymentMethod
{
    void pay(PayCheck payCheck);
}
