package com.task.departmentservice.controller;

import com.task.departmentservice.entity.Department;
import com.task.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }
    @DeleteMapping("{id}")
    public String deleteByid(@PathVariable("id") Long id){
        return departmentService.DeleteById(id);
    }

    @PutMapping("/update")
    public Department updateById(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }
}
