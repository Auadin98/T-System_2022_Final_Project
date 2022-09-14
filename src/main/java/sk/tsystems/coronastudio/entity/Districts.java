package sk.tsystems.coronastudio.entity;

import sk.tsystems.coronastudio.entity.agTests.DistrictAgTests;
import sk.tsystems.coronastudio.entity.hospitalBeds.DistrictHospitalBeds;
import sk.tsystems.coronastudio.entity.hospitalPatients.DistrictHospitalPatients;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Districts{

    @Id
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "Regions.id", nullable = false)
    private Regions regions;

    @OneToMany(mappedBy = "id")
    private List<Cities> cities;

    @OneToMany(mappedBy = "id")
    private List<DistrictHospitalBeds> districtHospitalBeds;

    @OneToMany(mappedBy = "id")
    private List<DistrictHospitalPatients> districtHospitalPatients;

    @OneToMany(mappedBy = "id")
    private List<DistrictAgTests> districtAgTests;

    public Districts(){}

    public Districts(long id, String title, String code, Regions regions) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.regions = regions;
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

    @Override
    public String toString() {
        return "Districts{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", regions=" + regions +
                '}';
    }
}
