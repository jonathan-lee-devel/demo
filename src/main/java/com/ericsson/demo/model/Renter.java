package com.ericsson.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Renter {

  private static final String RENTER_ID_NAME = "renter_id";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty(Renter.RENTER_ID_NAME)
  @Column(name = Renter.RENTER_ID_NAME, unique = true)
  private String renterId;

  @JsonProperty(Model.CREATED_AT_NAME)
  @Column(name = Model.CREATED_AT_NAME)
  private ZonedDateTime createdAt;

  private String name;

  private String username;

}
