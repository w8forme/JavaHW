package Week2.Task_0;
import java.io.*;

/**
 * Created by Pavel
 */
public class IoFile
{

    public void toFile()
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("hello.txt")))
        {
            System.out.print("Введите текст: ");
            while (true)
            {
                String nextLine = reader.readLine(); //Read a user's input until he type's "exit"
                if (nextLine.equals("exit"))
                {
                    break;
                }
                bw.write(nextLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void fromFile()
    {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("hello.txt")))
        {
            System.out.print("Текст из файла: ");
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        IoFile io = new IoFile();
        io.toFile();
        io.fromFile();
    }
}
