package com.example.credableLms.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class LoanRequestDto {
    private String borrowerName;
    private BigDecimal loanAmount;
    private Double interestRate;
    private Integer loanTerm;
}

