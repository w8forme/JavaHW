package holinko.com.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Pavel
 */
public class Test
{

    public static void main(String[] args) throws IOException
    {
        Document newsText = Jsoup.connect("http://news.liga.net/news/world/14711043-umer_datskiy_prints_richard.htm").get();

        for( Element element : newsText.select("b") )
        {
            element.remove();
        }
        Elements elements = newsText.select(".text._ga1_on_ p");
        System.out.println(elements.size());
        System.out.println(elements.text());




//        String text = elements.toString();
//        elements.removeAttr("#div.text._ga1_on_ .p");
//        System.out.println(text);
//
//        Whitelist wl = Whitelist.simpleText();
//        wl.addTags("b"); // add additional tags here as necessary
//        Cleaner cleaner = new Cleaner(wl);
//        newsText = cleaner.clean(newsText);
//        System.out.println(newsText.text());


    }

}
