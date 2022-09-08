package sk.tsystem.coronastudio.services.AgTestsServices;

import sk.tsystem.coronastudio.entity.AgTests.AgTests;

import java.util.List;

public interface AgTestsService {
    void addAgTest(AgTests agTest);
    List<AgTests> getAgTests();
}
