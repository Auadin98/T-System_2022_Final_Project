package coronastudio.entity.hospitalPatients;

import sk.tsystems.coronastudio.entity.Districts;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DistrictHospitalPatients {
    @Id
    private long id;

    private Date oldest_reported_at;

    private Date newest_reported_at;

    private Date published_on;

    @ManyToOne
    @JoinColumn(name = "Districts.id", nullable = false)
    private Districts districts;

    @Column(nullable = false)
    private int ventilated_covid;

    @Column(nullable = false)
    private int non_covid;

    @Column(nullable = false)
    private int confirmed_covid;

    @Column(nullable = false)
    private int suspected_covid;

    private Date updated_at;

    public DistrictHospitalPatients(){}

    public DistrictHospitalPatients(long id, Date oldest_reported_at, Date newest_reported_at, Date published_on,
                                    Districts districts, int ventilated_covid, int non_covid, int confirmed_covid,
                                    int suspected_covid, Date updated_at) {
        this.id = id;
        this.oldest_reported_at = oldest_reported_at;
        this.newest_reported_at = newest_reported_at;
        this.published_on = published_on;
        this.districts = districts;
        this.ventilated_covid = ventilated_covid;
        this.non_covid = non_covid;
        this.confirmed_covid = confirmed_covid;
        this.suspected_covid = suspected_covid;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "DistrictHospitalPatients{" +
                "oldest_reported_at=" + oldest_reported_at +
                ", newest_reported_at=" + newest_reported_at +
                ", published_on=" + published_on +
                ", districts=" + districts +
                ", ventilated_covid=" + ventilated_covid +
                ", non_covid=" + non_covid +
                ", confirmed_covid=" + confirmed_covid +
                ", suspected_covid=" + suspected_covid +
                ", updated_at=" + updated_at +
                '}';
    }
}
