package com.ericsson.demo.controller;

import com.ericsson.demo.dto.RenterDto;
import com.ericsson.demo.service.RenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/renter")
public class RenterController {

  private final RenterService renterService;

  @GetMapping("/{renterId}")
  public ResponseEntity<RenterDto> getRenterByRenterId(@PathVariable final String renterId) {
    final RenterDto renterDto = this.renterService.findByRenterId(renterId);

    return (renterDto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(renterDto);
  }

}
