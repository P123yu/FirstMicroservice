package com.comp.serviceimpl;


import com.comp.dto.CompanyJobDTO;
import com.comp.external.JobModel;
import com.comp.model.CompanyModel;
import com.comp.repository.CompanyRepository;
import com.comp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyModel insert(CompanyModel companyModel) {
        return companyRepository.save(companyModel);
    }

    @Override
    public List<CompanyModel> getAll() {
        return companyRepository.findAll();
    }

//    @Override
//    public CompanyModel getById(Long companyId) {
//        return companyRepository.findById(companyId).orElse(null);
//    }

//
//    @Autowired
//    private WebClient.Builder webClientBuilder;
//    @Override
//    public CompanyJobDTO getById(Long companyId) {
//        CompanyJobDTO companyJobDTO=new CompanyJobDTO();
//        companyJobDTO.setCompanyModel(companyRepository.findById(companyId).orElse(null));
//        companyJobDTO.setJobModel(fetchJobDetails(companyId));
//        return companyJobDTO;
//    }
//
////    private List<JobModel> fetchJobDetails(Long companyId) {
////        return (List<JobModel>) webClientBuilder.build()
////                .get()
////                .uri("http://localhost:8083/job/getByCompanyId/2")
////                .retrieve()
////                .bodyToMono(JobModel.class)
////                .block(); // This is a blocking call, consider using reactive approach for better performance
////    }
//
//
//    private List<JobModel> fetchJobDetails(Long companyId) {
//        JobModel[] jobModels = webClientBuilder.build()
//                .get()
//                .uri("http://localhost:8083/job/getByCompanyId/{companyId}", companyId)
//                .retrieve()
//                .bodyToMono(JobModel[].class)
//                .block(); // This is a blocking call, consider using reactive approach for better performance
//
//        return Arrays.asList(jobModels);
//    }
//















    @Autowired
    private WebClient.Builder webClientBuilder;
    @Override
    public CompanyJobDTO getById(Long companyId) {
        CompanyJobDTO companyJobDTO=new CompanyJobDTO();

        CompanyModel comp=companyRepository.findById(companyId).orElse(null);
        companyJobDTO.setCompanyId(comp.getCompanyId());
        companyJobDTO.setCompanyName(comp.getCompanyName());
        companyJobDTO.setCompanyType(comp.getCompanyType());
        companyJobDTO.setCompanyLocation(comp.getCompanyLocation());
        companyJobDTO.setJobModel(fetchJobDetails(companyId));
        return companyJobDTO;
    }


    private List<JobModel> fetchJobDetails(Long companyId) {
        JobModel[] jobModels = webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/job/getByCompanyId/{companyId}", companyId)
                .retrieve()
                .bodyToMono(JobModel[].class)
                .block(); // This is a blocking call, consider using reactive approach for better performance

        return Arrays.asList(jobModels);
    }

}
