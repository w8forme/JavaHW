package holinko.com.controller;

/**
 * Created by Pavel
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;

public class SiteConnector
{
    public static void main(String[] args) throws Exception
    {
        String url = "http://news.liga.net/";
        Document document = Jsoup.connect(url).get();
//

        Elements links = document.select("#all_news .title a[href]");
        Elements titles = document.select("#all_news .title a");


            for (int i = 0, j = 0; i < titles.size(); i++, j++)
            {
                titles.get(i);
                links.get(j);
            }


        for (Element answerer : titles)
        {
            System.out.println("Answerer: " + answerer.text());
            for (Element link : links)
            {
                String href = link.attr("abs:href");
                System.out.println("Question: " + href);
                Document newsText = Jsoup.connect(href).get();
                String text = newsText.select("div.text._ga1_on_").text();
                System.out.println(text);

            }

        }
    }
}
