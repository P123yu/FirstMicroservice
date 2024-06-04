package com.job.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Document

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobModel {

    @Id
    private String jobId;
    private String jobName;
    private String jobSalary;
    private Long companyId;
}
