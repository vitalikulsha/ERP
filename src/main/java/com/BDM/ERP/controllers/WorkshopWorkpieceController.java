package com.BDM.ERP.controllers;

import com.BDM.ERP.models.WorkshopProcessing;
import com.BDM.ERP.models.WorkshopWorkpiece;
import com.BDM.ERP.services.WorkshopWorkpieceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WorkshopWorkpieceController {
    private final WorkshopWorkpieceService workpieceService;

    @GetMapping("/workshop/zagotovka")
    public String getAllParts(Model model) {
        model.addAttribute("workpiece", workpieceService.getListParts());
        return "zagotovka";
    }

    @PostMapping("/workshop/zagotovka/delete/{id}")
    public String deletePart(@PathVariable Long id) {
        workpieceService.removePartFromMachining(id);
        return "redirect:/workshop/zagotovka";
    }

    @GetMapping("/workshop/zagotovka/edit/{id}")
    public String getPartForEdit(@PathVariable Long id, Model model){
        WorkshopWorkpiece part = workpieceService.getPartById(id);
        model.addAttribute("part", part);
        return "edit-zagotovka";
    }

    @PostMapping("/workshop/zagotovka/edit/{id}")
    public String editPlan(@PathVariable Long id, WorkshopWorkpiece part){
        workpieceService.editPart(id, part);
        return "redirect:/workshop/zagotovka";
    }

    @PostMapping("/workshop/zagotovka/create")
    public String createPartToWorkpiece (WorkshopWorkpiece part){
        workpieceService.addPartToWorkshopWorkpiece(part);
        return "redirect:/workshop/zagotovka";
    }

    @PostMapping("/workshop/zagotovka/send-all/{id}")
    public String senAllPart(@PathVariable Long id) {
        workpieceService.sendAllToWorkshopProcessing(id);
        return "redirect:/workshop/zagotovka";
    }

}
