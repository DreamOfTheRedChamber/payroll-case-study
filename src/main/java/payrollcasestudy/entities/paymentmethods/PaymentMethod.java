
package payrollcasestudy.entities.paymentmethods;

import payrollcasestudy.entities.PayCheck;

/**
 * 
 * PaymentMethod is specified by fields inside payCheck
 */
public interface PaymentMethod
{
    void pay(PayCheck payCheck);
}
