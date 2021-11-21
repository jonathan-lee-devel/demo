package com.ericsson.demo.map;

import com.ericsson.demo.dto.RenterDto;
import com.ericsson.demo.model.Renter;
import org.mapstruct.Mapper;

@Mapper
public interface RenterMapper {

  RenterDto renterToRenterDto(Renter renter);

}
