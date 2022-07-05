package com.cbnits.ems.service;

import com.cbnits.ems.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeEntity> getAll();
    public EmployeeEntity getById(long id);
    public EmployeeEntity addData (EmployeeEntity employeeEntity);
    public EmployeeEntity updateData (long id,EmployeeEntity employeeEntity);
    public void deleteDataById(long id);
}
