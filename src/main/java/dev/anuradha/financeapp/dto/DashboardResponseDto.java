package dev.anuradha.financeapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponseDto {
    private Double totalIncome;
    private Double totalExpense;
    private Double netBalance;
}
