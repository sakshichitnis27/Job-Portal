package com.chitnis.JobApp;


//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import com.chitnis.JobApp.model.JobPost;
import com.chitnis.JobApp.repo.JobRepo;
import com.chitnis.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    //here we want this controller to work for both '/' and 'home'
    @GetMapping({"/","home"})
    public String name(){
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }

//    from here recruiter is adding a new job data to the job portal
    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    //here we are configuring data for 'viewalljobs'
    @GetMapping("viewalljobs")
    public String viewJobs(Model m){
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }


}
