package week5;
import java.sql.Timestamp;

/**
 * Created by Pavel
 */
public class Car
{
    private int id;             //Primary key
    private int year;           //The year of production
    private String make;        //Maker of the car
    private String model;       //Model name
    private double price;       //The price of the car
    private int id_engine;      //Engine installed into the car

    public Car(int id, int year, String make, String model, double price, int id_engine)
    {
        this.id = id;
        this.model = model;
        this.make = make;
        this.id_engine = id_engine;
        this.price = price;
        this.year = year;
    }

    public Car(int year, String make, String model, double price, int id_engine)
    {
        this.model = model;
        this.make = make;
        this.id_engine = id_engine;
        this.price = price;
        this.year = year;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public int getId_engine()
    {
        return id_engine;
    }

    public void setId_engine(int id_engine)
    {
        this.id_engine = id_engine;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }
}
