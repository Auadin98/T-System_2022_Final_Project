package sk.tsystem.coronastudio.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vaccines {
    @Id
    @GeneratedValue
    private long ident;
    @Column(name="Title", nullable = false, length = 128, unique = true)
    private String title;
    @Column(name = "Manufacturer", nullable = false)
    private String manufacturer;

    @OneToMany(mappedBy = "ident")
    private List<Vaccinations> vaccinations;

    public Vaccines() {
    }

    public Vaccines(String title, String manufacturer) {
        this.title = title;
        this.manufacturer = manufacturer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
