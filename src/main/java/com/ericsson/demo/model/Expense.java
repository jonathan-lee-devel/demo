package com.ericsson.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Expense {

  public static final String EXPENSE_ID_NAME = "expense_id";
  public static final String IS_ACTIVE_NAME = "is_active";
  public static final String START_DATE_NAME = "start_date";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty(Expense.EXPENSE_ID_NAME)
  @Column(name = Expense.EXPENSE_ID_NAME, unique = true)
  private String expenseId;

  @JsonProperty(Model.CREATED_AT_NAME)
  @Column(name = Model.CREATED_AT_NAME)
  private ZonedDateTime createdAt;

  private BigDecimal amount;

  private ExpenseFrequency frequency;

  @JsonProperty(Expense.IS_ACTIVE_NAME)
  @Column(name = Expense.IS_ACTIVE_NAME)
  private Boolean isActive;

  @JsonProperty(Expense.START_DATE_NAME)
  @Column(name = Expense.START_DATE_NAME)
  private LocalDate startDate;

  @JsonIgnore
  @ManyToOne(
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      optional = false,
      targetEntity = Property.class
  )
  private Property property;

  public enum ExpenseFrequency {
    ONCE,
    DAILY,
    WEEKLY,
    BIWEEKLY,
    MONTHLY,
    YEARLY
  }

}
