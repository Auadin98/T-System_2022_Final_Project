package sk.tsystems.coronastudio.ObjectsDTO;

public class ActualDataTestTDO {
    String title;

    int id,free_all,non_covid,suspect_covid,confirmed_covid;

    public ActualDataTestTDO(){

    }
    public ActualDataTestTDO(String title, int id, int free_all, int non_covid, int suspect_covid, int confirmed_covid) {
        this.title = title;
        this.id = id;
        this.free_all = free_all;
        this.non_covid = non_covid;
        this.suspect_covid = suspect_covid;
        this.confirmed_covid = confirmed_covid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFree_all() {
        return free_all;
    }

    public void setFree_all(int free_all) {
        this.free_all = free_all;
    }

    public int getNon_covid() {
        return non_covid;
    }

    public void setNon_covid(int non_covid) {
        this.non_covid = non_covid;
    }

    public int getSuspect_covid() {
        return suspect_covid;
    }

    public void setSuspect_covid(int suspect_covid) {
        this.suspect_covid = suspect_covid;
    }

    public int getConfirmed_covid() {
        return confirmed_covid;
    }

    public void setConfirmed_covid(int confirmed_covid) {
        this.confirmed_covid = confirmed_covid;
    }
}
