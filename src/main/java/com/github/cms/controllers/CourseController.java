package com.github.cms.controllers;

import com.github.cms.models.Course;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cms/course")
@Slf4j
@Api(value="Course Service", description="Operations pertaining to Courses")
public class CourseController {

    @GetMapping("")
    @ApiOperation(value = "Get Courses List", response = ArrayList.class)
    private ResponseEntity<List<Course>> getCourses(String studentId, String collegeId, @Value("${configTestValue}") String valueFromConfigServer){
        ArrayList<Course> courseList = new ArrayList<>();
        try{
            log.info("Calling courses Service:: Get Courses");
            Course machineLearning = new Course(Integer.parseInt(valueFromConfigServer),"Machine Learning");
            courseList.add(machineLearning);
        }
        catch (Exception ex){
            log.error("Error calling Get Course Service::"+ex.getMessage());
        }
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }
}
