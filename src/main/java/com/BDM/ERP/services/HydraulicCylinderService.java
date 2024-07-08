package com.BDM.ERP.services;

import com.BDM.ERP.models.CylinderPart;
import com.BDM.ERP.models.HydraulicCylinder;
import com.BDM.ERP.models.WorkshopProcessing;
import com.BDM.ERP.repositories.CylinderPartRepository;
import com.BDM.ERP.repositories.HydraulicCylinderRepository;
import com.BDM.ERP.repositories.PlanRepository;
import com.BDM.ERP.repositories.WorkshopProcessingRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class HydraulicCylinderService {
    private final HydraulicCylinderRepository cylinderRepository;
    private final CylinderPartRepository partRepository;
    private final WorkshopProcessingRepository processingRepository;

    public List<HydraulicCylinder> getAllCylinder() {
        List<HydraulicCylinder> cylinders = cylinderRepository.findAll();
        for (HydraulicCylinder cylinder : cylinders) {
            cylinder.setCylinderParts(partRepository.findByApplicability(cylinder.getNumber()));
        }
        return cylinders;
    }

    public HydraulicCylinder getCylinderByNumber(String number) {
        if (!number.isEmpty()) {
            HydraulicCylinder cylinder = cylinderRepository.findByNumber(number);
            List<CylinderPart> parts = partRepository.findByApplicability(cylinder.getNumber());
            for (CylinderPart part : parts) {
                part.setProcesses(processingRepository.findByPartNumber(part.getNumber()));
            }
            cylinder.setCylinderParts(parts);
            return cylinder;
        }
        return new HydraulicCylinder();
    }
}
