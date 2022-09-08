package sk.tsystem.coronastudio.services.AgTestsServices;
import sk.tsystem.coronastudio.entity.AgTests.SlovakiaAgTests;

import java.util.List;
public interface SlovakiaAgTestsService {
    void addSlovAgTest(SlovakiaAgTests slovakiaAgTest);
    List<SlovakiaAgTests> getSlovAgTests();
}
