package com.BDM.ERP.services;

import com.BDM.ERP.models.Plan;
import com.BDM.ERP.repositories.PlanRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class PlanService {
    private final PlanRepository planRepository;

    public List<Plan> listPlanes (String customer){
        if(customer!=null) return planRepository.findByCustomer(customer);
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
}
