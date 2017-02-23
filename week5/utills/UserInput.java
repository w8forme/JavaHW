package week5.utills;

import week5.Car;
import week5.Engine;

/**
 * Created by Pavel
 */
public interface UserInput
{
    Car getCarById(int id);
    Engine getEngineById(int id);
    void insertCar(Car car);
    void insertEngine(Engine engine);
}
