package sk.tsystems.coronastudio.entity;

import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Vaccines implements Serializable {

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String manufacturer;

    @OneToMany(mappedBy = "ident")
    private List<Vaccinations> vaccinations;

    public Vaccines(){}
    public Vaccines(String title, String manufacturer) {
        this.title = title;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Vaccines{" +
                "title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
