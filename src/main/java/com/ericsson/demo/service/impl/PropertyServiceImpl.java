package com.ericsson.demo.service.impl;

import com.ericsson.demo.dto.PropertyDto;
import com.ericsson.demo.map.PropertyMapper;
import com.ericsson.demo.model.Property;
import com.ericsson.demo.repository.PropertyRepository;
import com.ericsson.demo.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

  private final PropertyRepository propertyRepository;

  private final PropertyMapper propertyMapper = Mappers.getMapper(PropertyMapper.class);

  @Override
  public PropertyDto findByPropertyId(String propertyId) {
    final Property property = this.propertyRepository.findByPropertyId(propertyId);

    return (property == null) ? null : this.propertyMapper.propertyToPropertyDto(property);
  }

}
