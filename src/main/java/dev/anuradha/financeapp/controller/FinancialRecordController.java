package dev.anuradha.financeapp.controller;

import dev.anuradha.financeapp.entity.FinancialRecord;
import dev.anuradha.financeapp.service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final FinancialRecordService financialRecordService;

    @PostMapping
    public FinancialRecord createRecord(@RequestBody FinancialRecord record){
        return financialRecordService.createRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getAllRecords(){
        return financialRecordService.getAllRecords();
    }

    @PutMapping("/{id}")
    public FinancialRecord updateRecord(@PathVariable Long id,
                                        @RequestBody FinancialRecord record){

        return financialRecordService.updateRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id){
        financialRecordService.deleteRecord(id);
    }
}
