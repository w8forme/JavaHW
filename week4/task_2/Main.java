package week4.task_2.src.main.java;
import week4.task_2.src.main.java.utills.CurrencyPrivat;
import week4.task_2.src.main.java.utills.JsonParser;
import week4.task_2.src.main.java.utills.SiteConnector;
import week4.task_2.src.main.java.utills.UserInput;

import java.util.Iterator;
import java.util.List;


/**
 * Created by Pavel
 */
public class Main
{

    public static void main(String[] args)
    {
        UserInput read = new UserInput();
        JsonParser jsonParser = new JsonParser();
        SiteConnector siteConnector = new SiteConnector();

        String json = siteConnector.currencyJson();
        String userInput = read.userInput();
        List<CurrencyPrivat> currenciesList = jsonParser.currenciesList(json);
        Iterator<CurrencyPrivat> iterator = currenciesList.iterator();

        while (iterator.hasNext())
        {
            CurrencyPrivat currency = iterator.next();
            if (currency.getCcy().equals(userInput))
            {
                System.out.println("Выбрана валютная пара: " + currency.getCcy() + " - " + currency.getBase_ccy());
                System.out.println(currency.getCcy() + " покупка: " + currency.getBuy() + " || продажа: " + currency.getSale());
            }
        }
    }
}
