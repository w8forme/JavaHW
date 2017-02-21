package week4.task_2.test.java.utills;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import week4.task_2.utills.UserInput;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by Pavel
 */
public class UserInputTest
{

    private UserInput u;

    @Before
    public void setUp() throws Exception
    {
        u = new UserInput();
    }


    @Test
    public void userInput() throws Exception
    {
        String input = "usd";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); //Simulate user input from console
        assertEquals("USD", u.userInput());
    }

    @After
    public void tearDown() throws Exception
    {
        u = null;
    }
}