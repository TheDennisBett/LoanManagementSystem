package com.example.credableLms.controller;

import com.example.credableLms.dto.LoanRequestDto;
import com.example.credableLms.dto.LoanResponseDto;
import com.example.credableLms.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public LoanResponseDto createLoan(@RequestBody LoanRequestDto loanRequestDto) {
        return loanService.createLoan(loanRequestDto);
    }

    @GetMapping("/{id}")
    public LoanResponseDto getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    @GetMapping
    public List<LoanResponseDto> getAllLoans() {
        return loanService.getAllLoans();
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }
}
