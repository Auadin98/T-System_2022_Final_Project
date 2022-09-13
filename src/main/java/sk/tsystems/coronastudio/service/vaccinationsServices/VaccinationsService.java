package sk.tsystems.coronastudio.service.vaccinationsServices;

import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;

import java.util.List;

public interface VaccinationsService {

    public void addVaccinations(Vaccinations vaccinations);

    public List<Vaccinations> getVaccinations();

    public void reset();
}
