package com.test.client;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.test.entity.Employee;
import com.test.entity.EmployeeResponse;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class DummyClient {

        private RxHttpClient httpClient;
        private Gson gson = new Gson();

        public DummyClient(@Client("http://dummy.restapiexample.com/api/v1/") RxHttpClient httpClient) {
            this.httpClient = httpClient;
        }

        public Single<EmployeeResponse> getEmployee(Integer id) {
            HttpRequest<Employee> req = HttpRequest.GET("employee/" + id);
            return httpClient.retrieve(req, EmployeeResponse.class).firstOrError();
        }

        public Single<EmployeeResponse> createEmployee(Employee employee) {
            HttpRequest<String> req = HttpRequest.POST("create", gson.toJson(employee));
            return httpClient.retrieve(req, EmployeeResponse.class).firstOrError();
        }

    }

