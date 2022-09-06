package sk.tsystems.coronastudio.entity;

import sk.tsystems.coronastudio.entity.hospitalBeds.DistrictHospitalBeds;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Districts implements Serializable {

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "Regions.ident", nullable = false)
    private Regions regions;

    @OneToMany(mappedBy = "ident")
    private List<Cities> cities;

    @OneToMany(mappedBy = "ident")
    private List<DistrictHospitalBeds> districtHospitalBeds;

    public Districts(){}

    public Districts(String title, String code) {
        this.title = title;
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
