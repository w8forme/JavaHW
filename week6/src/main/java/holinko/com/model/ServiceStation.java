package holinko.com.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
@Entity
@Table(name = "service_stations")
public class ServiceStation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "address")
    private String address;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "serviceStationSet")
    private Set<Car> carSet = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "serviceStation")
    private Set<Mechanic> mechanicSet = new HashSet<>();

    public ServiceStation()
    {
    }

    public ServiceStation(String address)
    {
        this.address = address;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Set<Car> getCarSet()
    {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet)
    {
        this.carSet = carSet;
    }

    public Set<Mechanic> getMechanicSet()
    {
        return mechanicSet;
    }

    public void setMechanicSet(Set<Mechanic> mechanicSet)
    {
        this.mechanicSet = mechanicSet;
    }

    @Override
    public String toString()
    {
        return "ServiceStation{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
