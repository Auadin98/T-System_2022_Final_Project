package sk.tsystems.coronastudio.ObjectsDTO;

public class RegFreeCovBedsDTO {
    String title;
    int capacity_covid;

    public RegFreeCovBedsDTO(String title, int capacity_covid) {
        this.title = title;
        this.capacity_covid = capacity_covid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity_covid() {
        return capacity_covid;
    }

    public void setCapacity_covid(int capacity_covid) {
        this.capacity_covid = capacity_covid;
    }
}
