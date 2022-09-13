package sk.tsystems.coronastudio.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.entity.hospitalPatients.DistrictHospitalPatients;

import java.util.List;

public interface DistrictHospitalPatientsService {

    public void addDistrictHospitalPatients(DistrictHospitalPatients districtHospitalPatients);

    public List<DistrictHospitalPatients> getDistrictHospitalPatients();

    public void reset();
}
