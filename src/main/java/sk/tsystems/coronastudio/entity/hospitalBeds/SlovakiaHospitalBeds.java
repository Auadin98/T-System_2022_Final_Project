package sk.tsystems.coronastudio.entity.hospitalBeds;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SlovakiaHospitalBeds implements Serializable {
    @Id
    private long id;

    private Date oldest_reported_at;

    private Date newest_reported_at;

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

    private Date updated_at;

    public SlovakiaHospitalBeds(){}

    public SlovakiaHospitalBeds(long id, Date oldest_reported_at, Date newest_reported_at, Date published_on,
                                int capacity_all, int free_all, int capacity_covid, int occupied_jis_covid,
                                int occupied_oaim_covid, int occupied_o2_covid, int occupied_other_covid, Date updated_at) {
        this.id = id;
        this.oldest_reported_at = oldest_reported_at;
        this.newest_reported_at = newest_reported_at;
        this.published_on = published_on;
        this.capacity_all = capacity_all;
        this.free_all = free_all;
        this.capacity_covid = capacity_covid;
        this.occupied_jis_covid = occupied_jis_covid;
        this.occupied_oaim_covid = occupied_oaim_covid;
        this.occupied_o2_covid = occupied_o2_covid;
        this.occupied_other_covid = occupied_other_covid;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "SlovakiaHospitalBeds{" +
                "oldest_reported_at=" + oldest_reported_at +
                ", newest_reported_at=" + newest_reported_at +
                ", published_on=" + published_on +
                ", capacity_all=" + capacity_all +
                ", free_all=" + free_all +
                ", capacity_covid=" + capacity_covid +
                ", occupied_jis_covid=" + occupied_jis_covid +
                ", occupied_oaim_covid=" + occupied_oaim_covid +
                ", occupied_o2_covid=" + occupied_o2_covid +
                ", occupied_other_covid=" + occupied_other_covid +
                ", updated_at=" + updated_at +
                '}';
    }
}
