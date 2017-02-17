package week4.task_2.src.main.java.utills;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Pavel
 */
public class JsonParser
{

    public List<CurrencyPrivat> currenciesList(String jsonString)
    {
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<List<CurrencyPrivat>>(){}.getType();
        List<CurrencyPrivat> curr = gson.fromJson(jsonString, listType);
        return curr;
    }
}
