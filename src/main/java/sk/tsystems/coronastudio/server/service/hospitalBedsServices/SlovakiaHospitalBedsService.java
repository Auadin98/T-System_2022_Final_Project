package sk.tsystems.coronastudio.server.service.hospitalBedsServices;

import sk.tsystems.coronastudio.entity.hospitalBeds.SlovakiaHospitalBeds;

import java.util.List;

public interface SlovakiaHospitalBedsService {

    public void addSlovHosBeds(SlovakiaHospitalBeds slovakiaHospitalBeds);

    public List<SlovakiaHospitalBeds> getSlovHosBeds();

    public void reset();
}
