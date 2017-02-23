package week5;

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
}
