package com.ericsson.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Renter {

  public static final String RENTER_ID_NAME = "renter_id";

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
