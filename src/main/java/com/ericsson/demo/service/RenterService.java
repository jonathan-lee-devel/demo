package com.ericsson.demo.service;

import com.ericsson.demo.dto.RenterDto;

public interface RenterService {

  RenterDto findByRenterId(final String renterId);

}
