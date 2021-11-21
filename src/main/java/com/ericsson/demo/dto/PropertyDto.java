package com.ericsson.demo.dto;

import com.ericsson.demo.model.Model;
import com.ericsson.demo.model.Property;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class PropertyDto {

  @JsonProperty(Property.PROPERTY_ID_NAME)
  private String propertyId;

  @JsonProperty(Model.CREATED_AT_NAME)
  private ZonedDateTime createdAt;

  private String name;

  private String address;

  private String username;

}
