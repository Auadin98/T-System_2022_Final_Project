package sk.tsystems.coronastudio.service.agTestsServices;

import sk.tsystems.coronastudio.entity.agTests.SlovakiaAgTests;

import java.util.List;

public interface SlovakiaAgTestsService {

    public void addSlovAgTest(SlovakiaAgTests slovakiaAgTest);

    public List<SlovakiaAgTests> getSlovAgTests();

    public List<SlovakiaAgTests> getSumSlovAgTests();

    public List<SlovakiaAgTests> getAvgPosRate();

    public void reset();
}
