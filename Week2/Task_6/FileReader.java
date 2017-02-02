package Week2.Task_6;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
public class FileReader
{

    public static List<Song> toList()
    {
        String line;
        String filePath = "CoursesHomeTasks\\src\\Week2\\Task_6\\SongsLibrary.txt";
        List<Song> songList = new ArrayList<Song>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath)))
        {
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split("/", 3);
                if (parts.length >= 3)
                {
                    String sName = parts[1];
                    String sArtist = parts[0];
                    Integer sRating = Integer.parseInt(parts[2]);
                    songList.add(new Song(sName, sArtist, sRating));
                }
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
            return songList;
        }
    }
}
