package com.BDM.ERP.controllers;

import com.BDM.ERP.models.HydraulicCylinder;
import com.BDM.ERP.services.HydraulicCylinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HydraulicCylinderController {
    private final HydraulicCylinderService cylinderService;

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

    @PostMapping("/cylinder/create")
    public String createCylinder(HydraulicCylinder cylinder, @RequestParam(name = "params", required = false) String... params) {
        cylinderService.addCylinder(cylinder, params);
        return "redirect:/cylinder";
    }
}
