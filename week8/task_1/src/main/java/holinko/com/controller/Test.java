package holinko.com.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Pavel
 */
public class Test
{

    public static void main(String[] args) throws IOException
    {
        Document newsText = Jsoup.connect("http://news.liga.net/news/world/14711043-umer_datskiy_prints_richard.htm").get();
        String text = newsText.select("div.text._ga1_on_").text();
        System.out.println(text);
    }

}
