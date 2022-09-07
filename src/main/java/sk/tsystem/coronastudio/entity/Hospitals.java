package sk.tsystem.coronastudio.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hospitals {
    @Id
    @GeneratedValue
    private long ident;

    @ManyToOne
    @JoinColumn(name = "Cities.ident", nullable = false)
    private Cities cities;

    @Column(name="Title", nullable = false, length = 128, unique = true)
    private String title;
    @Column(name = "Code", nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "ident")
    private List<HospitalBeds> hospitalBeds;
    @OneToMany(mappedBy = "ident")
    private List<HospitalPatients> hospitalPatients;
    @OneToMany(mappedBy = "ident")
    private List<Hospitals> hospitals;
    @OneToMany(mappedBy = "ident")
    private List<VaccinationContacts> vaccinationContacts;

    public Hospitals() {
    }

    public Hospitals(Cities cities, String title, String code) {
        this.cities = cities;
        this.title = title;
        this.code = code;
    }

    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
