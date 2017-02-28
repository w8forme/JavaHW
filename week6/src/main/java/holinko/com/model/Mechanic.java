package holinko.com.model;

import javax.persistence.*;

/**
 * Created by Pavel
 */
@Entity
@Table(name = "mechanic")
public class Mechanic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_station_id")
    private ServiceStation serviceStation;

    public Mechanic()
    {
    }

    public Mechanic(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public ServiceStation getServiceStation()
    {
        return serviceStation;
    }

    public void setServiceStation(ServiceStation serviceStation)
    {
        this.serviceStation = serviceStation;
    }

    @Override
    public String toString()
    {
        return "Mechanic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", serviceStation=" + serviceStation +
                '}';
    }
}
