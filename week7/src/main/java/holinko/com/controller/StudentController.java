package holinko.com.controller;

import holinko.com.dao.StudentDAO;
import holinko.com.dao.StudentDAOImpl;
import holinko.com.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Pavel
 */
public class StudentController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Students.jsp";
    private static String lIST_STUDENT = "/studentsList.jsp";
    private StudentDAO dao;

    public StudentController()
    {
        super();
        dao = new StudentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String forward;

        if (action.equalsIgnoreCase("delete"))
        {
            forward = lIST_STUDENT;
            Long studentId = Long.parseLong(req.getParameter("studentId")); //TO DO error
            dao.deleteStudent(studentId);
            req.setAttribute("students", dao.getAllStudents());
        } else if (action.equalsIgnoreCase("edit"))
        {
            forward = INSERT_OR_EDIT;
            Long studentId = Long.parseLong(req.getParameter("studentId")); //error
            Student student = dao.getStudentById(studentId);
            req.setAttribute("student", student);
        } else if (action.equalsIgnoreCase("insert"))
        {
            forward = INSERT_OR_EDIT;
        } else
        {
            forward = lIST_STUDENT;
            req.setAttribute("students", dao.getAllStudents());
        }
        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        String date = req.getParameter("dateOfBirth");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        Student student = new Student();
        student.setName(req.getParameter("name"));
        student.setSurname(req.getParameter("surname"));
        student.setTelephoneNumber(req.getParameter("telephoneNumber"));
        student.setEmail(req.getParameter("email"));
        student.setDateOfBirth(localDate);
        String studentId = req.getParameter("id");

        if (studentId == null || studentId.isEmpty())
            dao.addStudent(student);
        else
        {
            student.setId(Long.parseLong(req.getParameter("id")));
            dao.updateStudent(student);
        }
        RequestDispatcher view = req.getRequestDispatcher(lIST_STUDENT);
        req.setAttribute("students", dao.getAllStudents());
        view.forward(req, resp);
    }
}
