package converter;

public class UnitConverter {
	
	/**
	 * convert distance of input unit to distance of output unit
	 * 
	 * @param amount is amount that is input by the user
	 * @param fromUnit is input unit
	 * @param toUnit is output unit
	 * @return return result
	 */
	public double convert( double amount, Length fromUnit, Length toUnit ) {
		
		double x = amount * toUnit.getValue() / fromUnit.getValue();
		
		return x;
	}
	
	/**
	 * 
	 * get array of Length
	 * @return return array of Length
	 */
	public Length[] getLength() {
		return Length.values();
	}
}
