package week4.task_2.utills;

/**
 * Created by Pavel
 */
public class CurrencyPrivat
{
    private String ccy; //Base currency
    private String base_ccy; //National currency
    private double buy;
    private double sale;

    public String getCcy()
    {
        return ccy;
    }

    public String getBase_ccy()
    {
        return base_ccy;
    }

    public double getBuy()
    {
        return buy;
    }

    public double getSale()
    {
        return sale;
    }

    @Override
    public String toString()
    {
        return "utills.CurrencyPrivat{" +
                "ccy='" + ccy + '\'' +
                ", base_ccy='" + base_ccy + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}
