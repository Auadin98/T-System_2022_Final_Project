package entity.vaccinations;

import entity.Regions;
import entity.Vaccines;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Vaccinations implements Serializable {

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private int dose1_count;

    @Column(nullable = false)
    private int dose2_count;

    private Date updated_at;

    private Date published_on;

    @ManyToOne
    @JoinColumn(name = "Vaccines.ident", nullable = false)
    private Vaccines vaccines;

    @ManyToOne
    @JoinColumn(name = "Regions.ident", nullable = false)
    private Regions regions;

    public Vaccinations(){}

    public Vaccinations(int dose1_count, int dose2_count, Date updated_at, Date published_on) {
        this.dose1_count = dose1_count;
        this.dose2_count = dose2_count;
        this.updated_at = updated_at;
        this.published_on = published_on;
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

    @Override
    public String toString() {
        return "Vaccinations{" +
                "dose1_count=" + dose1_count +
                ", dose2_count=" + dose2_count +
                ", updated_at=" + updated_at +
                ", published_on=" + published_on +
                ", vaccines=" + vaccines +
                ", regions=" + regions +
                '}';
    }
}
