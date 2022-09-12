package coronastudio.service;

import sk.tsystems.coronastudio.entity.Hospitals;

import java.util.List;

public interface HospitalsService {

    public void addHospital(Hospitals hospitals);

    public List<Hospitals> getHospitals();

    public void reset();
}
