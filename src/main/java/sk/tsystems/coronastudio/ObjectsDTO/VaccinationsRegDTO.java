package sk.tsystems.coronastudio.ObjectsDTO;

public class VaccinationsRegDTO {
    String title;
    int dose1_sum;
    int dose2_sum;

    public VaccinationsRegDTO(String title, int dose1_sum, int dose2_sum) {
        this.title = title;
        this.dose1_sum = dose1_sum;
        this.dose2_sum = dose2_sum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDose1_sum() {
        return dose1_sum;
    }

    public void setDose1_sum(int dose1_sum) {
        this.dose1_sum = dose1_sum;
    }

    public int getDose2_sum() {
        return dose2_sum;
    }

    public void setDose2_sum(int dose2_sum) {
        this.dose2_sum = dose2_sum;
    }
}
