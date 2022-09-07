package sk.tsystem.coronastudio.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalStaff {
    @Id
    @GeneratedValue
    private long ident;
    @ManyToOne
    @JoinColumn(name = "Hospitals.ident", nullable = false)
    private Hospitals hospitals;

    private Date reportedAt;
    private float outOfWorkRatioDoctor;
    private float outOfWorkRatioNurse;
    private float outOfWorkRatioOther;
    private Date updatedAt;
    private Date publishedOn;

    /**
     * Constructors
     */
    public HospitalStaff() {
    }

    public HospitalStaff(Hospitals hospitals, Date reportedAt, float outOfWorkRatioDoctor, float outOfWorkRatioNurse, float outOfWorkRatioOther, Date updatedAt, Date publishedOn) {
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

    public float getOutOfWorkRatioDoctor() {
        return outOfWorkRatioDoctor;
    }

    public void setOutOfWorkRatioDoctor(float outOfWorkRatioDoctor) {
        this.outOfWorkRatioDoctor = outOfWorkRatioDoctor;
    }

    public float getOutOfWorkRatioNurse() {
        return outOfWorkRatioNurse;
    }

    public void setOutOfWorkRatioNurse(float outOfWorkRatioNurse) {
        this.outOfWorkRatioNurse = outOfWorkRatioNurse;
    }

    public float getOutOfWorkRatioOther() {
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
