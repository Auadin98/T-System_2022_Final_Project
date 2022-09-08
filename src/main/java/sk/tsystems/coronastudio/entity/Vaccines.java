package sk.tsystems.coronastudio.entity;

import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Vaccines implements Serializable {

    @Id
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String manufacturer;

    @OneToMany(mappedBy = "id")
    private List<Vaccinations> vaccinations;

    public Vaccines(){}

    public Vaccines(long id, String title, String manufacturer) {
        this.id = id;
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
