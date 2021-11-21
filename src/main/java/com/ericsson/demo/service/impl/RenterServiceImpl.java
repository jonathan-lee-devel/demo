package com.ericsson.demo.service.impl;

import com.ericsson.demo.dto.RenterDto;
import com.ericsson.demo.map.RenterMapper;
import com.ericsson.demo.model.Renter;
import com.ericsson.demo.repository.RenterRepository;
import com.ericsson.demo.service.RenterService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RenterServiceImpl implements RenterService {

  private final RenterRepository renterRepository;

  private final RenterMapper renterMapper = Mappers.getMapper(RenterMapper.class);

  @Override
  public RenterDto findByRenterId(final String renterId) {
    final Renter renter = this.renterRepository.findByRenterId(renterId);

    return (renter == null) ? null : this.renterMapper.renterToRenterDto(renter);
  }

}
