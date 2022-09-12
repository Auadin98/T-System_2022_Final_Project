package coronastudio.entity.vaccinations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SlovakiaVaccinations implements Serializable {

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

    public SlovakiaVaccinations(){}

    public SlovakiaVaccinations(long id, int dose1_count, int dose2_count, long dose1_sum, long dose2_sum, Date updated_at, Date published_on) {
        this.id = id;
        this.dose1_count = dose1_count;
        this.dose2_count = dose2_count;
        this.dose1_sum = dose1_sum;
        this.dose2_sum = dose2_sum;
        this.updated_at = updated_at;
        this.published_on = published_on;
    }

    @Override
    public String toString() {
        return "SlovakiaVaccinations{" +
                "dose1_count=" + dose1_count +
                ", dose2_count=" + dose2_count +
                ", dose1_sum=" + dose1_sum +
                ", dose2_sum=" + dose2_sum +
                ", updated_at=" + updated_at +
                ", published_on=" + published_on +
                '}';
    }
}
