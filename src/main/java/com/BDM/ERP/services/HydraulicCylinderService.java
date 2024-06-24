package com.BDM.ERP.services;

import com.BDM.ERP.models.CylinderPart;
import com.BDM.ERP.models.HydraulicCylinder;
import com.BDM.ERP.repositories.HydraulicCylinderRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class HydraulicCylinderService {
    private final HydraulicCylinderRepository cylinderRepository;

    public List<HydraulicCylinder> getAllCylinder() {
        return cylinderRepository.findAll();
    }

    public HydraulicCylinder getCylinderByNumber(String number) {
        if (number != null) return cylinderRepository.findByNumber(number);
        return new HydraulicCylinder();
    }

    public void addCylinder(HydraulicCylinder cylinder, String... params) {
        log.info("Add new cylinder to DB: {}", cylinder);
        for (int i = 0; i < params.length; i = i + 3) {
            if (params[i] != null) {
                CylinderPart part = toCylinderPartEntity(params[i], params[i + 1], params[i + 2]);
                cylinder.addPartToCylinder(part);
            } else {
                break;
            }
        }
        cylinderRepository.save(cylinder);
    }

    private CylinderPart toCylinderPartEntity(String number, String name, String quantity) {
        CylinderPart part = new CylinderPart();
        part.setNumber(number);
        part.setName(name);
        part.setQuantity(Integer.parseInt(quantity));
        return part;
    }
}
