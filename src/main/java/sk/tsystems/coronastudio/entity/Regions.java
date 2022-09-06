package sk.tsystems.coronastudio.entity;

import sk.tsystems.coronastudio.entity.Districts;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;
import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;
import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Regions implements Serializable {

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String Abbreviation;

    @OneToMany(mappedBy = "ident")
    private List<Districts> districts;

    @OneToMany(mappedBy = "ident")
    private List<Vaccinations> vaccinations;

    @OneToMany(mappedBy = "ident")
    private List<RegionVaccinations> regionVaccinations;

    @OneToMany(mappedBy = "ident")
    private List<RegionHospitalBeds> regionHospitalBeds;

    public Regions(){}

    public Regions(String title, String code, String abbreviation) {
        this.title = title;
        this.code = code;
        Abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", Abbreviation='" + Abbreviation + '\'' +
                '}';
    }
}
