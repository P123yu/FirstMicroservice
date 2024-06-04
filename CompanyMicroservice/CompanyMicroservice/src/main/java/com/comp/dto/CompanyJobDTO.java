//package com.comp.dto;
//
//import com.comp.external.JobModel;
//import com.comp.model.CompanyModel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class CompanyJobDTO {
//
//    private CompanyModel companyModel;
//    private List<JobModel> jobModel;
//}



package com.comp.dto;

import com.comp.external.JobModel;
import com.comp.model.CompanyModel;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CompanyJobDTO {

//    private CompanyModel companyModel;

    private Long companyId;
    private String companyName;
    private String companyType;
    private String companyLocation;
    private List<JobModel> jobModel;
}
