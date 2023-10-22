package com.woojkk.car.vo;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Embeddable
@ToString
@NoArgsConstructor
public class PassengerCapacity {
  private Integer value;

  private PassengerCapacity (Integer value) {
    this.value = value;
  }

  public static PassengerCapacity of(Integer value) {
    return new PassengerCapacity(value);
  }
}
