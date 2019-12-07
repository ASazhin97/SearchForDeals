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

			System.out.println("SEARCHING FOR DEALS...");
			System.out.println("KEYWORD: " + handler.getKeyWords() + " ");
			_deals = new ArrayList<Deal>();

			String[] wordsArray = handler.getKeyWords().split(", ");


			for (String s : wordsArray) {
				System.out.println(s);
				doc = Jsoup.connect("https://dealsea.com/search?q=" + s + "&search_mode=Deals").get();
				Elements links = doc.select("a[href]");
				Elements expired = doc.select("span[class]");

				for (Element link : links) {

					if (link.text().toLowerCase().contains(s) | !expired.text().contains("Expired")) {
						Deal newDeal = new Deal(link.text(), link.absUrl("href"));
						_deals.add(newDeal);
					}
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