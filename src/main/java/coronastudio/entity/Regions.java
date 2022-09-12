package coronastudio.entity;

import sk.tsystems.coronastudio.entity.agTests.RegionAgTests;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;
import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;
import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @Override
    public String toString() {
        return "Regions{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", Abbreviation='" + Abbreviation + '\'' +
                '}';
    }
}
