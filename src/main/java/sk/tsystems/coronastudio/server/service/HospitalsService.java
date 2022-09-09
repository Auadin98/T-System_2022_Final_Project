package sk.tsystems.coronastudio.server.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.tsystems.coronastudio.entity.Hospitals;

import java.util.List;
@Repository
public interface HospitalsService {

    public void addHospital(Hospitals hospitals);

    public List<Hospitals> getHospitals();

    public void reset();

    }

