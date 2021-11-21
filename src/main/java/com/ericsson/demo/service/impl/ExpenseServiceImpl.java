package com.ericsson.demo.service.impl;

import com.ericsson.demo.dto.ExpenseDto;
import com.ericsson.demo.map.ExpenseMapper;
import com.ericsson.demo.model.Expense;
import com.ericsson.demo.repository.ExpenseRepository;
import com.ericsson.demo.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

  private final ExpenseRepository expenseRepository;

  private final ExpenseMapper expenseMapper = Mappers.getMapper(ExpenseMapper.class);

  @Override
  public ExpenseDto findByExpenseId(final String expenseId) {
    final Expense expense = this.expenseRepository.findByExpenseId(expenseId);

    return (expense == null) ? null : this.expenseMapper.expenseToExpenseDto(expense);
  }

}
