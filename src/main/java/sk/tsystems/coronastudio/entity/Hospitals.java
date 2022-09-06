package sk.tsystems.coronastudio.entity;

import sk.tsystems.coronastudio.entity.Cities;
import sk.tsystems.coronastudio.entity.hospitalBeds.HospitalBeds;
import sk.tsystems.coronastudio.entity.vaccinations.VaccinationContacts;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Hospitals implements Serializable{

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "Cities.ident", nullable = false)
    private Cities cities;

    @OneToMany(mappedBy = "ident")
    private List<VaccinationContacts> vaccinationContacts;

    @OneToMany(mappedBy = "ident")
    private List<HospitalBeds> hospitalBeds;

    public Hospitals(){}

    public Hospitals(String title, String code) {
        this.title = title;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Hospitals{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", cities=" + cities +
                '}';
    }
}
