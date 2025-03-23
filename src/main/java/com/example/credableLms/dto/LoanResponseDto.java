
package com.example.credableLms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LoanResponseDto {
    private Long id;
    private String borrowerName;
    private BigDecimal loanAmount;
    private Double interestRate;
    private Integer loanTermMonths;
    private LocalDate startDate;
    private String status;
}
