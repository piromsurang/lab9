package converter;

public class ConverterApp {
	/**
	 * main to run GUI
	 * 
	 * @param args
	 * @author Piromsurang
	 */
	public static void main( String[] args ) {
		UnitConverter converter = new UnitConverter();
		ConverterUI converterUI = new ConverterUI( converter );
		converterUI.run();
	}
}
