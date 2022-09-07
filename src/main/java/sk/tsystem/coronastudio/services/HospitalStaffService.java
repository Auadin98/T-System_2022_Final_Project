package sk.tsystem.coronastudio.services;

import java.util.List;
import sk.tsystem.coronastudio.entity.HospitalStaff;

public interface HospitalStaffService {
    void addHospitalStaff(HospitalStaff hospitalStaff);

    List<HospitalStaff> getHospitalStaff();
}
