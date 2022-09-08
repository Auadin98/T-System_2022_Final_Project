package sk.tsystem.coronastudio.entity;

import sk.tsystem.coronastudio.entity.AgTests.AgTests;

import javax.persistence.*;
import java.util.List;

@Entity
public class Districts {
    @Id
    @GeneratedValue
    private long ident;

    @ManyToOne
    @JoinColumn(name = "Regions.ident", nullable = false)
    private Regions regions;

    @Column(name="Title", nullable = false, length = 128, unique = true)
    private String title;
    @Column(name = "Code", nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "ident")
    private List<AgTests> agTests;
    @OneToMany(mappedBy = "ident")
    private List<Cities> cities;
    @OneToMany(mappedBy = "ident")
    private List<HospitalBeds> hospitalBeds;
    @OneToMany(mappedBy = "ident")
    private List<HospitalPatients> hospitalPatients;



    public Districts() {
    }

    public Districts(Regions regions, String title, String code) {
        this.regions = regions;
        this.title = title;
        this.code = code;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
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
}
