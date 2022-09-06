package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AgTests {
    @Id
    @GeneratedValue
    private long ident;

    @ManyToOne
    @JoinColumn(name = "Districts.ident")
    private Districts districts;

    @ManyToOne
    @JoinColumn(name = "Regions.ident")
    private Regions regions;

    private Date updatedAt;
    private Date publishedOn;

    private int positivesCount;
    private int negativesCount;
    private int positivesSum;
    private int negativesSum;

    private float positivityRate = positivesCount/(positivesCount + negativesCount) * 100;

    /**
     * Constructors:
     *      - empty
     *      - basic
     *      - with region
     *      - with district
     */
    public AgTests() {
    }

    public AgTests(Date updatedAt, Date publishedOn, int positivesCount, int negativesCount, int positivesSum, int negativesSum) {
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
        this.positivesCount = positivesCount;
        this.negativesCount = negativesCount;
        this.positivesSum = positivesSum;
        this.negativesSum = negativesSum;
    }

    public AgTests(Regions regions, Date updatedAt, Date publishedOn, int positivesCount, int negativesCount, int positivesSum, int negativesSum) {
        this.regions = regions;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
        this.positivesCount = positivesCount;
        this.negativesCount = negativesCount;
        this.positivesSum = positivesSum;
        this.negativesSum = negativesSum;
    }

    public AgTests(Districts districts, Date updatedAt, Date publishedOn, int positivesCount, int negativesCount, int positivesSum, int negativesSum) {
        this.districts = districts;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
        this.positivesCount = positivesCount;
        this.negativesCount = negativesCount;
        this.positivesSum = positivesSum;
        this.negativesSum = negativesSum;
    }

    /**
     * Getters & Setters
     */

    public Districts getDistricts() {
        return districts;
    }

    public void setDistricts(Districts districts) {
        this.districts = districts;
    }

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
