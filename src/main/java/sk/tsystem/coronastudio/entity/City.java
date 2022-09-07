package sk.tsystem.coronastudio.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    private long id;


    @Column(nullable = false, length = 128)
    private String City;

    @Column(nullable = false, length = 16)
    private String code;

    @OneToMany(mappedBy = "id")
    private List<Hospital> hospitals;



    @ManyToOne
    @JoinColumn(name = "district.id", nullable = false)
    private District district;

    public City() {

    }

    public City(String city, String code) {
        City = city;
        this.code = code;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
