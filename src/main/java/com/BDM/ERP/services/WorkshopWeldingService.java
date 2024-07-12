package com.BDM.ERP.services;

import com.BDM.ERP.models.WorkshopWelding;
import com.BDM.ERP.repositories.WorkshopWeldingRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class WorkshopWeldingService {
    private final WorkshopWeldingRepository weldingRepository;

    public List<WorkshopWelding> getListParts() {
        return weldingRepository.findAll();
    }

    public void removePartFromWelding(Long id) {
        weldingRepository.deleteById(id);
    }

    public void editPart(Long id, WorkshopWelding part) {
        WorkshopWelding partFromDB = weldingRepository.findById(id).orElse(null);
        part.setId(id);
        part.setPartNumber(partFromDB.getPartNumber());
        part.setInput(partFromDB.getInput());
        weldingRepository.save(part);
    }

    public WorkshopWelding getPartById(Long id){
        return weldingRepository.findById(id).orElse(null);
    }

    public void addPartToWorkshopWelding(WorkshopWelding part){
        weldingRepository.save(part);
    }
}
