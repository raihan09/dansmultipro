package com.dans.dansmultipro.controller;

import com.dans.dansmultipro.service.JobListService;
import com.dans.dansmultipro.utill.JwtUtill;
import com.dans.dansmultipro.wrapper.JobListWrapper;
import com.dans.dansmultipro.wrapper.LoginRequestWrapper;
import com.dans.dansmultipro.wrapper.ResposeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DansAppController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtill jwtUtill;
    @Autowired
    private JobListService jobListService;

    @GetMapping("/")
    private String homepage() {
        return "Wellcome";
    }

    @PostMapping("/login")
    private String generateToken(@RequestBody LoginRequestWrapper requestWrapper) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestWrapper.getUsername(), requestWrapper.getPassword()));
            return jwtUtill.generateToken(requestWrapper.getUsername());
        } catch (Exception e) {
            return ("Invalid Username/Password");
        }
    }

    @PostMapping("/jobList")
    private ResposeApi getJobList()  {
        ResposeApi response = new ResposeApi();
        try {
            List<JobListWrapper> jobListWrapper = jobListService.getJobList();
            response.setStatus("200");
            response.setMessage("Succes");
            response.setPayload(jobListWrapper);
            return response;
        } catch (Exception e) {
            response.setStatus("200");
            response.setMessage("Succes");
            response.setPayload(e.getMessage());
            return response;
        }

    }

    @PostMapping("/jobListDetail/{jobId}")
    private ResposeApi getJobList(@PathVariable String jobId)  {
        ResposeApi response = new ResposeApi();
        try {
            JobListWrapper jobListWrapper = jobListService.getJobDetail(jobId);
            response.setStatus("200");
            response.setMessage("Succes");
            response.setPayload(jobListWrapper);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus("200");
            response.setMessage("Succes");
            response.setPayload(e.getMessage());
            return response;
        }

    }
}
