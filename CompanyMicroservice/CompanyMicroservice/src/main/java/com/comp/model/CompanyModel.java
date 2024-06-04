//package com.comp.model;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name="company_table")
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class CompanyModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long companyId;
//
//    @Column(unique = true,nullable = false)
//    private String companyName;
//    private String companyType;
//    private String companyLocation;
//}



package com.comp.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="company_table")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    @Column(unique = true,nullable = false)
    private String companyName;
    private String companyType;
    private String companyLocation;

    private String jobName;
}
