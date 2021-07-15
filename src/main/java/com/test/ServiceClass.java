package com.test;

import com.test.client.DummyClient;
import com.test.entity.Employee;
import com.test.entity.EmployeeResponse;
import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class ServiceClass {

    private DummyClient dummyClient;

    public ServiceClass(DummyClient dummyClient) {
        this.dummyClient = dummyClient;
    }

    public Single<EmployeeResponse> createEmployee(Employee employee) {
        return dummyClient.createEmployee(employee);
    }

}
