package com.job.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyModel {
    private Long companyId;
    private String companyName;
    private String companyType;
    private String companyLocation;
}
