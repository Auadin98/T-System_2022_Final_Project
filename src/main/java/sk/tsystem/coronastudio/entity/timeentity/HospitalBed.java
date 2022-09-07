package sk.tsystem.coronastudio.entity.timeentity;

import sk.tsystem.coronastudio.entity.Hospital;

import javax.persistence.*;
import java.util.Date;

public class HospitalBed {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "hospital.id", nullable = false)
    private Hospital hospital;

    @Column(length = 128)
    private Date reported_at;

    @Column(length = 128)
    private Date updated_at;

    @Column(length = 128)
    private Date published_on;



    @Column(length = 128)
    private int capacity_all;

    @Column(length = 128)
    private int free_all;

    @Column(length = 128)
    private int capacity_covid;

    @Column(length = 128)
    private int occupied_jis_covid;

    @Column(length = 128)
    private int occupied_oaim_covid;

    @Column(length = 128)
    private  int occupied_o2_covid;

    @Column(length = 128)
    private int occupied_other_covid;

    public HospitalBed(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getReported_at() {
        return reported_at;
    }

    public void setReported_at(Date reported_at) {
        this.reported_at = reported_at;
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

    public HospitalBed(long id, Date reported_at, Date updated_at, Date published_on, int capacity_all, int free_all, int capacity_covid, int occupied_jis_covid, int occupied_oaim_covid, int occupied_o2_covid, int occupied_other_covid) {
        this.id = id;
        this.reported_at = reported_at;
        this.updated_at = updated_at;
        this.published_on = published_on;
        this.capacity_all = capacity_all;
        this.free_all = free_all;
        this.capacity_covid = capacity_covid;
        this.occupied_jis_covid = occupied_jis_covid;
        this.occupied_oaim_covid = occupied_oaim_covid;
        this.occupied_o2_covid = occupied_o2_covid;
        this.occupied_other_covid = occupied_other_covid;
    }
}
