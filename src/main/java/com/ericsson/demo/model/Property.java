package com.ericsson.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Property {

  public static final String PROPERTY_ID_NAME = "property_id";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty(Property.PROPERTY_ID_NAME)
  @Column(name = Property.PROPERTY_ID_NAME, unique = true)
  private String propertyId;

  @JsonProperty(Model.CREATED_AT_NAME)
  @Column(name = Model.CREATED_AT_NAME)
  private ZonedDateTime createdAt;

  private String name;

  private String address;

  private String username;

}
