
public class UnitConverter {
	public double convert( double amount, Length fromUnit, Length toUnit ) {
		
		double x = amount * toUnit.getDistance() / fromUnit.getDistance();
		if ( checkMeter( fromUnit.toString(), toUnit.toString() ) ) {
			x = amount * fromUnit.getDistance() / toUnit.getDistance();
		}
		
		return x;
	}
	
	public boolean checkMeter( String fromUnit, String toUnit) {
		if ( ( fromUnit.equals( "Meter" ) || fromUnit.equals( "Kilometer" ) || fromUnit.equals( "Centimeter" ) ) 
				&& ( toUnit.equals( "Meter" ) || toUnit.equals( "Kilometer" ) || toUnit.equals( "Centimeter" ) ) ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Length[] getLength() {
		return Length.values();
	}
}
