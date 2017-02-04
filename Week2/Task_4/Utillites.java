package Week2.Task_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Pavel
 * <p>
 * Parsing file and creating LinkedHashMap
 */
public class Utillites
{
    static List<String> arrList = new ArrayList<String>();
    static Map<String, String> map = new LinkedHashMap<String, String>();
    static String line;

    public static Map<String, String> parsAndCreate()
    {
        try
        {
            BufferedReader reader = FileInput.getFileReader();
            while ((line = reader.readLine()) != null )
            {
                //Create array for storing key-value pairs and than put it in the map
                String[] parts = line.split(":", 2);
                parseAndWriteToMap(parts);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return map;
    }

    private static void parseAndWriteToMap(String[] parts)
    {
        if (parts.length >= 2)
        {
            String value = parts[0];
            String key = parts[1];
            if (key.contains(","))
            {
                arrList = Arrays.asList(key.replaceAll(" ", "").split(","));
                for (String s : arrList)
                {
                    map.put(s, value);
                }
            } else
            {
                map.put(key, value);
            }
        }
    }
}
