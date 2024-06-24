package com.BDM.ERP.controllers;

import com.BDM.ERP.models.Plan;
import com.BDM.ERP.services.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @GetMapping("/")
    public String getPlanes(@RequestParam(name = "cylinderNumber", required = false) String cylinderNumber,
                            Model model) {
        model.addAttribute("planes", planService.getListPlanes(cylinderNumber));
        return "plan";
    }

    @GetMapping("/plan/{id}")
    public String planInfo(@PathVariable Long id, Model model) {
        model.addAttribute("plan", planService.getPlanById(id));
        return "plan-info";
    }

    @PostMapping("/plan/create")
    public String createPlan(Plan plan) {
        planService.addCylinderToPlan(plan);
        return "redirect:/";
    }

    @PostMapping("/plan/delete/{id}")
    public String deletePlan(@PathVariable Long id) {
        planService.removeCylinderFromPlan(id);
        return "redirect:/";
    }
}
