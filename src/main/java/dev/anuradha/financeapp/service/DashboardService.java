package dev.anuradha.financeapp.service;

import dev.anuradha.financeapp.dto.DashboardResponseDto;
import dev.anuradha.financeapp.entity.RecordType;
import dev.anuradha.financeapp.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinancialRecordRepository recordRepository;

    public Double getTotalIncome(){
        return recordRepository.getTotalByType(RecordType.INCOME);
    }

    public Double getTotalExpense(){
        return recordRepository.getTotalByType(RecordType.EXPENSE);
    }

   // @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    public Double getNetBalance(){
        Double income = getTotalIncome();
        Double expense = getTotalExpense();

        return (income != null ? income : 0) - (expense != null ? expense: 0);
    }

    public DashboardResponseDto getSummary(){
        Double income = getTotalIncome();
        Double expense = getTotalExpense();

        return DashboardResponseDto.builder()
                .totalIncome(income != null ? income : 0)
                .totalExpense(expense != null ? expense : 0)
                .netBalance((income != null ? income : 0) - (expense != null ? expense : 0))
                .build();
    }
}
