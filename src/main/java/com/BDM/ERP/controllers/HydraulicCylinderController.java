package com.BDM.ERP.controllers;

import com.BDM.ERP.models.HydraulicCylinder;
import com.BDM.ERP.services.HydraulicCylinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class HydraulicCylinderController {
    private final HydraulicCylinderService cylinderService;

    @Value("${upload.path}")
    private String uploadPath;

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

    @PostMapping("/cylinder")
    public String createCylinder(HydraulicCylinder cylinder,
                                 @RequestParam("file") MultipartFile file,
                                 @RequestParam(name = "params", required = false) String... params) throws IOException {
        if (!file.isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            file.transferTo(new File(uploadPath + "/" + cylinder.getNumber() + ".pdf"));
        }
        cylinderService.addCylinder(cylinder, params);
        return "redirect:/cylinder";
    }
}
