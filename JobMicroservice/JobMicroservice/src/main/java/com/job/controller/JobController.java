package com.job.controller;


import com.job.dto.JobCompanyDTO;
import com.job.model.JobModel;
import com.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
@CrossOrigin
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/insert")
    public ResponseEntity<?>insert(@RequestBody JobModel jobModel){
        JobModel job=jobService.insert(jobModel);
        if(job!=null){
            return ResponseEntity.ok(job);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("job not inserted");
        }
    }

//    @GetMapping("/getAll")
//    public ResponseEntity<?>getAll(){
//        List<JobModel> allJob=jobService.getAll();
//        if(!allJob.isEmpty()){
//            return ResponseEntity.ok(allJob);
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not find All job");
//        }
//    }



    @GetMapping("/getAll")
    public ResponseEntity<?>getAll(){
        List<JobCompanyDTO> allJob=jobService.getAll();
        if(!allJob.isEmpty()){
            return ResponseEntity.ok(allJob);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not find All job");
        }
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<?>getById(@PathVariable String id){
        JobModel job=jobService.getById(id);
        if(job!=null){
            return ResponseEntity.ok(job);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found by jobId");
        }
    }


    @GetMapping("/getByName/{name}")
    public ResponseEntity<?>getByName(@PathVariable String name){
        List<JobModel> allJob=jobService.getByName(name);
        if(!allJob.isEmpty()){
            return ResponseEntity.ok(allJob);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not find All job by name");
        }
    }



    @GetMapping("/getByJobName/{name}")
    public ResponseEntity<?>getByJobName(@PathVariable String name){
        List<JobCompanyDTO> allJob=jobService.getByJobName(name);
        if(!allJob.isEmpty()){
            return ResponseEntity.ok(allJob);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not find All job by name");
        }
    }

    @GetMapping("/getByCompanyId/{companyId}")
    public ResponseEntity<?>getByCompanyId(@PathVariable Long companyId){
        List<JobModel> allJob=jobService.getByCompanyId(companyId);
        if(!allJob.isEmpty()){
            return ResponseEntity.ok(allJob);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not find All job by name");
        }
    }
}
