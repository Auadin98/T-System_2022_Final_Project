package sk.tsystems.coronastudio.entity.vaccinations;

import sk.tsystems.coronastudio.entity.Regions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RegionVaccinations implements Serializable {

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private int dose1_count;

    @Column(nullable = false)
    private int dose2_count;

    @Column(nullable = false)
    private int dose1_sum;

    @Column(nullable = false)
    private int dose2_sum;

    private Date updated_at;

    private Date published_on;

    @ManyToOne
    @JoinColumn(name = "Regions.ident", nullable = false)
    private Regions regions;

    public RegionVaccinations(){}

    public RegionVaccinations(int dose1_count, int dose2_count, int dose1_sum, int dose2_sum,
                              Date updated_at, Date published_on) {
        this.dose1_count = dose1_count;
        this.dose2_count = dose2_count;
        this.dose1_sum = dose1_sum;
        this.dose2_sum = dose2_sum;
        this.updated_at = updated_at;
        this.published_on = published_on;
    }

    public long getIdent() {
        return ident;
    }

    public void setIdent(long ident) {
        this.ident = ident;
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

    public int getDose1_sum() {
        return dose1_sum;
    }

    public void setDose1_sum(int dose1_sum) {
        this.dose1_sum = dose1_sum;
    }

    public int getDose2_sum() {
        return dose2_sum;
    }

    public void setDose2_sum(int dose2_sum) {
        this.dose2_sum = dose2_sum;
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
