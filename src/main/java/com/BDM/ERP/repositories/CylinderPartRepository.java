package com.BDM.ERP.repositories;

import com.BDM.ERP.models.CylinderPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CylinderPartRepository extends JpaRepository<CylinderPart, Long> {
    List<CylinderPart> findByApplicability(String cylinderNumber);
}
