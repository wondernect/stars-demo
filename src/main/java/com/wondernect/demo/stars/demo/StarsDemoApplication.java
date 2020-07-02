package com.wondernect.demo.stars.demo;

import com.wondernect.demo.stars.demo.service.StudentService;
import com.wondernect.elements.boot.application.WondernectBootApplication;
import com.wondernect.elements.rdb.request.PageRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

public class StarsDemoApplication extends WondernectBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarsDemoApplication.class, args);
    }

    @Autowired
    private StudentService studentService;

    @Override
    public void initAfterBootFinished() {
        System.out.println(studentService.list("83346814775984128"));
        System.out.println(studentService.page("83346826018816000", new PageRequestData(0, 10)));
    }
}
