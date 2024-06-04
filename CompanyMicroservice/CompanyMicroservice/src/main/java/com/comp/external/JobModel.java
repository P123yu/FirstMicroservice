package com.comp.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobModel {
    private String jobId;
    private String jobName;
    private String jobSalary;
    //private Long companyId;
}
