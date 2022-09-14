package sk.tsystems.coronastudio.entity;

import sk.tsystems.coronastudio.entity.agTests.RegionAgTests;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;
import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;
import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;

import javax.persistence.*;
import java.util.List;

@Entity
public class Regions{

    @Id
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String Abbreviation;

    @OneToMany(mappedBy = "id")
    private List<Districts> districts;

    @OneToMany(mappedBy = "id")
    private List<Vaccinations> vaccinations;

    @OneToMany(mappedBy = "id")
    private List<RegionVaccinations> regionVaccinations;

    @OneToMany(mappedBy = "id")
    private List<RegionHospitalBeds> regionHospitalBeds;

    @OneToMany(mappedBy = "id")
    private List<RegionAgTests> regionAgTests;

    public Regions(){}

    public Regions(long id, String title, String code, String abbreviation) {
        this.id = id;
        this.title = title;
        this.code = code;
        Abbreviation = abbreviation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAbbreviation() {
        return Abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
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
