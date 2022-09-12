package coronastudio.service.agTestsServices;

import sk.tsystems.coronastudio.entity.agTests.DistrictAgTests;

import java.util.List;

public interface DistrictAgTestsService {

    public void addDisAgTest(DistrictAgTests districtAgTest);

    public List<DistrictAgTests> getDisAgTests();

    public void reset();
}
