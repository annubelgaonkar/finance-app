package dev.anuradha.financeapp.service;

import dev.anuradha.financeapp.entity.FinancialRecord;
import dev.anuradha.financeapp.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialRecordService {

    private final FinancialRecordRepository recordRepository;

    @PreAuthorize("hasRole('ADMIN')")
    public FinancialRecord createRecord(FinancialRecord record){
        return recordRepository.save(record);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST', 'VIEWER')")
    public List<FinancialRecord> getAllRecords(){
        return recordRepository.findAll();
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord updated){

        FinancialRecord existing = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existing.setAmount(updated.getAmount());
        existing.setCategory(updated.getCategory());
        existing.setType(updated.getType());
        existing.setDate(updated.getDate());
        existing.setDescription(updated.getDescription());

        return recordRepository.save(existing);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteRecord(Long id){
        recordRepository.deleteById(id);
    }


}
