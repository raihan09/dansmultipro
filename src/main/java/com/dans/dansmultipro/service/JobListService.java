package com.dans.dansmultipro.service;

import com.dans.dansmultipro.wrapper.JobListWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class JobListService {

    @Value("${joblist.url}")
    private String jobListUrl;

    @Value("${joblist.detail.url}")
    private String jobListDetailUrl;

    public List<JobListWrapper> getJobList () {
        try {
            List<JobListWrapper> jobListWrappers = new ArrayList<>();
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JobListWrapper[]> jobListWrapperResponseEntity = restTemplate.exchange(jobListUrl, HttpMethod.GET,null,JobListWrapper[].class );

            if(jobListWrapperResponseEntity.getBody()!=null) {
                for (int i = 0; i < jobListWrapperResponseEntity.getBody().length; i++) {
                    JobListWrapper jobListWrapper = jobListWrapperResponseEntity.getBody()[i];
                    JobListWrapper jobListWrapperNew = new JobListWrapper();
                    jobListWrapperNew.setId(jobListWrapper.getId());
                    jobListWrapperNew.setType(jobListWrapper.getType());
                    jobListWrapperNew.setTitle(jobListWrapper.getTitle());
                    jobListWrappers.add(jobListWrapperNew);
                }

            }
            return jobListWrappers;
        }
        catch (Exception e) {
            throw e;
        }
    }

    public JobListWrapper getJobDetail (String jobId) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Map<String, String> uriParam = new HashMap<>();
            uriParam.put("ID", jobId);
            ResponseEntity<JobListWrapper> jobListWrapperResponseEntity = restTemplate.exchange(jobListDetailUrl, HttpMethod.GET,null,JobListWrapper.class,uriParam);
            return jobListWrapperResponseEntity.getBody();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
