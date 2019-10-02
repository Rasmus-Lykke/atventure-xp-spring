package com.example.atventurexp_spring.Service;

import com.example.atventurexp_spring.Model.Activity;
import com.example.atventurexp_spring.Repository.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityRepo activityRepo;

    public List<Activity> getAllActivities (){
        return activityRepo.findAll();
    }
}
