package sk.tsystems.coronastudio.service.hospitalBedsServices;

import sk.tsystems.coronastudio.ObjectsDTO.RegFreeCovBedsDTO;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;

import java.util.List;

public interface RegionHospitalBedsService {

    public void addRegHosBeds(RegionHospitalBeds regionHospitalBeds);

    public List<RegionHospitalBeds> getRegHosBeds();

    public List<RegFreeCovBedsDTO> getRegCovCapacity();

    public void reset();
}
