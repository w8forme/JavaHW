package week3.Task_2;

/**
 * Created by Pavel
 */
public class Apple
{
    private String appleName; //Sort of apple
    private int appleQuantity; //How many apples of this sort

    @Override
    public String toString()
    {
        return appleName + appleQuantity;

    }

    public Apple(String appleName, int appleQuantity)
    {
        this.appleName = appleName;
        this.appleQuantity = appleQuantity;
    }

    public String getAppleName()
    {
        return appleName;
    }

    public void setAppleName(String appleName)
    {
        this.appleName = appleName;
    }

    public int getAppleQuantity()
    {
        return appleQuantity;
    }

    public void setAppleQuantity(int appleQuantity)
    {
        this.appleQuantity = appleQuantity;
    }
}
