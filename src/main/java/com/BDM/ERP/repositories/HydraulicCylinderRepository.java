package com.BDM.ERP.repositories;

import com.BDM.ERP.models.HydraulicCylinder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HydraulicCylinderRepository extends JpaRepository<HydraulicCylinder, Long> {
    HydraulicCylinder findByNumber(String number);
}
