package sk.tsystem.coronastudio.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Cities {
    @Id
    @GeneratedValue
    private long ident;

    @ManyToOne
    @JoinColumn(name = "Districts.ident", nullable = false)
    private Districts districts;

    @Column(name="Title", nullable = false, length = 128, unique = true)
    private String title;
    @Column(name = "Code", nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "ident")
    private List<Hospitals> hospitals;

    public Cities() {
    }

    public Cities(Districts districts, String title, String code) {
        this.districts = districts;
        this.title = title;
        this.code = code;
    }

    public Districts getDistricts() {
        return districts;
    }

    public void setDistricts(Districts districts) {
        this.districts = districts;
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
}
