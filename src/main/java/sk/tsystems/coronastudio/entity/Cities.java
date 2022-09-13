package sk.tsystems.coronastudio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cities{

    @Id
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "Districts.id", nullable = false)
    private Districts districts;

    @OneToMany(mappedBy = "id")
    private List<Hospitals> hospitals;

    public Cities(){}

    public Cities(int id, String title, String code, Districts districts) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.districts = districts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Districts getDistricts() {
        return districts;
    }

    public void setDistricts(Districts districts) {
        this.districts = districts;
    }

    public List<Hospitals> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospitals> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", districts=" + districts +
                '}';
    }
}
