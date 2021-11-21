package com.ericsson.demo.controller;

import com.ericsson.demo.dto.PropertyDto;
import com.ericsson.demo.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/property")
public class PropertyController {

  private final PropertyService propertyService;

  @GetMapping("/{propertyId}")
  public ResponseEntity<PropertyDto> getPropertyByPropertyId(
      @PathVariable final String propertyId) {
    final PropertyDto propertyDto = this.propertyService.findByPropertyId(propertyId);

    if (propertyDto == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(propertyDto);
  }

}
