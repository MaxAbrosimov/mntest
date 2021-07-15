package com.test.client;

import com.test.entity.Employee;
import com.test.entity.EmployeeResponse;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class DummyClient {

        private RxHttpClient httpClient;

        public DummyClient(@Client("http://dummy.restapiexample.com/api/v1/") RxHttpClient httpClient) {
            this.httpClient = httpClient;
        }

        public Single<EmployeeResponse> createEmployee(Employee employee) {
            HttpRequest<Employee> req = HttpRequest.POST("create", employee);
            return httpClient.retrieve(req, EmployeeResponse.class).firstOrError();
        }

    }

