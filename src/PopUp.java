import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class PopUp {
	Popup pop;
	
	public PopUp() {
		PopupFactory poper = new PopupFactory();
		
		JFrame frame = new JFrame("SearchForDeals");
		JLabel label = new JLabel("Deals Available!");
		
		frame.setSize(100, 300);
		JPanel panel = new JPanel();
		
		panel.add(label);
		pop = poper.getPopup(frame, panel, 100, 50);
		
		frame.add(panel);
		frame.show();
	}
	
	
	
}
