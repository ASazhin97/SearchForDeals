import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OutputPanel extends JPanel{
	private Handler _handler;
	private JLabel _keyWordsLabel;
	private JLabel _intervalLabel;
	private BoxLayout _topLayout;
	private BoxLayout _mainLayout;
	private JPanel _topPanel;
	
	private String _keyWords;
	private int _timeInt;
	
	public OutputPanel(Handler handler) {
		_handler = handler;
		_keyWords = _handler.getKeyWords();
		_timeInt = _handler.getMinInterval();
		
		_keyWordsLabel = new JLabel("Key Words: " + _keyWords);
		_intervalLabel = new JLabel("  Checking Interval: " + Integer.toString(_timeInt));
		
		_mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		
		
		_topPanel = new JPanel();
		_topLayout = new BoxLayout(_topPanel, BoxLayout.X_AXIS);
		_topPanel.setLayout(_topLayout);
		
		_topPanel.add(_keyWordsLabel);
		_topPanel.add(_intervalLabel);
		
		this.setLayout(_mainLayout);
		this.add(_topPanel);
		
	}
	
	public void setKeyWords(String newWords) {
		_keyWords = newWords;
		_keyWordsLabel.setText("Key Words: " + _keyWords);
	}
	
	public void setMinInterval(int newInterval) {
		_timeInt = newInterval;
		_intervalLabel.setText("  Interval: " + Integer.toString(_timeInt));
	}
}
