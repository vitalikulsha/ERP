package com.BDM.ERP.services;

import com.BDM.ERP.models.WorkshopProcessing;
import com.BDM.ERP.repositories.WorkshopProcessingRepository;
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

    public List<WorkshopProcessing> getListParts() {
        return processingRepository.findAll();
    }

    public void removePartFromMachining(Long id){
        processingRepository.deleteById(id);
    }
}
