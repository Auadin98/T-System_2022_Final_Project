package coronastudio.service.agTestsServices;

import sk.tsystems.coronastudio.entity.agTests.RegionAgTests;

import java.util.List;

public interface RegionAgTestsService {

    public void addRegAgTest(RegionAgTests regionAgTest);

    public List<RegionAgTests> getRegAgTests();

    public void reset();
}
