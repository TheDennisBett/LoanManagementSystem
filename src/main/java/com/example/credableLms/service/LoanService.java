package com.example.credableLms.service;

import com.example.credableLms.dto.LoanRequestDto;
import com.example.credableLms.dto.LoanResponseDto;
import java.util.List;

public interface LoanService {
    LoanResponseDto createLoan(LoanRequestDto loanRequestDto);
    LoanResponseDto getLoanById(Long id);
    List<LoanResponseDto> getAllLoans();
    void deleteLoan(Long id);
    LoanResponseDto updateLoanStatus(Long id, String status);
}
