package payrollcasestudy.entities.paymentclassifications;

import payrollcasestudy.entities.SalesReceipt;

import java.util.Calendar;
import java.util.HashMap;

/**
 * employees paid based on sales receipts which record the date and amount of the sale
 */
public class CommissionedClassification extends PaymentClassification {
    private double commissionRate;
    private double salary;
    private Map<Calendar, SalesReceipt> salesReceiptMap = new HashMap<>();
}