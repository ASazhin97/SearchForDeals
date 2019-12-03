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

	public WebPageParser(String page) {
		try {
			// format of URL is: https://dealsea.com/search?q=" + keyword + "&search_mode=Deals
			doc = Jsoup.connect("https://dealsea.com/search?q=router&search_mode=Deals").get();
			System.out.println("SEARCHING FOR DEALS...");
			String keyword = doc.title();
			String[] text = keyword.split(" ");
			System.out.println("KEYWORD: " + text[1]);

			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if (link.text().toLowerCase().contains("router")) {
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
