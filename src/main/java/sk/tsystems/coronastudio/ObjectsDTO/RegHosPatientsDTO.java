package sk.tsystems.coronastudio.ObjectsDTO;

public class RegHosPatientsDTO {
    String title;
    int confirmed_covid;

    public RegHosPatientsDTO(String title, int confirmed_covid) {
        this.title = title;
        this.confirmed_covid = confirmed_covid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getConfirmed_covid() {
        return confirmed_covid;
    }

    public void setConfirmed_covid(int confirmed_covid) {
        this.confirmed_covid = confirmed_covid;
    }
}
