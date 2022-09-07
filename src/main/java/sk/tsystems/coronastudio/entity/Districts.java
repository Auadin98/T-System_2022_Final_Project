package sk.tsystems.coronastudio.entity;

import sk.tsystems.coronastudio.entity.hospitalBeds.DistrictHospitalBeds;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Districts implements Serializable {

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

    public Districts(){}

    public Districts(long id, String title, String code, Regions regions) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.regions = regions;
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
