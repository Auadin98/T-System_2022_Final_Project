package sk.tsystems.coronastudio.server.service.hospitalBedsServices;



import sk.tsystems.coronastudio.entity.hospitalBeds.HospitalBeds;

import java.util.List;

public interface HospitalBedsService {

    public void addHosBeds(HospitalBeds hospitalBeds);

    public List<HospitalBeds> getHosBeds();

    public void reset();
}
