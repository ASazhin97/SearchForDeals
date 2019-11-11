
public class Handler {
	private String _keyWords;
	private int _minInterval;
	private OutputPanel _panel;
	
	public Handler() {
		_keyWords = "";
		_minInterval = 10;
	}
	
	public void setKeyWords(String keyWords) {
		_keyWords = keyWords;
		_panel.setKeyWords(_keyWords);
	}
	
	public String getKeyWords() {
		return _keyWords;
	}
	
	public void setMinInterval(int minutes) {
		_minInterval = minutes;
		_panel.setMinInterval(_minInterval);
	}
	
	public int getMinInterval() {
		return _minInterval;
	}
	
	public void setOutputPanel(OutputPanel panel) {
		_panel = panel;
	}
}
