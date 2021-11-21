package com.ericsson.demo.controller;

import com.ericsson.demo.dto.ExpenseDto;
import com.ericsson.demo.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/expense")
public class ExpenseController {

  private final ExpenseService expenseService;

  @GetMapping("/{expenseId}")
  public ResponseEntity<ExpenseDto> getExpenseByExpenseId(@PathVariable final String expenseId) {
    final ExpenseDto expenseDto = this.expenseService.findByExpenseId(expenseId);

    return (expenseDto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(expenseDto);
  }

}
