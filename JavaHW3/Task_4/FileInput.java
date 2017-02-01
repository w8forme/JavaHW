package JavaHW3.Task_4;
import java.io.*;
import java.util.*;


public class FileInput
{
    //This method read file and save data to LinkedHashMap, english word is key, russian is value.
    public static Map<String, String> fileRead()
    {
        String filePath = "CoursesHomeTasks\\src\\JavaHW3\\Task_4\\english-russian.txt";
        Map<String, String> map = new LinkedHashMap<String, String>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(":", 2);
                if (parts.length >= 2)
                {
                    String key = parts[0];
                    String value = parts[1];
                    map.put(key, value);
                }
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return map;
    }
}
