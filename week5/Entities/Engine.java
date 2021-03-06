package week5.Entities;

import java.util.Set;

/**
 * Created by Pavel
 */
public class Engine
{
    private int id;                     //Primary key (id in db)
    private double displacement;        //Displacement of specific engine (1000 - 3000 cc)
    private double power;               //Engine power (60-280 hp)
    private Set<Car> installedInCars;   //Set of cars that has the current engine


    //Constructor for receiving engines form database
    public Engine(int id, double displacement, double power, Set<Car> installedInCars)
    {
        this.id = id;
        this.displacement = displacement;
        this.power = power;
        this.installedInCars = installedInCars;
    }
    //Constructor for adding engines into database
    public Engine(double displacement, double power)
    {
        this.displacement = displacement;
        this.power = power;
    }

    public Engine(){}

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getDisplacement()
    {
        return displacement;
    }

    public void setDisplacement(double displacement)
    {
        this.displacement = displacement;
    }

    public double getPower()
    {
        return power;
    }

    public void setPower(double power)
    {
        this.power = power;
    }

    public Set<Car> getInstalledInCars()
    {
        return installedInCars;
    }

    public void setInstalledInCars(Set<Car> installedInCars)
    {
        this.installedInCars = installedInCars;
    }

    @Override
    public String toString()
    {
        return "Engine{" +
                "id=" + id +
                ", displacement=" + displacement +
                ", power=" + power +
                '}';
    }
}
