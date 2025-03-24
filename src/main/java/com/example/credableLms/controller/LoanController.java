package com.example.credableLms.controller;

import com.example.credableLms.dto.LoanRequestDto;
import com.example.credableLms.dto.LoanResponseDto;
import com.example.credableLms.model.Customer;
import com.example.credableLms.model.Loan;
import com.example.credableLms.repository.CustomerRepository;
import com.example.credableLms.repository.LoanRepository;
import com.example.credableLms.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;
    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;

    // Existing endpoints
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

    // Merged endpoints from LoansController
    @PostMapping("/request")
    public String requestLoan(@RequestBody Loan loans) {
        Customer customer = customerRepository.findByCustomerNumber(loans.getCustomer().getCustomerNumber());
        if (customer == null) {
            return "Customer not found!";
        }

        loans.setCustomer(customer);
        loans.setStatus("PENDING");
        loanRepository.save(loans);

        return "Loan request submitted successfully!";
    }

    @GetMapping("/status/{id}")
    public String getLoanStatus(@PathVariable Long id) {
        Loan loans = loanRepository.findById(id).orElse(null);
        if (loans == null) {
            return "Loan not found!";
        }
        return "Loan Status: " + loans.getStatus();
    }
}
