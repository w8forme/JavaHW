package holinko.com.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
@Component
public class LigaNews implements NewsReader
{
    private String url;
    private List<String> news;

    public LigaNews()
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

    //Get news text
    private String parseText(String link) throws IOException
    {
        Document newsText = Jsoup.connect(link).get();
        //Delete from text advertising information
        for (Element element : newsText.select("b"))
        {
            String adv = element.text().toLowerCase();
            if ((adv.contains("Читайте также:".toLowerCase()))
                    || adv.contains("Подписывайтесь на аккаунт".toLowerCase())
                    || adv.contains("Читайте нас:".toLowerCase()))
            {
                element.remove();
            }
        }
        //Select news text and put in map as value
        Elements elements = newsText.select("div.text._ga1_on_ p");
        return elements.text();
    }

    private List<String> parseNews()
    {
        List<String> result = new ArrayList<String>();
        Document document = null;
        while (null == document)
        {
            try
            {
                document = prepareDoc();
                Elements links = document.select("#all_news .title a[href]");
                Elements titles = document.select("#all_news .title a");
                for (int i = 0, j = 0; i < titles.size(); i++, j++)
                {
                    Element link = links.get(j);
                    String href = link.attr("abs:href");
                    String text = parseText(href);
                    String title = titles.get(i).text();
                    result.add(title + "\n" + text + "\n");
                }
            } catch (IOException e)
            {
                //e.printStackTrace();
                System.err.println("Connection lost. Please check your internet connection.");
                System.err.println("Wait for reconnect...");
                try
                {
                    Thread.sleep(10000);
                } catch (InterruptedException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public String readNews()
    {
        String result;
        if (null != news && !news.isEmpty())
        {
            result = (news.get(0));
            news.remove(0);
        } else
        {
            news = parseNews();
            result = (news.get(0));
            news.remove(0);
        }
        return result;
    }
}
