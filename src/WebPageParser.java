import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebPageParser {
	Document doc;
	List<String> URLdeal = new ArrayList<>();
	public static Handler handler;

	public WebPageParser(Handler handler) {
		try {
			doc = Jsoup.connect("https://dealsea.com/search?q=" + handler.getKeyWords() + "&search_mode=Deals").get();
			System.out.println("SEARCHING FOR DEALS...");
			System.out.println("KEYWORD: " + handler.getKeyWords() + " ");


			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if (link.text().toLowerCase().contains(handler.getKeyWords())) {
					System.out.println("Discounted Item: " + link.text());
					System.out.println("Link: " + link.absUrl("href"));
					URLdeal.add(link.absUrl("href"));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
