package com.woojkk.car.repository;

import com.woojkk.car.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>, CarRepositoryCustom {

}
