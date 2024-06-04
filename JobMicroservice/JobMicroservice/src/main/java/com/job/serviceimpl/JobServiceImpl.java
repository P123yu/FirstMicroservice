package com.job.serviceimpl;

import com.job.dto.JobCompanyDTO;
import com.job.external.CompanyModel;
import com.job.model.JobModel;
import com.job.repository.JobRepository;
import com.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public JobModel insert(JobModel jobModel) {
        return jobRepository.save(jobModel);
    }



//    @Override
//    public List<JobModel> getAll() {
//        return jobRepository.findAll();
//    }




//    @Override
//    public List<JobCompanyDTO> getAll() {
//        List<JobCompanyDTO>jobCompanyDTOs=new ArrayList<>();
//        List<JobModel>allJob=jobRepository.findAll();
//        for(JobModel job:allJob){
//            JobCompanyDTO jobCompanyDTO=new JobCompanyDTO();
//            jobCompanyDTO.setJobModel(job);
//            CompanyModel company=fetchCompanyDetails(job.getCompanyId());
//            jobCompanyDTO.setCompanyModel(company);
//            jobCompanyDTOs.add(jobCompanyDTO);
//        }
//        return jobCompanyDTOs;
//    }
//
//    private CompanyModel fetchCompanyDetails(Long companyId) {
//        return webClientBuilder.build()
//                .get()
//                .uri("http://localhost:8082/company/getById/{id}", companyId)
//                .retrieve()
//                .bodyToMono(CompanyModel.class)
//                .block(); // This is a blocking call, consider using reactive approach for better performance
//    }



    @Override
    public List<JobCompanyDTO> getAll() {
        List<JobCompanyDTO>jobCompanyDTOs=new ArrayList<>();
        List<JobModel>allJob=jobRepository.findAll();
        for(JobModel job:allJob){
            JobCompanyDTO jobCompanyDTO=new JobCompanyDTO();
            jobCompanyDTO.setJobId(job.getJobId());
            jobCompanyDTO.setJobName(job.getJobName());
            jobCompanyDTO.setJobSalary(job.getJobSalary());
            CompanyModel company=fetchCompanyDetails(job.getCompanyId());
            jobCompanyDTO.setCompanyModel(company);
            jobCompanyDTOs.add(jobCompanyDTO);
        }
        return jobCompanyDTOs;
    }

    private CompanyModel fetchCompanyDetails(Long companyId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/company/getById/{id}", companyId)
                .retrieve()
                .bodyToMono(CompanyModel.class)
                .block(); // This is a blocking call, consider using reactive approach for better performance
    }



    @Override
    public JobModel getById(String jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }

    @Override
    public List<JobModel> getByName(String jobName) {
        return jobRepository.findByJobName(jobName);
    }

    @Override
    public List<JobModel> getByCompanyId(Long companyId) {
        return jobRepository.findByCompanyId(companyId);
    }

    @Override
    public List<JobCompanyDTO> getByJobName(String jobName) {
        List<JobModel> jobModels = jobRepository.findByJobName(jobName);
        List<JobCompanyDTO> jobCompanyDTOs = new ArrayList<>();

        for (JobModel job : jobModels) {
            JobCompanyDTO jobCompanyDTO = new JobCompanyDTO();
            jobCompanyDTO.setJobId(job.getJobId());
            jobCompanyDTO.setJobName(job.getJobName());
            jobCompanyDTO.setJobSalary(job.getJobSalary());
            jobCompanyDTO.setCompanyModel(convertCompanyModel(job.getCompanyId()));
            jobCompanyDTOs.add(jobCompanyDTO);
        }

        return jobCompanyDTOs;
    }

    public CompanyModel convertCompanyModel(Long companyId) {

        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/company/getById/{id}", companyId)
                .retrieve()
                .bodyToMono(CompanyModel.class)
                .block();
    }


}
