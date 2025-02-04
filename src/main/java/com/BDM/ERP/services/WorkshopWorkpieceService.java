package com.BDM.ERP.services;

import com.BDM.ERP.models.WorkshopProcessing;
import com.BDM.ERP.models.WorkshopWorkpiece;
import com.BDM.ERP.repositories.WorkshopProcessingRepository;
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
public class WorkshopWorkpieceService {
    private final WorkshopWorkpieceRepository workpieceRepository;
    private final WorkshopProcessingRepository processingRepository;

    public List<WorkshopWorkpiece> getListParts() {
        return workpieceRepository.findAll();
    }

    public void removePartFromMachining(Long id) {
        workpieceRepository.deleteById(id);
    }

    public void editPart(Long id, WorkshopWorkpiece part) {
        WorkshopWorkpiece partFromDB = workpieceRepository.findById(id).orElse(null);
        part.setId(id);
        part.setPartNumber(partFromDB.getPartNumber());
        workpieceRepository.save(part);
    }

    public WorkshopWorkpiece getPartById(Long id) {
        return workpieceRepository.findById(id).orElse(null);
    }

    public void addPartToWorkshopWorkpiece(WorkshopWorkpiece part) {
        workpieceRepository.save(part);
    }

    public void sendAllToWorkshopProcessing(Long id) {
        WorkshopWorkpiece workpiece = workpieceRepository.findById(id).orElse(null);
        WorkshopProcessing part = new WorkshopProcessing();
        part.setInput(workpiece.getSaw());
        part.setPartNumber(workpiece.getPartNumber());
        processingRepository.save(part);
        workpieceRepository.deleteById(id);
    }

    public void sendPartsToWorkshopProcessing(Long id, Integer quantity) {
        WorkshopWorkpiece workpiece = workpieceRepository.findById(id).orElse(null);
        if (quantity > workpiece.getSaw()) {
            return;
        }
        if (quantity == workpiece.getInput()) {
            sendAllToWorkshopProcessing(id);
            return;
        }
        workpiece.setSaw(workpiece.getSaw() - quantity);
        workpiece.setInput(workpiece.getInput() - quantity);
        WorkshopProcessing part = new WorkshopProcessing();
        part.setInput(quantity);
        part.setPartNumber(workpiece.getPartNumber());
        processingRepository.save(part);
        workpieceRepository.save(workpiece);
    }
}
