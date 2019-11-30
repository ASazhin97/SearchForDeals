import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebPageParser {
	Document doc;
	public WebPageParser(String page) {
		// This gets all the links from the webpage.
		try {
			doc = Jsoup.connect("https://dealsea.com/").get();
			System.out.println(doc.title());
			String title = doc.title();
			System.out.println("Title: " + title);

			Elements links = doc.select("a[href]");
			for (Element link : links) {
				System.out.println("link: " + link.attr("href"));
				System.out.println("text: " + link.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getAllDeals() {
		
	}

	public void search(String search) throws IOException {
		String url = "https://dealsea.com/search?q=" + search + "&search_mode=Deals";
		doc = Jsoup.connect(url).userAgent("Jsoup client").timeout(5000).get();
		

	}
}
