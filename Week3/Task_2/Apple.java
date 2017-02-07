package Week3.Task_2;

/**
 * Created by Pavel
 */
public class Apple
{
    private String appleName;
    private int appleQuantity;

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
