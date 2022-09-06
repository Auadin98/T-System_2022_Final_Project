package sk.tsystem.coronastudio.entity;

import sk.tsystem.coronastudio.entity.timeentity.RegionHospitalBed;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hospital {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 128)
    private String hospital;

    @Column(nullable = false, length = 16)
    private String code;

    @OneToMany(mappedBy = "id")
    private List<RegionHospitalBed> regionHospitalBeds;
    @ManyToOne
    @JoinColumn(name="City.id", nullable = false)
    private City city;


    public Hospital(String hospital, String code) {
        this.hospital = hospital;
        this.code = code;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
