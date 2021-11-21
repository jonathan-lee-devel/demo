package com.ericsson.demo.map;

import com.ericsson.demo.dto.ExpenseDto;
import com.ericsson.demo.model.Expense;
import com.ericsson.demo.model.Expense.ExpenseFrequency;
import com.ericsson.demo.model.Property;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class ExpenseMapperTest {

  private final ExpenseMapper expenseMapper = Mappers.getMapper(ExpenseMapper.class);

  private final Random random = new Random();

  @Test
  void test_whenExpenseMapper_thenExpenseMapped() {
    final Expense expense = Expense
        .builder()
        .id(this.random.nextLong())
        .expenseId(UUID.randomUUID().toString())
        .createdAt(ZonedDateTime.now())
        .amount(BigDecimal.TEN)
        .frequency(ExpenseFrequency.DAILY)
        .isActive(this.random.nextBoolean())
        .startDate(LocalDate.now())
        .property(new Property())
        .build();

    final ExpenseDto expenseDto = this.expenseMapper.expenseToExpenseDto(expense);

    Assertions.assertEquals(expense.getExpenseId(), expenseDto.getExpenseId());
    Assertions.assertEquals(expense.getCreatedAt(), expenseDto.getCreatedAt());
    Assertions.assertEquals(expense.getAmount(), expenseDto.getAmount());
    Assertions.assertEquals(expense.getFrequency(), expenseDto.getFrequency());
    Assertions.assertEquals(expense.getIsActive(), expenseDto.getIsActive());
    Assertions.assertEquals(expense.getStartDate(), expenseDto.getStartDate());
    Assertions.assertEquals(expense.getProperty(), expenseDto.getProperty());
  }

}
