package JavaHW3.Task_6;
import java.util.*;

/**
 * Created by Pavel
 */
public class SortSongs
{
    private int userInput()
    {
        int choice;
        try (Scanner in = new Scanner(System.in))
        {
            do
            {
                System.out.println("Сортировка:");
                System.out.println(" 1. По исполнителю.");
                System.out.println(" 2. По названиию песни.");
                System.out.println(" З. По рейтингу.\n");
                System.out.print("Bыбepитe значение (для выхода нажмине 0): ");
                choice = in.nextInt();
            }
            while (choice < 0 && choice > 3);
            {
                switch (choice)
                {
                    case 1:
                    case 2:
                    case 3:
                        return choice;
                    default:
                        break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    public void show(List<Song> list, int num)
    {
        if (num == 1)
        {
            Collections.sort(list, new SongArtistComparator());
            System.out.println("===== ОТСОРТИРОВАННЫЙ СПИСОК ПЕСЕН ПО ИСПОЛНИТЕЛЮ =====");
            for (Song s: list)
            {
                System.out.println(s);
            }
        }
        else if (num == 2)
        {
            Collections.sort(list, new SongNameComparator());
            System.out.println("===== ОТСОРТИРОВАННЫЙ СПИСОК ПЕСЕН ПО НАЗВАНИЮ =====");
            for (Song s: list)
            {
                System.out.println(s);
            }
        }
        else if (num == 3)
        {
            Collections.sort(list, new SongRatingComparator());
            System.out.println("===== ОТСОРТИРОВАННЫЙ СПИСОК ПЕСЕН ПО РЕЙТИНГУ =====");
            for (Song s: list)
            {
                System.out.println(s);
            }
        }
        else
        {
            System.out.println("Good bye!");
        }
    }

    public static void main(String[] args)
    {
        SortSongs a = new SortSongs();
        System.out.println(FileReader.toList().toString());
        a.show(FileReader.toList(), a.userInput());
    }
}
