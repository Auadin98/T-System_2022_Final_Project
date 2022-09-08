package sk.tsystems.coronastudio.server.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.entity.hospitalPatients.RegionHospitalPatients;
import sk.tsystems.coronastudio.entity.hospitalPatients.SlovakiaHospitalPatients;

import java.util.List;

public interface SlovakiaHospitalPatientsService {
        public void addSlovakiaHospitalPatients(SlovakiaHospitalPatients slovakiaHospitalPatients);

        public List<SlovakiaHospitalPatients> getSlovakiaHospitalPatients();

        public void reset();

    }

