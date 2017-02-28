package holinko.com.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
@Entity
@Table(name = "car")
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "id_engine")
    private Integer id_engine;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "date")
    private String date;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "car_service_station", joinColumns = {
            @JoinColumn(name = "car_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "service_station_id", nullable = false, updatable = false)})
    private Set<ServiceStation> serviceStationSet = new HashSet<>();

    public Car(){}

    public Car(String make, String model, Integer id_engine, BigDecimal price, String date)
    {
        this.make = make;
        this.model = model;
        this.id_engine = id_engine;
        this.price = price;
        this.date = date;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public Integer getId_engine()
    {
        return id_engine;
    }

    public void setId_engine(Integer id_engine)
    {
        this.id_engine = id_engine;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public Set<ServiceStation> getServiceStationSet()
    {
        return serviceStationSet;
    }

    public void setServiceStationSet(Set<ServiceStation> serviceStationSet)
    {
        this.serviceStationSet = serviceStationSet;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", id_engine=" + id_engine +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
