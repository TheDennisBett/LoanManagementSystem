package com.example.credableLms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequestDto {
    private Long customerId;
    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private Integer loanTerm;
}
