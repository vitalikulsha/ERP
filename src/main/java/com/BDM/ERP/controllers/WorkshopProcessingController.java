package com.BDM.ERP.controllers;

import com.BDM.ERP.models.WorkshopProcessing;
import com.BDM.ERP.services.WorkshopProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WorkshopProcessingController {
    private final WorkshopProcessingService processingService;

    @GetMapping("/workshop/mexobrabotka")
    public String getAllParts(Model model) {
        model.addAttribute("parts", processingService.getListParts());
        return "mexobrabotka";
    }


    @PostMapping("/workshop/mexobrabotka/delete/{id}")
    public String deletePart(@PathVariable Long id) {
        processingService.removePartFromMachining(id);
        return "redirect:/workshop/mexobrabotka";
    }

    @GetMapping("/workshop/mexobrabotka/edit/{id}")
    public String getPartForEdit(@PathVariable Long id, Model model){
        WorkshopProcessing part = processingService.getPartById(id);
        model.addAttribute("part", part);
        return "edit-mexobrabotka";
    }

    @PostMapping("/workshop/mexobrabotka/edit/{id}")
    public String editPart(@PathVariable Long id, WorkshopProcessing part){
        processingService.editPart(id, part);
        return "redirect:/workshop/mexobrabotka";
    }

    @PostMapping("/workshop/mexobrabotka/create")
    public String createPartToProcessing(WorkshopProcessing part){
        processingService.addPartToWorkshopProcessing(part);
        return "redirect:/workshop/mexobrabotka";
    }
}
