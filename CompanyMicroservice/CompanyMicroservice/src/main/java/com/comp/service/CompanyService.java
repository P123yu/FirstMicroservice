package com.comp.service;


import com.comp.dto.CompanyJobDTO;
import com.comp.model.CompanyModel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CompanyService {

    // insert
    CompanyModel insert(CompanyModel companyModel);

    // getAll
    List<CompanyModel> getAll();

//    // getById
//    CompanyModel getById(Long companyId);

    // getById
    CompanyJobDTO getById(Long companyId);
}
