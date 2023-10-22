package com.woojkk.car.vo;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Embeddable
@ToString
@NoArgsConstructor
public class ModelName {
  private String value;

  private ModelName(String value) {
    this.value = value;
  }

  public static ModelName of(String value) {
    return new ModelName(value);
  }
}
