package com.woojkk.car.repository;

import com.woojkk.car.domain.Car;
import java.util.List;

public interface CarRepositoryCustom {
  List<Car> getCarListByFetchJoin();
}
