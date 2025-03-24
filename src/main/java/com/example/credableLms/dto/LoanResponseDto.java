package com.example.credableLms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponseDto {
    private Long id;
    private String customerNumber;
    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private Integer loanTerm;
    private LocalDate startDate;
    private String status;
}
