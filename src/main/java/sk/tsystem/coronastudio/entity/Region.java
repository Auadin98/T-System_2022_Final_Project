package sk.tsystem.coronastudio.entity;

import sk.tsystem.coronastudio.entity.timeentity.RegionHospitalBed;

import javax.persistence.*;
import java.util.List;

@Entity
public class Region {
    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false, length = 128)
    private String Region;

    @Column(nullable = false, length = 5)
    private String code;

    @Column(nullable = false, length = 128)
    private String abbreviation;

    @OneToMany(mappedBy = "id")
    private List<RegionHospitalBed> regionHospitalBeds;

    @OneToMany(mappedBy = "id")
    private List<District> districts;

    public Region(){

    }

    public Region(long id, String region, String code, String abbreviation) {
        this.id = id;
        Region = region;
        this.code = code;
        this.abbreviation = abbreviation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
