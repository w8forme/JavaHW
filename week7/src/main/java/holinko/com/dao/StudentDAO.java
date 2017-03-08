package holinko.com.dao;

import holinko.com.model.Student;
import java.util.List;

/**
 * Created by Pavel
 */
public interface StudentDAO
{
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long student_id);
    Student getStudentById(Long student_id);
    List<Student> getAllStudents();
}
