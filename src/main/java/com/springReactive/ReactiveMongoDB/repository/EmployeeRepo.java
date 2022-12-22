package com.springReactive.ReactiveMongoDB.repository;

import com.springReactive.ReactiveMongoDB.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepo extends ReactiveMongoRepository<Employee, String> {
    Mono<Employee> findByEmpIDEquals(String empID);

    Mono<Void> deleteByEmpIDEquals(String empID);
}
