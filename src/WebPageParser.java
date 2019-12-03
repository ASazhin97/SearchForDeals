import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebPageParser {
	private Document doc;
	private List<String> URLdeal = new ArrayList<>();
	public static Handler handler;
	ArrayList<Deal> _deals;

	public WebPageParser(Handler handler) {
		try {
			doc = Jsoup.connect("https://dealsea.com/search?q=" + handler.getKeyWords() + "&search_mode=Deals").get();
			System.out.println("SEARCHING FOR DEALS...");
			System.out.println("KEYWORD: " + handler.getKeyWords() + " ");
			_deals = new ArrayList<Deal>();

			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if (link.text().toLowerCase().contains(handler.getKeyWords())) {
					Deal newDeal = new Deal(link.text(), link.absUrl("href"));
					_deals.add(newDeal);
//					
//					System.out.println("Discounted Item: " + link.text());
//					System.out.println("Link: " + link.absUrl("href"));
//					URLdeal.add(link.absUrl("href"));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Deal> getNewDeals(){
		return _deals;
	}
	
}
