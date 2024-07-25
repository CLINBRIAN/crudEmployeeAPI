package com.code.crud.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.code.crud.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
