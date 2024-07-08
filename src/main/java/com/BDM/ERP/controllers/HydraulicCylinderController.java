package com.BDM.ERP.controllers;

import com.BDM.ERP.models.HydraulicCylinder;
import com.BDM.ERP.models.Plan;
import com.BDM.ERP.services.HydraulicCylinderService;
import com.BDM.ERP.services.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class HydraulicCylinderController {
    private final HydraulicCylinderService cylinderService;
    private final PlanService planService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/plan/{id}")
    public String getCylinderMap(@PathVariable Long id, Model model) {
        Plan plan = planService.getPlanById(id);
        HydraulicCylinder cylinder = cylinderService.getCylinderByNumber(plan.getCylinderNumber());
        model.addAttribute("cylinderParts", cylinder.getCylinderParts());
        model.addAttribute("cylinder", cylinder);
        model.addAttribute("customer", plan.getCustomer());
        model.addAttribute("cylinderPlan", plan.getQuantity());
        model.addAttribute("shippingDate", plan.getShippingDate());
        model.addAttribute("orderNumber", plan.getOrderNumber());
        return "cylinder-map";
    }

    @GetMapping("/cylinder/{number}")
    public String getCylinderInfo(@PathVariable String number, Model model) {
        HydraulicCylinder cylinder = cylinderService.getCylinderByNumber(number);
        model.addAttribute("cylinderParts", cylinder.getCylinderParts());
        model.addAttribute("cylinder", cylinder);
        return "cylinder-info";
    }


    @GetMapping("/cylinder")
    public String getCylinders(Model model) {
        model.addAttribute("cylinders", cylinderService.getAllCylinder());
        return "cylinder";
    }
}
