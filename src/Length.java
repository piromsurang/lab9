/**
 * 
 * @author Piromsurang
 *
 */
public enum Length {
	METER( "Meter", 1.0 ),
	CENTIMETER( "Centimeter", 0.01 ),
	KILOMETER( "Kilometer", 1000.0 ),
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
	public double getDistance() {
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
