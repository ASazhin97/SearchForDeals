import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OutputPanel extends JPanel{
	private Handler _handler;
	private JLabel _keyWordsLabel;
	private JLabel _intervalLabel;
	private BoxLayout _topLayout;
	private BoxLayout _mainLayout;
	private JPanel _topPanel;
	
	private String _keyWords;
	private int _timeInt;
	
	private ActionListener _searcher;
	private Timer _timer;
	
	private WebPageParser parser;
	
	private ArrayList<JLabel> DealLabels; 
	private JFrame _listFrame;
	
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
		
		_listFrame = new JFrame();
		
		this.setLayout(_mainLayout);
		this.add(_topPanel);
		
		//create action listener for timer;
		_searcher = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		          searchDeals();
		      }
		  };
		  
		  
	}
	
	public void setKeyWords(String newWords) {
		_keyWords = newWords;
		_keyWordsLabel.setText("Key Words: " + _keyWords);
	}
	
	public void setMinInterval(int newInterval) {
		_timeInt = newInterval;
		_intervalLabel.setText("  Interval: " + Integer.toString(_timeInt));
	}
	
	public void startSearch() {
		_timer = new Timer(_timeInt * 60000, _searcher);
		System.out.println(_timeInt);
		_timer.start();
	}
	
	public void endSearch() {
		_timer.stop();
		System.exit(0);
	}
	
	private void searchDeals() {
		WebPageParser parser = new WebPageParser(_handler);
		ArrayList<Deal> deals = parser.getNewDeals();
		
		int s = deals.size();
		Deal[] dealArray = new Deal[s];
		
		if(!deals.isEmpty()) {
			
			
			for(int k = 0; k < deals.size(); k++) {
				System.out.println(deals.get(k).getName());
				
				dealArray[k] = deals.get(k);
			}
			
			new PopUp(dealArray, _keyWords);
		}
	}
	
	
}
