package sk.tsystem.coronastudio.entity;

import sk.tsystem.coronastudio.entity.timeentity.DistrictHospitalBeds;

import javax.persistence.*;
import java.util.List;
@Entity
public class District {

    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false, length = 128)
    private String district;

    @Column(nullable = false, length = 16)
    private String code;

    @OneToMany(mappedBy = "id")
    private List<Hospital> hospital;

    @OneToMany(mappedBy = "id")
    private List<DistrictHospitalBeds> districtHospitalBeds;

    @ManyToOne
    @JoinColumn(name="region.id", nullable = false)
    private Region region;


    public District(){

    }
    public District(String district, String code) {
        this.district = district;
        this.code = code;
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
