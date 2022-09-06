package entity;

import javax.persistence.*;

@Entity
public class Regions {
    @Id
    @GeneratedValue
    private long ident;

    @Column(name="Title", nullable = false, length = 128, unique = true)
    private String title;
    @Column(name = "Code", nullable = false, unique = true)
    private String code;
    @Column(name = "Abbreviation", nullable = false, length = 5, unique = true)
    private String abbreviation;

    public Regions() {
    }

    public Regions(String title, String code, String abbreviation) {
        this.title = title;
        this.code = code;
        this.abbreviation = abbreviation;
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
