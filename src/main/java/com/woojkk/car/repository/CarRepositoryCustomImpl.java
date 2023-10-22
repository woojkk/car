package com.woojkk.car.repository;

import com.woojkk.car.domain.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepositoryCustomImpl implements CarRepositoryCustom {
  @PersistenceContext
  EntityManager em;

  @Override
  public List<Car> getCarListByFetchJoin() {
    String query = "select car from Car car join fetch car.company ";

    return em.createQuery(query, Car.class).getResultList();
  }
}
