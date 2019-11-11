import java.awt.GridLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel{
	private GridLayout _grid;
	private InputPanel _inputPanel;
	private OutputPanel _outputPanel;
	private Handler _handler; 
	
	public MainPanel() {
		_handler = new Handler();
		_grid = new GridLayout(0,2);
		_inputPanel = new InputPanel(_handler);
		_outputPanel = new OutputPanel(_handler);
		
		_handler.setOutputPanel(_outputPanel);
		
		this.setLayout(_grid);
		this.add(_inputPanel);
		this.add(_outputPanel);
	}
}
