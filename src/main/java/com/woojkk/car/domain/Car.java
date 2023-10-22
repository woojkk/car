package com.woojkk.car.domain;

import com.woojkk.car.vo.ModelName;
import com.woojkk.car.vo.PassengerCapacity;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Car extends BaseEntity{

  public Car(ModelName modelName, Company company, PassengerCapacity passengerCapacity) {
    this.modelName = modelName;
    this.company = company;
    this.passengerCapacity = passengerCapacity;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "model_name"))
  private ModelName modelName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id")
  private Company company;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "passenger_capacity"))
  private PassengerCapacity passengerCapacity;
}
