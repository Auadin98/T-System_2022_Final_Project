package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Hospitals;

import java.util.List;
public interface HospitalService {
    void addHospital(Hospitals hospital);
    List<Hospitals> getHospitals();
}
