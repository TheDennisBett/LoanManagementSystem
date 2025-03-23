package com.example.credableLms.repository;

import com.example.credableLms.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {}