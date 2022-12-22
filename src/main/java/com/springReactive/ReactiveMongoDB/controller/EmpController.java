package com.springReactive.ReactiveMongoDB.controller;

import com.springReactive.ReactiveMongoDB.model.Employee;
import com.springReactive.ReactiveMongoDB.service.EmpService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @PostMapping("/createEmp")
    public Mono<Employee> createEmp (@RequestBody Employee employee){
        return empService.create(employee);
    }

    @GetMapping("/getAllEmp")
    public Flux<Employee> getAllEmp(){
        return empService.getAll();
    }

    @GetMapping("/getByEmpID/{empID}")
    public Mono<Employee> getByEmpID(@PathVariable String empID){
        return empService.getByEmpID(empID);
    }

    @PutMapping("/UpdateEmp")
    public Mono<Employee> updateEmp (@RequestBody Employee employee){
        return empService.updateEmp(employee);
    }


    @DeleteMapping("/deleteAllEmp")
    public Mono<Void> deleteAll(){
        return empService.deleteAll();
    }

    @DeleteMapping("/delete/{empID}")
    public Mono<Void> deleteByEmpID(@PathVariable String empID){
        return empService.deleteByEmpID(empID);
    }
}
