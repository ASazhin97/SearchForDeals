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
	
	public InputPanel(Handler handler) {
		_handler = handler;
		_keyInput = new JTextField(30);
		_intervalInput = new JTextField(30);
		_setValuesButton = new JButton("Set Settings");
		
		Dimension size = new Dimension(500, 30);
		_keyInput.setMaximumSize(size);
		_intervalInput.setMaximumSize(size);
		
		_layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		_keyLabel = new JLabel("Key Words");
		_intervalLabel = new JLabel("Checking Interval");
		
		
		this.setLayout(_layout);
		this.add(_keyLabel);
		this.add(_keyInput);
		this.add(_intervalLabel);
		this.add(_intervalInput);
		this.add(_setValuesButton);
		
		_setValuesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				_handler.setKeyWords(_keyInput.getText());
				_handler.setMinInterval(Integer.parseInt(_intervalInput.getText()));
			}
			
		});
	}
}
