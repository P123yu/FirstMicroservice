//package com.job.dto;
//import com.job.external.CompanyModel;
//import com.job.model.JobModel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class JobCompanyDTO {
//    JobModel jobModel;
//    CompanyModel companyModel;
//}
//

//
//package com.job.dto;
//import com.job.external.CompanyModel;
//import com.job.model.JobModel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class JobCompanyDTO {
//    List<JobModel> jobModel;
//    List<CompanyModel> companyModel;
//}


//
//package com.job.dto;
//import com.job.external.CompanyModel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class JobCompanyDTO {
//    private String jobId;
//    private String jobName;
//    private String jobSalary;
//    List<CompanyModel> companyModel;
//}
//
//





package com.job.dto;
import com.job.external.CompanyModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobCompanyDTO {
    private String jobId;
    private String jobName;
    private String jobSalary;
    CompanyModel companyModel;
}


