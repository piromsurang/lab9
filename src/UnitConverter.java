
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
		
		double x = amount * toUnit.getDistance() / fromUnit.getDistance();
		if ( checkMeter( fromUnit.toString(), toUnit.toString() ) ) {
			x = amount * fromUnit.getDistance() / toUnit.getDistance();
		}
		
		return x;
	}
	
	/**
	 * to check whether both fromUnit and toUnit have same base unit
	 * 
	 * @param fromUnit is input unit
	 * @param toUnit is output unit
	 * @return return true or false
	 */
	public boolean checkMeter( String fromUnit, String toUnit) {
		if ( ( fromUnit.equals( "Meter" ) || fromUnit.equals( "Kilometer" ) || fromUnit.equals( "Centimeter" ) ) 
				&& ( toUnit.equals( "Meter" ) || toUnit.equals( "Kilometer" ) || toUnit.equals( "Centimeter" ) ) ) {
			return true;
		}
		else {
			return false;
		}
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
