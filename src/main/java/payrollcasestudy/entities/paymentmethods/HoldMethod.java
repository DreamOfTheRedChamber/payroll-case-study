
package main.java.payrollcasestudy.entities.paymentmethods;

import main.java.payrollcasestudy.entities.PayCheck;

/**
 * paychecks held for pick up by paymentmaster
 */
public class HoldMethod implements PaymentMethod
{
    @Override
    public void pay(PayCheck payCheck) 
    {
        payCheck.setField("Disposition", "Hold");
    }
}