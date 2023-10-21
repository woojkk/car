package com.woojkk.car.vo;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Embeddable
@ToString
@NoArgsConstructor
public class CompanyName {
  private String value;

  private CompanyName(String value) {
    this.value = value;
  }

  public static CompanyName of(String value) {
    return new CompanyName(value);
  }
}
