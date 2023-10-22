package com.woojkk.car.controller;

import com.woojkk.car.domain.Car;
import com.woojkk.car.domain.CarInputDto;
import com.woojkk.car.domain.Company;
import com.woojkk.car.domain.CompanyInputDto;
import com.woojkk.car.service.CarService;
import com.woojkk.car.service.CompanyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BasicController {

  private final CompanyService companyService;
  private final CarService carService;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/companyForm")
  public String companyForm() {
    return "companyForm";
  }

  @PostMapping("/saveCompany")
  public String saveCompany(@ModelAttribute(name = "companyInputDto")CompanyInputDto companyInputDto) {
    companyService.saveCompanyInputDto(companyInputDto);

    return "index";
  }

  @GetMapping("/companyList")
  public String companyList(@PageableDefault Pageable pageable, Model model) {
    Page<Company> companyList = companyService.getACompanyPage(pageable);
    model.addAttribute("companyList", companyList);

    return "companyList";
  }

  @GetMapping("/carForm")
  public String carList(Model model) {
    List<Company> companyList = companyService.findAll();
    model.addAttribute("companyList", companyList);

    return "carForm";
  }

  @PostMapping("/saveCar")
  public String saveCar(@ModelAttribute(name = "carInputDto") CarInputDto carInputDto) {
    carService.saveCarInputDto(carInputDto);

    return "index";
  }

  @GetMapping("/carList")
  public String carList(@PageableDefault Pageable pageable, Model model) {
    Page<Car> carList = carService.getCarPage(pageable);
    model.addAttribute("carList", carList);

    return "carList";
  }
}
