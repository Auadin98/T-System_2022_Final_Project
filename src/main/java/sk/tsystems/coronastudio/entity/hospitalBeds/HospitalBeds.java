package sk.tsystems.coronastudio.entity.hospitalBeds;

import sk.tsystems.coronastudio.entity.Hospitals;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class HospitalBeds implements Serializable {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "Hospitals.id", nullable = false)
    private Hospitals hospitals;

    private Date reported_at;

    private Date updated_at;

    private Date published_on;

    @Column(nullable = false)
    private int capacity_all;

    @Column(nullable = false)
    private int free_all;

    @Column(nullable = false)
    private int capacity_covid;

    @Column(nullable = false)
    private int occupied_jis_covid;

    @Column(nullable = false)
    private int occupied_oaim_covid;

    @Column(nullable = false)
    private int occupied_o2_covid;

    @Column(nullable = false)
    private int occupied_other_covid;

    public HospitalBeds(){}

    public HospitalBeds(long id, Hospitals hospitals, Date reported_at, Date updated_at, Date published_on,
                        int capacity_all, int free_all, int capacity_covid, int occupied_jis_covid, int occupied_oaim_covid,
                        int occupied_o2_covid, int occupied_other_covid) {
        this.id = id;
        this.hospitals = hospitals;
        this.reported_at = reported_at;
        this.updated_at = updated_at;
        this.published_on = published_on;
        this.capacity_all = capacity_all;
        this.free_all = free_all;
        this.capacity_covid = capacity_covid;
        this.occupied_jis_covid = occupied_jis_covid;
        this.occupied_oaim_covid = occupied_oaim_covid;
        this.occupied_o2_covid = occupied_o2_covid;
        this.occupied_other_covid = occupied_other_covid;
    }

    @Override
    public String toString() {
        return "HospitalBeds{" +
                "hospitals=" + hospitals +
                ", reported_at=" + reported_at +
                ", updated_at=" + updated_at +
                ", published_on=" + published_on +
                ", capacity_all=" + capacity_all +
                ", free_all=" + free_all +
                ", capacity_covid=" + capacity_covid +
                ", occupied_jis_covid=" + occupied_jis_covid +
                ", occupied_oaim_covid=" + occupied_oaim_covid +
                ", occupied_o2_covid=" + occupied_o2_covid +
                ", occupied_other_covid=" + occupied_other_covid +
                '}';
    }
}
