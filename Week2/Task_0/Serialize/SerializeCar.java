package Week2.Task_0.Serialize;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Pavel
 */
public class SerializeCar
{

    public void serialize(Car c)
    {
        try (FileOutputStream fos = new FileOutputStream("car.out");
             ObjectOutputStream oos = new ObjectOutputStream(fos);)
        {
            oos.writeObject(c);
            oos.flush();
            System.out.println("Запись произведена!");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Car deserialize() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream("car.out");
        ObjectInputStream oin = new ObjectInputStream(fis);

        return (Car) oin.readObject();
    }

    public static void main(String[] args)
    {
        SerializeCar sc = new SerializeCar();
        Car car = new Car(4, "red");

        try
        {
            sc.serialize(car);
            System.out.println(sc.deserialize());
        }
        catch (IOException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}



