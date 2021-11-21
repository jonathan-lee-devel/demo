package com.ericsson.demo.dto;

import com.ericsson.demo.model.Model;
import com.ericsson.demo.model.Renter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class RenterDto {

  @JsonProperty(Renter.RENTER_ID_NAME)
  private String renterId;

  @JsonProperty(Model.CREATED_AT_NAME)
  private ZonedDateTime createdAt;

  private String name;

  private String username;

}
