package coronastudio.entity.hospitalPatients;

import sk.tsystems.coronastudio.entity.Hospitals;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalPatients {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "Hospitals.id", nullable = false)
    private Hospitals hospitals;

    private Date reported_at;

    @Column(nullable = false)
    private int ventilated_covid;

    @Column(nullable = false)
    private int non_covid;

    @Column(nullable = false)
    private int confirmed_covid;

    @Column(nullable = false)
    private int suspected_covid;

    private Date updated_at;

    private Date published_on;

    public HospitalPatients(){}

    public HospitalPatients(long id, Hospitals hospitals, Date reported_at, int ventilated_covid, int non_covid,
                            int confirmed_covid, int suspected_covid, Date updated_at, Date published_on) {
        this.id = id;
        this.hospitals = hospitals;
        this.reported_at = reported_at;
        this.ventilated_covid = ventilated_covid;
        this.non_covid = non_covid;
        this.confirmed_covid = confirmed_covid;
        this.suspected_covid = suspected_covid;
        this.updated_at = updated_at;
        this.published_on = published_on;
    }

    @Override
    public String toString() {
        return "HospitalPatients{" +
                "hospitals=" + hospitals +
                ", reported_at=" + reported_at +
                ", ventilated_covid=" + ventilated_covid +
                ", non_covid=" + non_covid +
                ", confirmed_covid=" + confirmed_covid +
                ", suspected_covid=" + suspected_covid +
                ", updated_at=" + updated_at +
                ", published_on=" + published_on +
                '}';
    }
}
