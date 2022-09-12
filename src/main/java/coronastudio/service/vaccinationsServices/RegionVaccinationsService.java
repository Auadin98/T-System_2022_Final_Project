package coronastudio.service.vaccinationsServices;

import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;

import java.util.List;

public interface RegionVaccinationsService {

    public void addRegionVaccinations(RegionVaccinations regionVaccinations);

    public List<RegionVaccinations> getRegionVaccinations();

    public void reset();
}
