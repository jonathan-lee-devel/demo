package com.ericsson.demo.service;

import com.ericsson.demo.dto.ExpenseDto;

public interface ExpenseService {

  ExpenseDto findByExpenseId(final String expenseId);

}
