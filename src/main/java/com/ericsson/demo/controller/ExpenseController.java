package com.ericsson.demo.controller;

import com.ericsson.demo.dto.ExpenseDto;
import com.ericsson.demo.service.ExpenseService;
import java.util.Collection;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

  private final ExpenseService expenseService;

  @GetMapping
  public ResponseEntity<Collection<ExpenseDto>> getExpenses() {
    final Collection<ExpenseDto> expenseDtos = this.expenseService.getExpenses();

    return ResponseEntity.ok((expenseDtos == null) ? Collections.emptyList() : expenseDtos);
  }

  @GetMapping("/{expenseId}")
  public ResponseEntity<ExpenseDto> getExpenseByExpenseId(@PathVariable final String expenseId) {
    final ExpenseDto expenseDto = this.expenseService.getExpenseByExpenseId(expenseId);

    return (expenseDto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(expenseDto);
  }

}
