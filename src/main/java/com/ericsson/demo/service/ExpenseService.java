package com.ericsson.demo.service;

import com.ericsson.demo.dto.ExpenseDto;
import java.util.Collection;

public interface ExpenseService {

  Collection<ExpenseDto> getExpenses();

  ExpenseDto getExpenseByExpenseId(final String expenseId);

  ExpenseDto createExpense(final ExpenseDto expenseDto);

  ExpenseDto updateExpense(final ExpenseDto expenseDto);

  ExpenseDto deleteExpenseByExpenseId(final String expenseId);

}
