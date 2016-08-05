
package payrollcasestudy.entities.paymentclassifications;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import payrollcasestudy.entities.PayCheck;
import payrollcasestudy.entities.TimeCard;

/**
 * employees paid on an hourly rate
 */
public class HourlyClassification extends PaymentClassification
{

	private Map<Calendar, TimeCard> timeCardMap;
	private double hourlyRate;

	public HourlyClassification( double hourlyRate )
	{
		this.hourlyRate = hourlyRate;
		timeCardMap = new HashMap<>( );
	}

	public void addTimeCard( TimeCard timeCard )
	{
		timeCardMap.put( timeCard.getDate( ), timeCard );
	}

	@Override
	public double calculatePay( PayCheck payCheck )
	{
		double totalPay = 0;
		for ( TimeCard timeCard : timeCardMap.values( ) )
		{
			if ( isInPayPeriod( timeCard.getDate( ), payCheck ) )
			{
				totalPay += calculatePayForTimeCard( timeCard );
			}
		}
		return totalPay;
	}

	private double calculatePayForTimeCard( TimeCard timeCard )
	{
		double hours = timeCard.getHours( );
		double overtime = Math.max( 0.0, hours - 8.0 );
		double straightTime = hours - overtime;
		return straightTime * hourlyRate + overtime * hourlyRate * 1.5;
	}

}
