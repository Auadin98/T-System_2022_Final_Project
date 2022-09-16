package sk.tsystems.coronastudio.entity.vaccinations;

import sk.tsystems.coronastudio.entity.Regions;
import sk.tsystems.coronastudio.entity.Vaccines;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Vaccinations implements Serializable {

    @Id
    private String id;

    @Column(nullable = false)
    private int dose1_count;

    @Column(nullable = false)
    private int dose2_count;

    private Date updated_at;

    private Date published_on;

    @ManyToOne
    @JoinColumn(name = "Vaccines.id", nullable = false)
    private Vaccines vaccines;

    @ManyToOne
    @JoinColumn(name = "Regions.id", nullable = false)
    private Regions regions;

    public Vaccinations(){}

    public Vaccinations(String id, int dose1_count, int dose2_count, Date updated_at, Date published_on,
                        Vaccines vaccines, Regions regions) {
        this.id = id;
        this.dose1_count = dose1_count;
        this.dose2_count = dose2_count;
        this.updated_at = updated_at;
        this.published_on = published_on;
        this.vaccines = vaccines;
        this.regions = regions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Vaccines getVaccines() {
        return vaccines;
    }

    public void setVaccines(Vaccines vaccines) {
        this.vaccines = vaccines;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
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
