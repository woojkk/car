package com.woojkk.car.service;

import com.woojkk.car.domain.Company;
import com.woojkk.car.domain.CompanyInputDto;
import com.woojkk.car.repository.CompanyRepository;
import com.woojkk.car.vo.CompanyName;
import com.woojkk.car.vo.CompanyNation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyService {

  private final CompanyRepository companyRepository;

  @Transactional
  public Company saveCompanyInputDto(CompanyInputDto companyInputDto) {
    Company company = Company.builder()
        .companyName(CompanyName.of(companyInputDto.getCompanyName()))
        .companyNation(CompanyNation.of(companyInputDto.getCompanyNation()))
        .build();

    return companyRepository.save(company);
  }

  public Company save(Company company) {
    return companyRepository.save(company);
  }

  public void saveAll(List<Company> companyList) {
    companyRepository.saveAll(companyList);
  }

  public Page<Company> getACompanyPage(Pageable pageable) {
    int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() -1);
    pageable = PageRequest.of(page, 10, Sort.by(Direction.DESC, "id"));

    return companyRepository.findAll(pageable);
  }

  public List<Company> findAll() {
    return companyRepository.findAll();
  }

  public Company find(Long companyId) {
    return companyRepository.findById(companyId).get();
  }
}
