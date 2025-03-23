package com.example.credableLms.service;

import com.example.credableLms.dto.LoanRequestDto;
import com.example.credableLms.dto.LoanResponseDto;
import com.example.credableLms.model.Loan;
import com.example.credableLms.repository.LoanRepository;
import com.example.credableLms.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public LoanResponseDto createLoan(LoanRequestDto loanRequestDto) {
        Loan loan = new Loan(null, loanRequestDto.getBorrowerName(),
                loanRequestDto.getLoanAmount(), loanRequestDto.getInterestRate(),
                loanRequestDto.getLoanTerm(), java.time.LocalDate.now());
        Loan savedLoan = loanRepository.save(loan);
        return mapToDto(savedLoan);
    }

    @Override
    public LoanResponseDto getLoanById(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        return mapToDto(loan);
    }

    @Override
    public List<LoanResponseDto> getAllLoans() {
        return loanRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteLoan(Long id) {
        if (!loanRepository.existsById(id)) {
            throw new ResourceNotFoundException("Loan not found");
        }
        loanRepository.deleteById(id);
    }

    private LoanResponseDto mapToDto(Loan loan) {
        return new LoanResponseDto(loan.getId(),
                loan.getBorrowerName(),
                loan.getLoanAmount(),
                loan.getInterestRate(),
                loan.getLoanTerm(),
                loan.getStartDate(),
                "Active");
    }
}