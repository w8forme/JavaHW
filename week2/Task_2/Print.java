package week2.Task_2;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Pavel
 */
public class Print
{

    public void printStudents(List<Student> s, int course)
    {
        Iterator<Student> iter = s.iterator();
        while (true)
        {
            if (course > 0 && course < 6)
            {
                for (Student stud : s)
                {
                    if (course == stud.getCourse())
                    {
                        System.out.println(stud);
                    }
                }
                break;
            }
            else
            {
                System.out.println("Такого курса не существует!");
                break;
            }
        }

    }

    public static void main(String[] args)
    {
        Print a = new Print();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер курса: ");
        int scan = in.nextInt();
        a.printStudents(ListOfStudents.studList(), scan);
        in.close();
    }
}
