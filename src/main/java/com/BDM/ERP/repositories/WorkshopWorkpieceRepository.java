package com.BDM.ERP.repositories;

import com.BDM.ERP.models.WorkshopWorkpiece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkshopWorkpieceRepository extends JpaRepository<WorkshopWorkpiece, Long> {
    List<WorkshopWorkpiece> findByPartNumber(String partNumber);
}
