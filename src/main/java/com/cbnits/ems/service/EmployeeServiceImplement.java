package com.cbnits.ems.service;

import com.cbnits.ems.entity.EmployeeEntity;
import com.cbnits.ems.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImplement implements EmployeeService{
    @Autowired
    private EmployeeRespository employeeRespository;

    @Override
    public List<EmployeeEntity> getAll(){
        return employeeRespository.findAll();
    }

    @Override
    public EmployeeEntity getById(long id){
        Optional<EmployeeEntity> data = employeeRespository.findById(id);
        if(data.isPresent()){
            return data.get();
        }
        return null;
    }
    public EmployeeEntity addData (EmployeeEntity employeeEntity){
        return employeeRespository.save(employeeEntity);
    }

    public EmployeeEntity updateData (long id, EmployeeEntity employeeEntity){
        Optional<EmployeeEntity> data = employeeRespository.findById(id);
        if(data.isPresent()){
            employeeEntity.setId(id);
            return employeeRespository.save(employeeEntity);
        }
        return null;
    }

    public void deleteDataById(long id){
        employeeRespository.deleteById(id);
    }


}
