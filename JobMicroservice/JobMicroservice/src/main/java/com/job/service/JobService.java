package com.job.service;

import com.job.dto.JobCompanyDTO;
import com.job.model.JobModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    // insert
    JobModel insert(JobModel jobModel);

//    // getAll
//    List<JobModel> getAll();

    // getAll
    List<JobCompanyDTO> getAll();

    // getById
    JobModel getById(String jobId);

    // getById
    List<JobModel> getByName(String jobName);


    // getById
    List<JobModel> getByCompanyId(Long companyId);

    // getByName
    List<JobCompanyDTO> getByJobName(String jobName);
}
