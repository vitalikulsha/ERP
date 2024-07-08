package com.BDM.ERP.repositories;

import com.BDM.ERP.models.WorkshopProcessing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkshopProcessingRepository extends JpaRepository<WorkshopProcessing, Long> {
    List<WorkshopProcessing> findByPartNumber(String partNumber);
}
