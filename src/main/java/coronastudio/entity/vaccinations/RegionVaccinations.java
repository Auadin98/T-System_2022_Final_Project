package coronastudio.entity.vaccinations;

import sk.tsystems.coronastudio.entity.Regions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RegionVaccinations implements Serializable {

    @Id
    private long id;

    @Column(nullable = false)
    private int dose1_count;

    @Column(nullable = false)
    private int dose2_count;

    @Column(nullable = false)
    private long dose1_sum;

    @Column(nullable = false)
    private long dose2_sum;

    private Date updated_at;

    private Date published_on;

    @ManyToOne
    @JoinColumn(name = "Regions.id", nullable = false)
    private Regions regions;

    public RegionVaccinations(){}

    public RegionVaccinations(long id, int dose1_count, int dose2_count, long dose1_sum, long dose2_sum, Date updated_at, Date published_on, Regions regions) {
        this.id = id;
        this.dose1_count = dose1_count;
        this.dose2_count = dose2_count;
        this.dose1_sum = dose1_sum;
        this.dose2_sum = dose2_sum;
        this.updated_at = updated_at;
        this.published_on = published_on;
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "RegionVaccinations{" +
                "dose1_count=" + dose1_count +
                ", dose2_count=" + dose2_count +
                ", dose1_sum=" + dose1_sum +
                ", dose2_sum=" + dose2_sum +
                ", updated_at=" + updated_at +
                ", published_on=" + published_on +
                ", regions=" + regions +
                '}';
    }
}
