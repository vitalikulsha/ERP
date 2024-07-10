package com.BDM.ERP.controllers;

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
        model.addAttribute("mexobrabotka", processingService.getListParts());
        return "mexobrabotka";
    }


    @PostMapping("/workshop/mexobrabotka/delete/{id}")
    public String deletePart(@PathVariable Long id) {
        processingService.removePartFromMachining(id);
        return "redirect:/workshop/mexobrabotka";
    }
}
