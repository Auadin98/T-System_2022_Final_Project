package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Hospital;

import java.util.List;

public interface HospitalService {
    public List<Hospital> getHospitals();
    void addHospital(Hospital hospital);
}
