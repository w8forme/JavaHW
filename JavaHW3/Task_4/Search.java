package JavaHW3.Task_4;
import java.util.Map;

public class Search
{
    //This method receive the filed LinkedHashMap and return translation by typed key
    public static String showWord(Map<String, String> m, String word)
    {
            String result = m.get(word);
            System.out.println("Перевод слова " + word + ": " + result);
            return result;
    }
}
