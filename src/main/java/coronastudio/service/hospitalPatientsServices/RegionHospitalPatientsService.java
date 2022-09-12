package coronastudio.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.entity.hospitalPatients.RegionHospitalPatients;

import java.util.List;

public interface RegionHospitalPatientsService {

    public void addRegionHospitalPatients(RegionHospitalPatients regionHospitalPatients);

    public List<RegionHospitalPatients> getRegionHospitalPatients();

    public void reset();
}
