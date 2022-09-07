package sk.tsystem.coronastudio.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vaccinations {
    @Id
    @GeneratedValue
    private long ident;

    @ManyToOne
    @JoinColumn(name = "Vaccines.ident", nullable = false)
    private Vaccines vaccines;
    @ManyToOne
    @JoinColumn(name = "Regions.ident")
    private Regions regions;

    private Date updatedAt;
    private Date publishedOn;

    private int dose1Count;
    private int dose2Count;
    private int dose1Sum;
    private int dose2Sum;
}
