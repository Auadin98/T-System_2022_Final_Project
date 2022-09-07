package sk.tsystem.coronastudio.entity;

import sk.tsystem.coronastudio.entity.timeentity.DistrictHospitalBed;

import javax.persistence.*;
import java.util.List;
@Entity
public class District {

    @Id
    private long id;


    @Column(nullable = false, length = 128)
    private String district;

    @Column(nullable = false, length = 16)
    private String code;

    @OneToMany(mappedBy = "id")
    private List<Hospital> hospital;

    @OneToMany(mappedBy = "id")
    private List<DistrictHospitalBed> districtHospitalBeds;

    @ManyToOne
    @JoinColumn(name="region.id", nullable = false)
    private Region region;


    public District(){

    }

    public District(long id, String district, String code, Region region) {
        this.id = id;
        this.district = district;
        this.code = code;
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
