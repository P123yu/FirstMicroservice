package com.comp.controller;


import com.comp.dto.CompanyJobDTO;
import com.comp.model.CompanyModel;
import com.comp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @PostMapping("/insert")
    public ResponseEntity<?>insert(@RequestBody CompanyModel companyModel){
        CompanyModel company=companyService.insert(companyModel);
        if(company!=null){
            return ResponseEntity.ok(company);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company not found");
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<?>getAll(){
        List<CompanyModel> allCompany=companyService.getAll();
        if(!allCompany.isEmpty()){
            return ResponseEntity.ok(allCompany);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("all company not found");
        }
    }


//    @GetMapping("/getById/{id}")
//    public ResponseEntity<?>getById(@PathVariable("id") Long companyId){
//        CompanyModel company=companyService.getById(companyId);
//        if(company!=null){
//            return ResponseEntity.ok(company);
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company not found during fetching");
//        }
//    }



    @GetMapping("/getById/{id}")
    public ResponseEntity<?>getById(@PathVariable("id") Long companyId){
        CompanyJobDTO company=companyService.getById(companyId);
        if(company!=null){
            return ResponseEntity.ok(company);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("company not found during fetching");
        }
    }

}
