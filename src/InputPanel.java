import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel{
	private Handler _handler;
	private JTextField _keyInput;
	private JTextField _intervalInput;
	private JLabel _intervalLabel;
	private BoxLayout _layout;
	private JLabel _keyLabel;
	private JButton _setValuesButton;
	private JButton _startSearchButton;
	private JButton _endSearchButton;
	private JLabel _ethicalLabel;
	
	public InputPanel(Handler handler) {
		_handler = handler;
		_keyInput = new JTextField(30);
		_intervalInput = new JTextField(30);
		_setValuesButton = new JButton("Set Settings");
		_startSearchButton = new JButton("Start Searching");
		_endSearchButton = new JButton("End Seach");
		
		Dimension size = new Dimension(500, 30);
		_keyInput.setMaximumSize(size);
		_intervalInput.setMaximumSize(size);
		
		_layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		_keyLabel = new JLabel("Key Words");
		_intervalLabel = new JLabel("Checking Interval");
		_ethicalLabel = new JLabel("WARNING: Setting interval below 5 is unadvised.");
		
		
		this.setLayout(_layout);
		this.add(_keyLabel);
		this.add(_keyInput);
		this.add(_intervalLabel);
		this.add(_intervalInput);
		this.add(_setValuesButton);
		this.add(_startSearchButton);
		this.add(_endSearchButton);
		this.add(_ethicalLabel);
		
		_setValuesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				_handler.setKeyWords(_keyInput.getText());
				_handler.setMinInterval(Integer.parseInt(_intervalInput.getText()));
			}
			
		});
		
		_startSearchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				_handler.startSearch();
			}
			
		});
		
		_endSearchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_handler.endSearch();
				
			}
			
		});
	}
}
