package com.woojkk.car.vo;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Embeddable
@ToString
@NoArgsConstructor
public class CompanyNation {
  private String value;

  private CompanyNation(String value) {
    this.value = value;
  }

  public static CompanyNation of(String value) {
    return new CompanyNation(value);
  }
}
