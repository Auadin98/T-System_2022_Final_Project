package sk.tsystem.coronastudio.entity.AgTests;

import sk.tsystem.coronastudio.entity.Regions;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class RegionAgTests {
    @Id
    @GeneratedValue
    private long ident;

    @ManyToOne
    @JoinColumn(name = "Regions.ident")
    private Regions regions;

    private Date updatedAt;
    private Date publishedOn;

    private int positivesCount;
    private int negativesCount;
    private int positivesSum;
    private int negativesSum;

    private float positivityRate;
    //= positivesCount/(positivesCount + negativesCount) * 100;

    /**
     * Constructors:
     */
    public RegionAgTests() {
    }

    public RegionAgTests(Date updatedAt, Date publishedOn, int positivesCount, int negativesCount, int positivesSum, int negativesSum, float positivityRate) {
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

    public float getPositivityRate() {
        return positivityRate;
    }
}
