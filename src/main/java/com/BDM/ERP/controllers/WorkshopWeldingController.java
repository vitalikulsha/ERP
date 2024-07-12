package com.BDM.ERP.controllers;

import com.BDM.ERP.models.WorkshopWelding;
import com.BDM.ERP.services.WorkshopWeldingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WorkshopWeldingController {
    private final WorkshopWeldingService weldingService;

    @GetMapping("/workshop/svarka")
    public String getAllParts(Model model) {
        model.addAttribute("parts", weldingService.getListParts());
        return "svarka";
    }


    @PostMapping("/workshop/svarka/delete/{id}")
    public String deletePart(@PathVariable Long id) {
        weldingService.removePartFromWelding(id);
        return "redirect:/workshop/svarka";
    }

    @GetMapping("/workshop/svarka/edit/{id}")
    public String getPartForEdit(@PathVariable Long id, Model model){
        WorkshopWelding part = weldingService.getPartById(id);
        model.addAttribute("part", part);
        return "edit-svarka";
    }

    @PostMapping("/workshop/svarka/edit/{id}")
    public String editPart(@PathVariable Long id, WorkshopWelding part){
        weldingService.editPart(id, part);
        return "redirect:/workshop/svarka";
    }

    @PostMapping("workshop/svarka/create")
    public String createPartToWelding(WorkshopWelding part){
        weldingService.addPartToWorkshopWelding(part);
        return "redirect:/workshop/svarka";
    }
}
