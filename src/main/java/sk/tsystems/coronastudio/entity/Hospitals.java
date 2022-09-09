package sk.tsystems.coronastudio.entity;

import sk.tsystems.coronastudio.entity.Cities;
import sk.tsystems.coronastudio.entity.hospitalBeds.HospitalBeds;
import sk.tsystems.coronastudio.entity.hospitalPatients.HospitalPatients;
import sk.tsystems.coronastudio.entity.hospitalStaff.HospitalStaff;
import sk.tsystems.coronastudio.entity.vaccinations.VaccinationContacts;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Hospitals{

    @Id
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "Cities.id", nullable = false)
    private Cities cities;

    @OneToMany(mappedBy = "id")
    private List<VaccinationContacts> vaccinationContacts;

    @OneToMany(mappedBy = "id")
    private List<HospitalBeds> hospitalBeds;

    @OneToMany(mappedBy = "id")
    private List<HospitalPatients> hospitalPatients;

    @OneToMany(mappedBy = "id")
    private List<HospitalStaff> hospitalStaff;

    public Hospitals(){}

    public Hospitals(long id, String title, String code, Cities cities) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.cities = cities;
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
