
package payrollcasestudy.entities.paymentmethods;

import payrollcasestudy.entities.PayCheck;

/**
 * represents the payment method which is held by paymentmaster for pick up 
 */
public class HoldMethod implements PaymentMethod
{
    @Override
    public void pay(PayCheck payCheck) 
    {
        payCheck.setField("Disposition", "Hold");
    }
}