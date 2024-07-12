package com.BDM.ERP.repositories;

import com.BDM.ERP.models.WorkshopProcessing;
import com.BDM.ERP.models.WorkshopWelding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkshopWeldingRepository extends JpaRepository<WorkshopWelding, Long> {
    List <WorkshopWelding> findByPartNumber(String partNumber);
}
