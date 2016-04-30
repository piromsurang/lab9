package converter;

/**
 * 
 * @author Piromsurang
 *
 */
public enum Length implements Unit {
	METER( "Meter", 1.0 ),
	CENTIMETER( "Centimeter", 100.0 ),
	KILOMETER( "Kilometer", 0.001 ),
	MILE( "Mile", 1609.344 ),
	FOOT( "Feet", 0.30480),
	WA( "Wa", 2.0 );
	
	
	public final double distance;
	public final String name;
	
	/**
	 * 
	 * @param n is the input name
	 * @param d is the input distance
	 */
	private Length( String n, double d ) {
		this.distance = d;
		this.name = n;
	}
	
	/**
	 * 
	 * @return return distance
	 */
	public double getValue() {
		return this.distance;
	}
	
	/**
	 * 
	 * @return return name
	 */
	public String toString() {
		return this.name;
	}
}
