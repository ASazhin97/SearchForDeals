import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebPageParser {
	Document doc;
	public WebPageParser(String page) {
		
		try {
			doc = Jsoup.connect("https://dealsea.com/").get();
			System.out.println(doc.title());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getAllDeals() {
		
	}
}
