package JavaHW3.Task_4;
import java.io.*;
import java.util.*;


public class FileInput
{
    //This method read file and save data to LinkedHashMap, english word is key, russian is value.
    public static Map<String, String> fileRead()
    {
        String filePath = "CoursesHomeTasks\\src\\JavaHW3\\Task_4\\english-russian.txt"; //This path need to be changed
        String line;
        Map<String, String> map = new LinkedHashMap<String, String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            while ((line = reader.readLine()) != null)
            {
                //Create array for storing key-value pair and than put it in map
                String[] parts = line.split(" ", 2);
                if (parts.length >= 2)
                {
                    String key = parts[0];
                    String value = parts[1];
                    map.put(key, value);
                }
            }

        }
        catch (Exception e)
        {
            System.err.println("Error!" + e.getMessage());
        }
        return map;
    }
}
