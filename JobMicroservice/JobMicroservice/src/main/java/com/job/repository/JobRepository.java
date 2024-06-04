package com.job.repository;

import com.job.model.JobModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobRepository extends MongoRepository<JobModel,String> {

    List<JobModel> findByJobName(String jobName);

    List<JobModel> findByCompanyId(Long CompanyId);
}
