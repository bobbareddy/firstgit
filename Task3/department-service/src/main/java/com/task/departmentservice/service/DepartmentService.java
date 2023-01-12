package com.task.departmentservice.service;

import com.task.departmentservice.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
     String DeleteById(Long id);

     Department updateDepartment(Department department);
}
