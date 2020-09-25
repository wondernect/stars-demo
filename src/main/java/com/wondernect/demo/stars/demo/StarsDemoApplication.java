package com.wondernect.demo.stars.demo;

import com.wondernect.demo.stars.demo.service.StudentService;
import com.wondernect.elements.authorize.context.WondernectCommonContext;
import com.wondernect.elements.boot.application.WondernectBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

public class StarsDemoApplication extends WondernectBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarsDemoApplication.class, args);
    }

    @Autowired
    private WondernectCommonContext wondernectCommonContext;

    @Autowired
    private StudentService studentService;

    @Override
    public void initAfterBootFinished() {
        wondernectCommonContext.getAuthorizeData().setAppId("1");
        studentService.deleteAll();
    }
}
