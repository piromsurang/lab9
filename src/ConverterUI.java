import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterUI extends JFrame {
	
	private UnitConverter converter;
	private JTextField input;
	private JComboBox inputUnit;
	private JLabel equalSign;
	private JTextField output;
	private JComboBox outputUnit;
	private JButton convertButton;
	private JButton clearButton;
	private JRadioButton leftToRight;
	private JRadioButton rightToLeft;
	
	public ConverterUI( UnitConverter converter ) {
		super( "Distance Converter" );
		this.converter = converter;
		initComponent();
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public void run() {
		pack();
		setVisible( true );
	}
	
	public void initComponent() {

		JPanel topPanel = new JPanel();
		
		inputUnit = new JComboBox( Length.values() );
		
		equalSign = new JLabel( "  =  " );
		
		output = new JTextField( 10 );
		output.setEnabled( false );
		
		outputUnit = new JComboBox( Length.values() );
		
		ConvertButtonListener convertListener = new ConvertButtonListener();
		convertButton = new JButton( "convert!" );
		convertButton.addActionListener( convertListener );
		
		input = new JTextField( 10 );
		input.addActionListener( convertListener );
		
		clearButton = new JButton( "clear" );
		ClearButtonListener clearButtonListener = new ClearButtonListener();
		clearButton.addActionListener( clearButtonListener );
		
		topPanel.setLayout( new FlowLayout() );
		topPanel.add( input );
		topPanel.add( inputUnit );
		topPanel.add( equalSign );
		topPanel.add( output );
		topPanel.add( outputUnit );
		topPanel.add( convertButton );
		topPanel.add( clearButton );
		
		ViceVersaListener viceversa = new ViceVersaListener();
		leftToRight = new JRadioButton( "Left -> Right", true );
		leftToRight.addActionListener( viceversa );
		rightToLeft = new JRadioButton( "Right -> Left" );
		rightToLeft.addActionListener( viceversa );
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add( leftToRight );
		buttonGroup.add( rightToLeft );
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout( new FlowLayout() );
		
		bottomPanel.add( leftToRight );
		bottomPanel.add( rightToLeft );
		
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout( 2, 1 ) );
		
		panel.add( topPanel );
		panel.add( bottomPanel );
		
		this.add( panel );
	}
	
	class ConvertButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			if ( input.isEditable() == true ) {
				String s = input.getText().trim();
				if ( s.length() > 0 ) {
					double inputValue = Double.valueOf( s );
					double outputValue = converter.convert( inputValue,(Length) inputUnit.getSelectedItem(),(Length) outputUnit.getSelectedItem() );

					output.setText( outputValue + "" );
				}
			}
			
			if ( output.isEditable() == true ){
				String s = output.getText().trim();
				
				if ( s.length() > 0 ) {
					double inputValue = Double.valueOf( s );
					double outputValue = converter.convert( inputValue,(Length) outputUnit.getSelectedItem(),(Length) inputUnit.getSelectedItem() );
					
					System.out.println( outputValue );
					input.setText( outputValue + "" );
				}
			}
		}
	}
	
	class ClearButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			input.setText( "" );
			output.setText( "" );
			inputUnit.setSelectedIndex( 0 );
			outputUnit.setSelectedIndex( 0 );
		}
	}
	
	class ViceVersaListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			if ( leftToRight.isSelected() ) {
				output.setEnabled( false );
				input.setEnabled( true );
			}
			else {
				input.setEnabled( false );
				output.setEnabled( true );
			}
		}
	}
	
	public static void main( String[] args ) {
		UnitConverter converter = new UnitConverter();
		ConverterUI converterUI = new ConverterUI( converter );
		converterUI.run();
	}
	
}
