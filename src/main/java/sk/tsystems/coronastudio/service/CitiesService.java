package sk.tsystems.coronastudio.service;

import sk.tsystems.coronastudio.ObjectsDTO.ActualDataTestTDO;
import sk.tsystems.coronastudio.entity.Cities;

import java.util.List;

public interface CitiesService {

    public void addCity(Cities cities);

    public List<Cities> getCities();





    List<ActualDataTestTDO> getActualDataCities();

    public void reset();
}
