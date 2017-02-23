package week5;

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
    private Engine engine;      //Engine installed into the car
    private int id_engine;      //Field for adding cars into database

    public Car(int id, int year, String make, String model, double price, Engine engine)
    {
        this.id = id;
        this.model = model;
        this.make = make;
        this.engine = engine;
        this.price = price;
        this.year = year;
    }

    public Car()   {   }

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

    public Engine getEngine()
    {
        return engine;
    }

    public void setEngine(Engine engine)
    {
        this.engine = engine;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "id=" + id +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", engine=" + engine +
                '}';
    }
}
