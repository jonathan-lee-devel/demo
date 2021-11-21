package com.ericsson.demo.map;

import com.ericsson.demo.dto.RenterDto;
import com.ericsson.demo.model.Renter;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class RenterMapperTest {

  private final RenterMapper renterMapper = Mappers.getMapper(RenterMapper.class);

  private final Random random = new Random();

  @Test
  void test_whenRenterMapper_thenRenterMapped() {
    final Renter renter = Renter
        .builder()
        .id(this.random.nextLong())
        .renterId(UUID.randomUUID().toString())
        .createdAt(ZonedDateTime.now())
        .name(UUID.randomUUID().toString())
        .username(UUID.randomUUID().toString())
        .build();

    final RenterDto renterDto = this.renterMapper.renterToRenterDto(renter);

    Assertions.assertEquals(renter.getRenterId(), renterDto.getRenterId());
    Assertions.assertEquals(renter.getCreatedAt(), renterDto.getCreatedAt());
    Assertions.assertEquals(renter.getName(), renterDto.getName());
    Assertions.assertEquals(renter.getUsername(), renterDto.getUsername());
  }

}
