package com.woojkk.car.service;

import com.woojkk.car.domain.Car;
import com.woojkk.car.domain.CarInputDto;
import com.woojkk.car.repository.CarRepository;
import com.woojkk.car.vo.ModelName;
import com.woojkk.car.vo.PassengerCapacity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;

  private final CompanyService companyService;

  public Car saveCarInputDto(CarInputDto carInputDto) {
    Car car = Car.builder()
        .modelName(ModelName.of(carInputDto.getModelName()))
        .passengerCapacity(PassengerCapacity.of(carInputDto.getPassengerCapacity()))
        .company(companyService.find(carInputDto.getCompanyId()))
        .build();

    return carRepository.save(car);
  }

  public Page<Car> getCarPage(Pageable pageable) {
    int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() -1);
    pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id"));

    return carRepository.findAll(pageable);
  }

  public void saveAll(List<Car> companyList) {
    carRepository.saveAll(companyList);
  }

  public List<Car> getCarList() {
    return carRepository.getCarListByFetchJoin();

  }
}
