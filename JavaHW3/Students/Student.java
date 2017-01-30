package JavaHW3.Students;

/**
 * Created by Home on 30.01.2017.
 */
public class Student
{
    private String name;
    private int course;

    @Override
    public String toString()
    {
        return "ФИО студента: " + name + ", " + course + " курс.";
    }

    public Student(String name, int course)
    {
        this.name = name;
        this.course = course;
    }

    public String getName()
    {
        return name;
    }

    public int getCourse()
    {
        return course;
    }
}
