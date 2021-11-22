package com.ericsson.demo.service.impl;

import com.ericsson.demo.dto.ExpenseDto;
import com.ericsson.demo.map.ExpenseMapper;
import com.ericsson.demo.model.Expense;
import com.ericsson.demo.repository.ExpenseRepository;
import com.ericsson.demo.service.ExpenseService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

  private final ExpenseRepository expenseRepository;

  private final ExpenseMapper expenseMapper = Mappers.getMapper(ExpenseMapper.class);

  @Override
  public Collection<ExpenseDto> getExpenses() {
    return this.expenseRepository
        .findAll()
        .stream()
        .parallel()
        .map(this.expenseMapper::expenseToExpenseDto)
        .toList();
  }

  @Override
  public ExpenseDto getExpenseByExpenseId(final String expenseId) {
    final Expense expense = this.expenseRepository.findByExpenseId(expenseId);

    return (expense == null) ? null : this.expenseMapper.expenseToExpenseDto(expense);
  }

  @Override
  public ExpenseDto createExpense(ExpenseDto expenseDto) {
    return null;
  }

  @Override
  public ExpenseDto updateExpense(ExpenseDto expenseDto) {
    return null;
  }

  @Override
  public ExpenseDto deleteExpenseByExpenseId(String expenseId) {
    final Expense expense = this.expenseRepository.deleteByExpenseId(expenseId);

    return (expense == null) ? null : this.expenseMapper.expenseToExpenseDto(expense);
  }

}
