package sk.tsystems.coronastudio.server.service.hospitalBedsServices;

import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;

import java.util.List;

public interface RegionHospitalBedsService {

    public void addRegHosBeds(RegionHospitalBeds regionHospitalBeds);

    public List<RegionHospitalBeds> getRegHosBeds();

    public void reset();
}
