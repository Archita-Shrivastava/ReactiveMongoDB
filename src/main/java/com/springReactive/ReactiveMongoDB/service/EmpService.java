package com.springReactive.ReactiveMongoDB.service;

import com.springReactive.ReactiveMongoDB.model.Employee;
import com.springReactive.ReactiveMongoDB.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmpService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Mono<Employee> create(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Flux<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Mono<Employee> getByEmpID(String empID) {
        return employeeRepo.findByEmpIDEquals(empID);
    }

    public Mono<Employee> updateEmp(Employee employee) {
        return employeeRepo.findByEmpIDEquals(employee.getEmpID())
                .switchIfEmpty(Mono.error(new Exception("EMPLOYEE_NOT_FOUND")))
                .map(c -> {
                    c.setEmpName(employee.getEmpName());
                    c.setEmpCity(employee.getEmpCity());
                    c.setEmpExperience(employee.getEmpExperience());
                    return employee;
                })
                .flatMap(employeeRepo::save);
    }

    public Mono<Void> deleteAll() {
        return employeeRepo.deleteAll();
    }

    public Mono<Void> deleteByEmpID(String empID) {
        return employeeRepo.deleteByEmpIDEquals(empID);
    }
}
