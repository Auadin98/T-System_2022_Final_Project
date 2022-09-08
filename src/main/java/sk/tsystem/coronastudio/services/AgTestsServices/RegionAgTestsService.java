package sk.tsystem.coronastudio.services.AgTestsServices;
import sk.tsystem.coronastudio.entity.AgTests.RegionAgTests;

import java.util.List;
public interface RegionAgTestsService {
    void addRegAgTest(RegionAgTests regionAgTest);
    List<RegionAgTests> getRegAgTests();
}
