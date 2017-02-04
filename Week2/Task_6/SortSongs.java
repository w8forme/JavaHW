package Week2.Task_6;
import java.util.*;

/**
 *  For the right work of the app you need to change the path for the file "SongLibrary.txt" in the class "FileReader"
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
                return choice;
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
        String leftAlignFormat = "| %-40s | %-30s | %-7s |%n";
        int count = 0;
        if (num == 1)
        {
            Collections.sort(list, new SongArtistComparator());
            System.out.println("===================== ОТСОРТИРОВАННЫЙ СПИСОК ПЕСЕН ПО ИСПОЛНИТЕЛЮ =====================");
            System.out.printf(leftAlignFormat, "Название песни", "Исполнитель", "Рейтинг");
            System.out.println("---------------------------------------------------------------------------------------");
            for (Song s: list)
            {
                System.out.println(s);
                count++;
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.print("Количество песен: " + count);
        }
        else if (num == 2)
        {
            Collections.sort(list, new SongNameComparator());
            System.out.println("====================== ОТСОРТИРОВАННЫЙ СПИСОК ПЕСЕН ПО НАЗВАНИЮ =======================");
            System.out.printf(leftAlignFormat, "Название песни", "Исполнитель", "Рейтинг");
            System.out.println("---------------------------------------------------------------------------------------");
            for (Song s: list)
            {
                System.out.println(s);
                count++;
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.print("Количество песен: " + count);
        }
        else if (num == 3)
        {
            Collections.sort(list, new SongRatingComparator());
            System.out.println("====================== ОТСОРТИРОВАННЫЙ СПИСОК ПЕСЕН ПО РЕЙТИНГУ =======================");
            System.out.printf(leftAlignFormat, "Название песни", "Исполнитель", "Рейтинг");
            System.out.println("---------------------------------------------------------------------------------------");
            for (Song s: list)
            {
                System.out.println(s);
                count++;
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.print("Количество песен: " + count);
        }
        else
        {
            System.out.println("Good bye!");
        }
    }

    public static void main(String[] args)
    {
        SortSongs a = new SortSongs();
        a.show(FileReader.toList(), a.userInput());
    }
}
