package week5;

import java.io.*;
import java.util.*;

/**
 * Created by Pavel
 */
public class ReadFromFile
{
    private int year;           //The year of production
    private String make;        //Maker of the car
    private String model;       //Model name
    private double price;       //The price of the car
    private int id_engine;      //Engine installed into the car

    private int randomInt(int min, int max)
    {
        return (int) (Math.random() * (++max - min)) + min;
    }

    public Set<Car> parsAndCreateCar()
    {
        Set<Car> cars = new LinkedHashSet<Car>();
        Car car;
       // String filePath = "cars.txt";
        String filePath2 = "cars2.txt";
        String[] parts;
        try (Scanner scan = new Scanner(new FileReader(filePath2)))
        {
            while (scan.hasNext())
            {
                parts = scan.nextLine().split(", ");
                year = Integer.parseInt(parts[0]);
                make = parts[1];
                model = parts[2];
                price = Integer.parseInt(parts[3]);
                id_engine = randomInt(1, 300);
                car = new Car(year, make, model, price, id_engine);
                cars.add(car);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return cars;
    }



}
