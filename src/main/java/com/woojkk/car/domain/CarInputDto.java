package com.woojkk.car.domain;

import lombok.Data;

@Data
public class CarInputDto {
  private Long companyId;
  private String modelName;
  private Integer PassengerCapacity;
}
