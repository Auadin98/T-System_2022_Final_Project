package sk.tsystems.coronastudio.entity.hospitalPatients;

import sk.tsystems.coronastudio.entity.Regions;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegionHospitalPatients {
    @Id
    private long id;

    private Date oldest_reported_at;

    private Date newest_reported_at;

    private Date published_on;

    @ManyToOne
    @JoinColumn(name = "Regions.id", nullable = false)
    private Regions regions;

    @Column(nullable = false)
    private int ventilated_covid;

    @Column(nullable = false)
    private int non_covid;

    @Column(nullable = false)
    private int confirmed_covid;

    @Column(nullable = false)
    private int suspected_covid;

    private Date updated_at;

    public RegionHospitalPatients(){

    }

    public RegionHospitalPatients(long id, Date oldest_reported_at, Date newest_reported_at, Date published_on, Regions regions, int ventilated_covid, int non_covid, int confirmed_covid, int suspected_covid, Date updated_at) {
        this.id = id;
        this.oldest_reported_at = oldest_reported_at;
        this.newest_reported_at = newest_reported_at;
        this.published_on = published_on;
        this.regions = regions;
        this.ventilated_covid = ventilated_covid;
        this.non_covid = non_covid;
        this.confirmed_covid = confirmed_covid;
        this.suspected_covid = suspected_covid;
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOldest_reported_at() {
        return oldest_reported_at;
    }

    public void setOldest_reported_at(Date oldest_reported_at) {
        this.oldest_reported_at = oldest_reported_at;
    }

    public Date getNewest_reported_at() {
        return newest_reported_at;
    }

    public void setNewest_reported_at(Date newest_reported_at) {
        this.newest_reported_at = newest_reported_at;
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

    public int getVentilated_covid() {
        return ventilated_covid;
    }

    public void setVentilated_covid(int ventilated_covid) {
        this.ventilated_covid = ventilated_covid;
    }

    public int getNon_covid() {
        return non_covid;
    }

    public void setNon_covid(int non_covid) {
        this.non_covid = non_covid;
    }

    public int getConfirmed_covid() {
        return confirmed_covid;
    }

    public void setConfirmed_covid(int confirmed_covid) {
        this.confirmed_covid = confirmed_covid;
    }

    public int getSuspected_covid() {
        return suspected_covid;
    }

    public void setSuspected_covid(int suspected_covid) {
        this.suspected_covid = suspected_covid;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
