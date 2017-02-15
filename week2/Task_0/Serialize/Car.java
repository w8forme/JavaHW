package week2.Task_0.Serialize;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Pavel
 */
public class Car implements Serializable
{
    private int passengers;
    private String color;
    private int[] parts = {1, 15, 25, 16 , 7, 54, 65};
    private transient Wheels w;

    public Car(int passengers, String color)
    {
        this.passengers = passengers;
        this.color = color;
        this.w = new Wheels();
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "passengers=" + passengers +
                ", color='" + color + '\'' +
                ", parts=" + Arrays.toString(parts) +
                ", w=" + w +
                '}';
    }

    public int getPassengers()
    {
        return passengers;
    }

    public void setPassengers(int passengers)
    {
        this.passengers = passengers;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }
}
