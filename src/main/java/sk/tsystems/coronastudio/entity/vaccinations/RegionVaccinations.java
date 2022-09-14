package sk.tsystems.coronastudio.entity.vaccinations;

import sk.tsystems.coronastudio.entity.Regions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RegionVaccinations implements Serializable {

    @Id
    private long id;

    @Column(nullable = false)
    private int dose1_count;

    @Column(nullable = false)
    private int dose2_count;

    @Column(nullable = false)
    private long dose1_sum;

    @Column(nullable = false)
    private long dose2_sum;

    private Date updated_at;

    private Date published_on;

    @ManyToOne
    @JoinColumn(name = "Regions.id", nullable = false)
    private Regions regions;

    public RegionVaccinations(){}

    public RegionVaccinations(long id, int dose1_count, int dose2_count, long dose1_sum, long dose2_sum, Date updated_at, Date published_on, Regions regions) {
        this.id = id;
        this.dose1_count = dose1_count;
        this.dose2_count = dose2_count;
        this.dose1_sum = dose1_sum;
        this.dose2_sum = dose2_sum;
        this.updated_at = updated_at;
        this.published_on = published_on;
        this.regions = regions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDose1_count() {
        return dose1_count;
    }

    public void setDose1_count(int dose1_count) {
        this.dose1_count = dose1_count;
    }

    public int getDose2_count() {
        return dose2_count;
    }

    public void setDose2_count(int dose2_count) {
        this.dose2_count = dose2_count;
    }

    public long getDose1_sum() {
        return dose1_sum;
    }

    public void setDose1_sum(long dose1_sum) {
        this.dose1_sum = dose1_sum;
    }

    public long getDose2_sum() {
        return dose2_sum;
    }

    public void setDose2_sum(long dose2_sum) {
        this.dose2_sum = dose2_sum;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getPublished_on() {
        return published_on;
    }

    public void setPublished_on(Date published_on) {
        this.published_on = published_on;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "RegionVaccinations{" +
                "dose1_count=" + dose1_count +
                ", dose2_count=" + dose2_count +
                ", dose1_sum=" + dose1_sum +
                ", dose2_sum=" + dose2_sum +
                ", updated_at=" + updated_at +
                ", published_on=" + published_on +
                ", regions=" + regions +
                '}';
    }
}
