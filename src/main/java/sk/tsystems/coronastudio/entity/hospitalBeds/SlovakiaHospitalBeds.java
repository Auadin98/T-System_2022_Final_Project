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

    public int getCapacity_all() {
        return capacity_all;
    }

    public void setCapacity_all(int capacity_all) {
        this.capacity_all = capacity_all;
    }

    public int getFree_all() {
        return free_all;
    }

    public void setFree_all(int free_all) {
        this.free_all = free_all;
    }

    public int getCapacity_covid() {
        return capacity_covid;
    }

    public void setCapacity_covid(int capacity_covid) {
        this.capacity_covid = capacity_covid;
    }

    public int getOccupied_jis_covid() {
        return occupied_jis_covid;
    }

    public void setOccupied_jis_covid(int occupied_jis_covid) {
        this.occupied_jis_covid = occupied_jis_covid;
    }

    public int getOccupied_oaim_covid() {
        return occupied_oaim_covid;
    }

    public void setOccupied_oaim_covid(int occupied_oaim_covid) {
        this.occupied_oaim_covid = occupied_oaim_covid;
    }

    public int getOccupied_o2_covid() {
        return occupied_o2_covid;
    }

    public void setOccupied_o2_covid(int occupied_o2_covid) {
        this.occupied_o2_covid = occupied_o2_covid;
    }

    public int getOccupied_other_covid() {
        return occupied_other_covid;
    }

    public void setOccupied_other_covid(int occupied_other_covid) {
        this.occupied_other_covid = occupied_other_covid;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
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
