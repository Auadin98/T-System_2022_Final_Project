package sk.tsystems.coronastudio.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.entity.hospitalPatients.HospitalPatients;

import java.util.List;

public interface HospitalPatientsService {

    public void addHospitalPatients(HospitalPatients hospitalPatients);

    public List<HospitalPatients> getHospitalPatients();

    public void reset();
}
