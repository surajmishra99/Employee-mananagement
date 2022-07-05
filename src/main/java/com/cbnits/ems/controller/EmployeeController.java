package com.cbnits.ems.controller;

import com.cbnits.ems.entity.EmployeeEntity;
import com.cbnits.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/")
    public String Hello (){
        return "Hello Employee Manage your complete employee portal here";
    }
    @GetMapping("/getallemp")
    public List<EmployeeEntity> getAll(){
        return this.employeeService.getAll();
    }
    @GetMapping("/getallemp/{id}")
    public EmployeeEntity getAll(@PathVariable long id){
        return this.employeeService.getById(id);
    }
    @PostMapping("/insertdata")
    public EmployeeEntity insertData(@RequestBody EmployeeEntity employeeEntity){
        return this.employeeService.addData(employeeEntity);
    }
    @PutMapping("/updatedata/{id}")
    public EmployeeEntity updateData (@PathVariable long id , @RequestBody EmployeeEntity employeeEntity){
        return this.employeeService.updateData (id, employeeEntity);
    }
    @DeleteMapping("/deleteemp/{id}")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable  long id){
        try {
            this.employeeService.deleteDataById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
