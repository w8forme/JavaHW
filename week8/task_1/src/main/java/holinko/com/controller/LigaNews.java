package holinko.com.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pavel
 */
public class LigaNews implements NewsReader
{
    private String url;

    public void init()
    {

    }

    private Document prepareDoc() throws IOException
    {
        url = "http://news.liga.net/";
        Document document = Jsoup.connect(url).get();
        for (Element element : document.select("a.liga_finance.small"))
        {
            element.remove();
        }
        return document;
    }

    private Map<String, String> parseNews(Document document)
    {
        Map<String, String> news = new HashMap<String, String>();
        try
        {
            document = prepareDoc();
            Elements links = document.select("#all_news .title a[href]");
            Elements titles = document.select("#all_news .title a");
            for (int i = 0, j = 0; i < titles.size(); i++, j++)
            {
                Element link = links.get(j);
                String href = link.attr("abs:href");
                Document newsText = Jsoup.connect(href).get();
                //Delete from text advertising information
                for( Element element : newsText.select("b") )
                {
                    element.remove();
                }
                //Select news text and put in map as value
                Elements elements = newsText.select("div.text._ga1_on_ p");
                news.put(titles.get(i).text(), elements.text());
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public String readNews()
    {


        return "";


    }
}
