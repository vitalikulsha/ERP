package com.BDM.ERP.services;

import com.BDM.ERP.models.Plan;
import com.BDM.ERP.repositories.PlanRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class PlanService {
    private final PlanRepository planRepository;

    public List<Plan> getListPlanes(String cylinderNumber){
        if(cylinderNumber!=null) return planRepository.findByCylinderNumber(cylinderNumber);
        return planRepository.findAll();
    }

    public void addCylinderToPlan(Plan plan){
        log.info("Add new cylinder to plan: {}", plan);
        planRepository.save(plan);
    }

    public void removeCylinderFromPlan(Long id){
        planRepository.deleteById(id);
    }

    public Plan getPlanById (Long id){
        return planRepository.findById(id).orElse(null);
    }

    public void editPlan(Long id, Plan plan){
        Plan planFromDB = planRepository.findById(id).orElse(null);
        plan.setId(id);
        plan.setOrderNumber(planFromDB.getOrderNumber());
        plan.setCustomer(planFromDB.getCustomer());
        plan.setCylinderNumber(planFromDB.getCylinderNumber());
        planRepository.save(plan);
    }
}
