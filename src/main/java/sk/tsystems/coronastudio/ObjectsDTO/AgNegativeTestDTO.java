package sk.tsystems.coronastudio.ObjectsDTO;

public class AgNegativeTestDTO {
    String title;
    int negatives_sum;

    public AgNegativeTestDTO(String title, int negatives_sum) {
        this.title = title;
        this.negatives_sum = negatives_sum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNegatives_sum() {
        return negatives_sum;
    }

    public void setNegatives_sum(int negatives_sum) {
        this.negatives_sum = negatives_sum;
    }
}
