package week4.task_1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pavel
 */
public class CalculatorTest
{
    private Calculator c;



    @Before
    public void setUp() throws Exception
    {
        c = new Calculator();
    }

    @Test
    public void add() throws Exception
    {
        assertEquals(10.0, c.add(5.0, 5.0), 0.0);
    }

    @Test
    public void minus() throws Exception
    {
        assertEquals(10.0, c.minus(20.0, 10.0), 0.0);
    }

    @Test
    public void divide() throws Exception
    {
        assertEquals(2, c.divide(12, 6), 0.00001);
    }

    @Test
    public void multiply() throws Exception
    {
        assertEquals(25.0, c.multiply(5.0, 5.0), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideEx() throws Exception
    {
        c.divide(5, 0);
    }
}