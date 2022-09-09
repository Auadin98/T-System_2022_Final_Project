package sk.tsystems.coronastudio.entity.agTests;

import sk.tsystems.coronastudio.entity.Regions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class RegionAgTests {

    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "Regions.id")
    private Regions regions;
    private Date updatedAt;
    private Date publishedOn;
    private int positivesCount;
    private int negativesCount;
    private int positivesSum;
    private int negativesSum;
    private double positivityRate;
    //= positivesCount/(positivesCount + negativesCount) * 100;

    /**
     * Constructors:
     */
    public RegionAgTests() {
    }

    public RegionAgTests(long id, Regions regions, Date updatedAt, Date publishedOn, int positivesCount,
                         int negativesCount, int positivesSum, int negativesSum, double positivityRate) {
        this.id = id;
        this.regions = regions;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
        this.positivesCount = positivesCount;
        this.negativesCount = negativesCount;
        this.positivesSum = positivesSum;
        this.negativesSum = negativesSum;
        this.positivityRate = positivityRate;
    }

    /**
     * Getters & Setters
     */

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    public int getPositivesCount() {
        return positivesCount;
    }

    public void setPositivesCount(int positivesCount) {
        this.positivesCount = positivesCount;
    }

    public int getNegativesCount() {
        return negativesCount;
    }

    public void setNegativesCount(int negativesCount) {
        this.negativesCount = negativesCount;
    }

    public int getPositivesSum() {
        return positivesSum;
    }

    public void setPositivesSum(int positivesSum) {
        this.positivesSum = positivesSum;
    }

    public int getNegativesSum() {
        return negativesSum;
    }

    public void setNegativesSum(int negativesSum) {
        this.negativesSum = negativesSum;
    }

    public double getPositivityRate() {
        return positivityRate;
    }
}
