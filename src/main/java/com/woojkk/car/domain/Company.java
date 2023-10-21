package com.woojkk.car.domain;

import com.woojkk.car.vo.CompanyName;
import com.woojkk.car.vo.CompanyNation;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditOverride;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@AuditOverride(forClass = BaseEntity.class)
public class Company extends BaseEntity{

  public Company(CompanyName companyName, CompanyNation companyNation) {
    this.companyName = companyName;
    this.companyNation = companyNation;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "company_name"))
  private CompanyName companyName;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "company_nation"))
  private CompanyNation companyNation;
}
