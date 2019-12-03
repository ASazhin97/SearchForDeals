import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver extends JFrame{
	private JPanel _mainPanel;
	
	public Driver() {
		super("Deal Bot");
		this.setSize(800,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		_mainPanel = new MainPanel();
		this.add(_mainPanel);
		System.out.println("Booting Deal Bot");
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Driver();
		
		
	}
}
