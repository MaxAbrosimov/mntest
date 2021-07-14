package com.test;

import com.test.client.DummyClient;
import com.test.entity.Employee;
import com.test.entity.EmployeeResponse;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ServiceClass {

    @Inject
    private DummyClient dummyClient;

    public Single<EmployeeResponse> getEmployee(Integer id) {
        return dummyClient.getEmployee(id);
    }

    public Single<EmployeeResponse> createEmployee(Employee employee) {
        return dummyClient.createEmployee(employee);
    }

}
