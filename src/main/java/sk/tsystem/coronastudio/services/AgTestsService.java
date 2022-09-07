package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.AgTests;

import java.util.List;

public interface AgTestsService {
    void addAgTest(AgTests agTest);
    List<AgTests> getAgTests();
}
