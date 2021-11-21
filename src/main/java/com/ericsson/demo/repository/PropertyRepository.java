package com.ericsson.demo.repository;

import com.ericsson.demo.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface PropertyRepository extends JpaRepository<Property, Long> {

  @Nullable
  Property findByPropertyId(final String propertyId);

}
