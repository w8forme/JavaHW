package Week2.Task_5;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pavel
 */
public class Library
{


    public static List<String> toList()
    {
        String line;
        String filePath = "CoursesHomeTasks\\src\\Week2\\Task_5\\Songs.txt";
        List<String> songList = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            while ((line = reader.readLine()) != null)
            {
                songList.add(line);
            }

        }
        catch (FileNotFoundException e)
        {
            System.err.print("Файл не найден! " + e.getMessage());
        }
        catch (IOException e)
        {
            System.err.print("Ошибка ввода-вывода! " + e.getMessage());
        }
        finally
        {
            Collections.sort(songList);
            return songList;
        }
    }
}
