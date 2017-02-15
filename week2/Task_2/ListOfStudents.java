package week2.Task_2;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
public class ListOfStudents
{
    public static List<Student> studList()
    {
        List<Student> studList = new ArrayList<Student>(11);

        studList.add(new Student ("Белик Анна Дмитриевна", 3));
        studList.add(new Student ("Дубровская Татьяна Валерьевна", 1));
        studList.add(new Student ("Иовчева Анастасия Дмитриевна", 5));
        studList.add(new Student ("Кравченко Елена Игоревна", 3));
        studList.add(new Student ("Лисова Александра Дмитриевна", 4));
        studList.add(new Student ("Михайлова Дарья Владимировна", 1));
        studList.add(new Student ("Пискарева Вероника Максимовна", 2));
        studList.add(new Student ("Рудик Наталья Игоревна", 5));
        studList.add(new Student ("Узор Михаил Алексеевич", 4));
        studList.add(new Student ("Фомичева Дарья Владимировна", 1));
        studList.add(new Student ("Шмелев Леонид Алексеевич", 3));
        return studList;
    }
}
