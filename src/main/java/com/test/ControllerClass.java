package com.test;

import com.test.entity.Employee;
import com.test.entity.EmployeeResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("webhook/")
public class ControllerClass {

        @Inject
        private ServiceClass serviceClass;

        @Post(produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
        public Single<EmployeeResponse> createEmployee(@Body Employee employee) {
                return serviceClass.createEmployee(employee);
        }
}

