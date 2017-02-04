package Week2.Task_4;
import java.io.*;
import java.util.*;


public class FileInput
{
    //This method reads the file and saves the data to the LinkedHashMap, the english word is a key, the russian one is a value.
    public static String fileRead()
    {
        String filePath = "CoursesHomeTasks\\src\\Week2\\Task_4\\rsen.txt"; //This path needs to be changed
        String line;
        List<String> arrList = new ArrayList<String>();
        Map<String, String> map = new LinkedHashMap<String, String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            while ((line = reader.readLine()) != null)
            {
                //Create array for storing key-value pairs and than put it in the map
                String[] parts = line.split(":", 2);
                if (parts.length >= 2)
                {
                    String value = parts[0];
                    String key = parts[1];
                    if (key.contains(","))
                    {

                        arrList = Arrays.asList(key.replaceAll(" ", "").split(","));
                        for (String s: arrList)
                        {
                            map.put(s, value);
                        }
                    }
                    else
                    {
                        map.put(key, value);
                    }
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
