package com.ericsson.demo.map;

import com.ericsson.demo.dto.PropertyDto;
import com.ericsson.demo.model.Property;
import org.mapstruct.Mapper;

@Mapper
public interface PropertyMapper {

  PropertyDto propertyToPropertyDto(Property property);

}
