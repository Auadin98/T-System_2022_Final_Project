package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.City;

import java.util.List;

public interface DistrictHospitalBedService {

    public List<City> getDistrictHospitalBeds();
    void addDistrictHospitalBed(City city);


}
