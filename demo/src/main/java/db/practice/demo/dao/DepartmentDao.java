package db.practice.demo.dao;

import db.practice.demo.dto.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    private DepartmentMapper departmentMapper;

    DepartmentDao(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public List<Department> listAll() throws Exception {

        return departmentMapper.selectAll();
    }
}
