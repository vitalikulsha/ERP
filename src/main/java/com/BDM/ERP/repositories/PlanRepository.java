package com.BDM.ERP.repositories;

import com.BDM.ERP.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByCustomer(String customer);
    List<Plan> findByCylinderNumber (String cylinderNumber);
}
