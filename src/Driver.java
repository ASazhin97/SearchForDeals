import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver extends JFrame{
	private JPanel _mainPanel;
	
	public Driver() {
		super("Deal Finder");
		this.setSize(800,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		_mainPanel = new MainPanel();
		this.add(_mainPanel);
		System.out.println("Starting Program");
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Driver();
		
		
	}
}
