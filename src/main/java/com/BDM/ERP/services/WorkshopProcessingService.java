package com.BDM.ERP.services;

import com.BDM.ERP.models.WorkshopProcessing;
import com.BDM.ERP.models.WorkshopWelding;
import com.BDM.ERP.models.WorkshopWorkpiece;
import com.BDM.ERP.repositories.WorkshopProcessingRepository;
import com.BDM.ERP.repositories.WorkshopWeldingRepository;
import com.BDM.ERP.repositories.WorkshopWorkpieceRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class WorkshopProcessingService {
    private final WorkshopProcessingRepository processingRepository;
    private final WorkshopWeldingRepository weldingRepository;

    public List<WorkshopProcessing> getListParts() {
        return processingRepository.findAll();
    }

    public void removePartFromMachining(Long id) {
        processingRepository.deleteById(id);
    }

    public void editPart(Long id, WorkshopProcessing part) {
        WorkshopProcessing partFromDB = processingRepository.findById(id).orElse(null);
        part.setId(id);
        part.setPartNumber(partFromDB.getPartNumber());
        part.setInput(partFromDB.getInput());
        processingRepository.save(part);
    }

    public WorkshopProcessing getPartById(Long id) {
        return processingRepository.findById(id).orElse(null);
    }

    public void addPartToWorkshopProcessing(WorkshopProcessing part) {
        processingRepository.save(part);
    }

    public void sendPartsToNext(Long id, Integer quantity, String workshop) {
        WorkshopProcessing partFromDB = processingRepository.findById(id).orElse(null);
        WorkshopWelding partWelding = new WorkshopWelding();
        if (quantity > partFromDB.getInput()) {
            return;
        }
        partWelding.setPartNumber(partFromDB.getPartNumber());
        partWelding.setInput(quantity);
        subtractQuantity(partFromDB, quantity);
        weldingRepository.save(partWelding);
        if (quantity == partFromDB.getInput()) {
            processingRepository.deleteById(id);
        } else {
            partFromDB.setInput(partFromDB.getInput() - quantity);
            processingRepository.save(partFromDB);
        }
    }

    private void subtractQuantity(WorkshopProcessing part, Integer quantity) {
        part.setTurning1(subtractQuantity(part.getTurning1(), quantity));
        part.setTurning2(subtractQuantity(part.getTurning2(), quantity));
        part.setTurning3(subtractQuantity(part.getTurning3(), quantity));
        part.setDrilling(subtractQuantity(part.getDrilling(), quantity));
        part.setMilling(subtractQuantity(part.getMilling(), quantity));
    }

    private Integer subtractQuantity(Integer partQuantity, Integer quantity) {
        return Math.max((partQuantity - quantity), 0);
    }
}
