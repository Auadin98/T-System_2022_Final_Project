package sk.tsystem.coronastudio.entity.timeentity;

import sk.tsystem.coronastudio.entity.Region;

import javax.persistence.*;

import java.util.Date;

@Entity
public class RegionHospitalBed {
    @Column(length = 128)
    private Date oldest_reported_at;

    @Column(length = 128)
    private Date newest_reported_at;

    @Column(length = 128)
    private Date published_on;

    @ManyToOne
    @JoinColumn(name = "region.id", nullable = false)
    private Region region;

    @Id
    private long id;

    @Column(length = 128)
    private int capacity_all;

    @Column(length = 128)
    private int free_all;

    @Column(length = 128)
    private int capacity_covid;

    @Column(length = 128)
    private int occupied_jis_covid;

    @Column(length = 128)
    private int occupied_oaim_covid;

    @Column(length = 128)
    private  int occupied_o2_covid;

    @Column(length = 128)
    private int occupied_other_covid;

    @Column(length = 128)
    private Date updated_at;

}
