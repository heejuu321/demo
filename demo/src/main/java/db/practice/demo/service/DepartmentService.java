package db.practice.demo.service;


import db.practice.demo.dto.Department;

import java.util.List;

public interface DepartmentService {

      List<Department> listAll() throws Exception;
}
