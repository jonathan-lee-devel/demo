package com.ericsson.demo.map;

import com.ericsson.demo.dto.PropertyDto;
import com.ericsson.demo.model.Property;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PropertyMapperTest {

  private final PropertyMapper propertyMapper = Mappers.getMapper(PropertyMapper.class);

  private final Random random = new Random();

  @Test
  void test_whenPropertyMapper_thenPropertyMapped() {
    final Property property = Property
        .builder()
        .id(random.nextLong())
        .propertyId(UUID.randomUUID().toString())
        .createdAt(ZonedDateTime.now())
        .name(UUID.randomUUID().toString())
        .address(UUID.randomUUID().toString())
        .username(UUID.randomUUID().toString())
        .build();

    final PropertyDto propertyDto = this.propertyMapper.propertyToPropertyDto(property);

    Assertions.assertEquals(property.getPropertyId(), propertyDto.getPropertyId());
    Assertions.assertEquals(property.getCreatedAt(), propertyDto.getCreatedAt());
    Assertions.assertEquals(property.getName(), propertyDto.getName());
    Assertions.assertEquals(property.getAddress(), propertyDto.getAddress());
    Assertions.assertEquals(property.getUsername(), propertyDto.getUsername());
  }

}
