package sk.tsystem.coronastudio.services.AgTestsServices;

import sk.tsystem.coronastudio.entity.AgTests.DistrictAgTests;

import java.util.List;

public interface DistrictAgTestsService {
    void addDisAgTest(DistrictAgTests districtAgTest);
    List<DistrictAgTests> getDisAgTests();
}
