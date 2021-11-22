package com.ericsson.demo.repository;

import com.ericsson.demo.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

  @Nullable
  Expense findByExpenseId(final String expenseId);

  Expense deleteByExpenseId(final String expenseId);

}
