package com.ericsson.demo.map;

import com.ericsson.demo.dto.ExpenseDto;
import com.ericsson.demo.model.Expense;
import org.mapstruct.Mapper;

@Mapper
public interface ExpenseMapper {

  ExpenseDto expenseToExpenseDto(Expense expense);

}
