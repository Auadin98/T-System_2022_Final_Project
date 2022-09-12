package coronastudio.entity.hospitalStaff;

import sk.tsystems.coronastudio.entity.Hospitals;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class HospitalStaff {

    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "Hospitals.id", nullable = false)
    private Hospitals hospitals;

    private Date reportedAt;
    private double outOfWorkRatioDoctor;
    private double outOfWorkRatioNurse;
    private double outOfWorkRatioOther;
    private Date updatedAt;
    private Date publishedOn;

    /**
     * Constructors
     */
    public HospitalStaff() {
    }

    public HospitalStaff(long id, Hospitals hospitals, Date reportedAt, double outOfWorkRatioDoctor,
                         double outOfWorkRatioNurse, double outOfWorkRatioOther, Date updatedAt, Date publishedOn) {
        this.id = id;
        this.hospitals = hospitals;
        this.reportedAt = reportedAt;
        this.outOfWorkRatioDoctor = outOfWorkRatioDoctor;
        this.outOfWorkRatioNurse = outOfWorkRatioNurse;
        this.outOfWorkRatioOther = outOfWorkRatioOther;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    /**
     * Getters & Setters
     */
    public Hospitals getHospitals() {
        return hospitals;
    }

    public void setHospitals(Hospitals hospitals) {
        this.hospitals = hospitals;
    }

    public Date getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(Date reportedAt) {
        this.reportedAt = reportedAt;
    }

    public double getOutOfWorkRatioDoctor() {
        return outOfWorkRatioDoctor;
    }

    public void setOutOfWorkRatioDoctor(float outOfWorkRatioDoctor) {
        this.outOfWorkRatioDoctor = outOfWorkRatioDoctor;
    }

    public double getOutOfWorkRatioNurse() {
        return outOfWorkRatioNurse;
    }

    public void setOutOfWorkRatioNurse(float outOfWorkRatioNurse) {
        this.outOfWorkRatioNurse = outOfWorkRatioNurse;
    }

    public double getOutOfWorkRatioOther() {
        return outOfWorkRatioOther;
    }

    public void setOutOfWorkRatioOther(float outOfWorkRatioOther) {
        this.outOfWorkRatioOther = outOfWorkRatioOther;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }
}
