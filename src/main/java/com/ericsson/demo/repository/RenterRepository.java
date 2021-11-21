package com.ericsson.demo.repository;

import com.ericsson.demo.model.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface RenterRepository extends JpaRepository<Renter, Long> {

  @Nullable
  Renter findByRenterId(final String renterId);

}
