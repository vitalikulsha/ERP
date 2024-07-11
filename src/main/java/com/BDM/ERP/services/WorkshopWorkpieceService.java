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
        part.setId(id);
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
}
