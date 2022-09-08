package sk.tsystems.coronastudio.server.service.vaccinationsServices;

import sk.tsystems.coronastudio.entity.vaccinations.SlovakiaVaccinations;

import java.util.List;

public interface SlovakiaVaccinationsService {

    public void addSlovakiaVaccinations(SlovakiaVaccinations slovakiaVaccinations);

    public List<SlovakiaVaccinations> getSlovakiaVaccinations();

    public void reset();
}
