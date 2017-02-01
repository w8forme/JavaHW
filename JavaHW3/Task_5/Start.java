package JavaHW3.Task_5;
import java.util.List;

/**
 * Created by Pavel
 */
public class Start
{
    
    private void show(List<String> list)
    {
        System.out.println("Отсортированный список песен: ");
        for (String songs: list)
        {
            System.out.println(songs);
        }
    }

    public static void main(String[] args)
    {
        Start s = new Start();
        s.show(Library.toList());
    }
}
