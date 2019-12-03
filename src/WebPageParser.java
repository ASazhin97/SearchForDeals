import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebPageParser {
	private Document doc;
	public static Handler handler;
	ArrayList<Deal> _deals;

	public WebPageParser(Handler handler) {
		try {
<<<<<<< HEAD
			if (handler.getKeyWords().contains(" ")) {
				String newKeyword = handler.getKeyWords().replace(" ", "+");
				doc = Jsoup.connect("https://dealsea.com/search?q=" + newKeyword + "&search_mode=Deals").get();
			} else {
				doc = Jsoup.connect("https://dealsea.com/search?q=" + handler.getKeyWords() + "&search_mode=Deals").get();
			}
=======
			
>>>>>>> addMultSearch
			System.out.println("SEARCHING FOR DEALS...");
			System.out.println("KEYWORD: " + handler.getKeyWords() + " ");
			_deals = new ArrayList<Deal>();
			
			String[] wordsArray = handler.getKeyWords().split(", ");

<<<<<<< HEAD
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if (link.text().toLowerCase().contains(handler.getKeyWords())) {
					Deal newDeal = new Deal(link.text(), link.absUrl("href"));
					_deals.add(newDeal);
=======

			for (String s : wordsArray) {
				System.out.println(s);
				doc = Jsoup.connect("https://dealsea.com/search?q=" + s + "&search_mode=Deals").get();
				Elements links = doc.select("a[href]");

				for (Element link : links) {

					if (link.text().toLowerCase().contains(s)) {
						Deal newDeal = new Deal(link.text(), link.absUrl("href"));
						_deals.add(newDeal);
					}
>>>>>>> addMultSearch
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
