package com.chitnis.JobApp.service;

import com.chitnis.JobApp.model.JobPost;
import com.chitnis.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    //here this type of object 'jobpost' is known as DTO(Data transfer Object)
    public void addJob(JobPost jobPost) {

        repo.addJob(jobPost);
    }

    //here we will get the list of all the jobs that we are created by the recruiter
    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }


}
