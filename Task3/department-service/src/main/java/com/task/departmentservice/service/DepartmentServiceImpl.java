package com.task.departmentservice.service;

import com.task.departmentservice.entity.Department;
import com.task.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public String DeleteById(Long id) {
        departmentRepository.deleteById(id);
        return "The record is deleted ";
    }

    @Override
    public Department updateDepartment(Department department) {
        Department existingDepartment = departmentRepository.findById(department.getId()).orElse(null);
        existingDepartment.setDepartmentCode(department.getDepartmentCode());
        existingDepartment.setDepartmentName(department.getDepartmentName());
        existingDepartment.setDepartmentCode(department.getDepartmentCode());
        return departmentRepository.save(existingDepartment);
    }
}
