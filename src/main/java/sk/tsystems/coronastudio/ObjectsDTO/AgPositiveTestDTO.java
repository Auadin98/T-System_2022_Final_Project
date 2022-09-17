package sk.tsystems.coronastudio.ObjectsDTO;

public class AgPositiveTestDTO {
    String title;
    int positives_sum;

    public AgPositiveTestDTO(String title, int positives_sum) {
        this.title = title;
        this.positives_sum = positives_sum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPositives_sum() {
        return positives_sum;
    }

    public void setPositives_sum(int positives_sum) {
        this.positives_sum = positives_sum;
    }
}
