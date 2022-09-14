package sk.tsystems.coronastudio.service.agTestsServices;

import sk.tsystems.coronastudio.ObjectsDTO.AgNegativeTestDTO;
import sk.tsystems.coronastudio.ObjectsDTO.AgPositiveTestDTO;
import sk.tsystems.coronastudio.entity.agTests.RegionAgTests;
//import sk.tsystems.coronastudio.service.objectDTO.AgTestsDTO;

import java.util.List;

public interface RegionAgTestsService {

    public void addRegAgTest(RegionAgTests regionAgTest);

    public List<RegionAgTests> getRegAgTests();

    public List<AgPositiveTestDTO> getPositiveAgTests();

    public List<AgNegativeTestDTO> getNegativeAgTests();

    public void reset();
}
