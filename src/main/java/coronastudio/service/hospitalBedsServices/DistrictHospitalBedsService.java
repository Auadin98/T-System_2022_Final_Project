package coronastudio.service.hospitalBedsServices;

import sk.tsystems.coronastudio.entity.hospitalBeds.DistrictHospitalBeds;

import java.util.List;

public interface DistrictHospitalBedsService {

    public void addDistHosBeds(DistrictHospitalBeds districtHospitalBeds);

    public List<DistrictHospitalBeds> getDistHosBeds();

    public void reset();
}
