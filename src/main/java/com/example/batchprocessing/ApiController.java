package com.example.batchprocessing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(path = "/v1/job")
public class ApiController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("ImportUserJob")
    private Job ImportUserJob;

    @PostMapping("/launch")
    public ResponseEntity<String> launch() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParametersBuilder jobParameters = new JobParametersBuilder().addLocalDateTime("date", LocalDateTime.now() );

        final JobExecution jobExecution = jobLauncher.run(ImportUserJob, jobParameters.toJobParameters());
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

}