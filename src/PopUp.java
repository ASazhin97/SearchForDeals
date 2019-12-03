import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class PopUp extends Popup{
	Popup pop;
	
	public PopUp(Deal[] dealArray, String keyWord) {
		PopupFactory poper = new PopupFactory();
		
		//basic panel
		JFrame frame = new JFrame("Deals found on: " + keyWord);
		JLabel label = new JLabel("Deals Available!");
		
		frame.setSize(1500, 600);
		JPanel panel = new JPanel();
		
		panel.add(label);
		pop = poper.getPopup(frame, panel, 100, 100);
		
		frame.add(panel);
		
		//list
		String[] links = new String[dealArray.length];
		String[] names = new String[dealArray.length];
		JPanel[] panelList = new JPanel[dealArray.length];
		
		for(int i = 0; i < dealArray.length; i++) {
			links[i] = dealArray[i].getLink();
			names[i] = dealArray[i].getName();
			
			JLabel nameLabel = new JLabel(dealArray[i].getName());
			JLabel linkLabel = new JLabel(dealArray[i].getLink());
		}
		
		JPanel listPanel = new JPanel();
		BoxLayout layout = new BoxLayout(listPanel, BoxLayout.X_AXIS);
		
		JList listLinks = new JList(links);
		JList listNames = new JList(names);
		listPanel.add(listNames);
		listPanel.add(listLinks);
		frame.add(listPanel);
		
		
		frame.show();
	}
	
	
	
}
