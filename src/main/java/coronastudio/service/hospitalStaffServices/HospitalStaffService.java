package coronastudio.service.hospitalStaffServices;

import sk.tsystems.coronastudio.entity.hospitalStaff.HospitalStaff;

import java.util.List;

public interface HospitalStaffService {

    public void addHospitalStaff(HospitalStaff hospitalStaff);

    public List<HospitalStaff> getHospitalStaff();

    public void reset();
}
