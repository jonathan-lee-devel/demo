package com.ericsson.demo.service;

import com.ericsson.demo.dto.PropertyDto;

public interface PropertyService {

  PropertyDto findByPropertyId(final String propertyId);

}
