package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalBeds {
    @Id
    @GeneratedValue
    private long ident;

    @ManyToOne
    @JoinColumn(name = "Hospitals.ident", nullable = false)
    private Hospitals hospitals;
    @ManyToOne
    @JoinColumn(name = "Districts.ident")
    private Districts districts;
    @ManyToOne
    @JoinColumn(name = "Regions.ident")
    private Regions regions;

    private Date reportedAt;
    private Date updatedAt;
    private Date publishedOn;

    private int capacityAll;
    private int freeAll;
    private int capacityCovid;
    private int occupiedJisCovid;
    private int occupiedOaimCovid;
    private int occupiedO2Covid;
    private int occupiedOtherCovid;
}
