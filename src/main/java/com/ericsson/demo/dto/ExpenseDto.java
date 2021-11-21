package com.ericsson.demo.dto;

import com.ericsson.demo.model.Expense;
import com.ericsson.demo.model.Model;
import com.ericsson.demo.model.Property;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class ExpenseDto {

  @JsonProperty(Expense.EXPENSE_ID_NAME)
  private String expenseId;

  @JsonProperty(Model.CREATED_AT_NAME)
  private ZonedDateTime createdAt;

  private BigDecimal amount;

  private Expense.ExpenseFrequency frequency;

  @JsonProperty(Expense.IS_ACTIVE_NAME)
  private Boolean isActive;

  @JsonProperty(Expense.START_DATE_NAME)
  private LocalDate startDate;

  private Property property;

}
