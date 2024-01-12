package db.practice.demo.service.impl;

import db.practice.demo.dao.DepartmentDao;
import db.practice.demo.dto.Department;
import db.practice.demo.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    public List<Department> listAll() throws Exception {

        return departmentDao.listAll();

    }

}
