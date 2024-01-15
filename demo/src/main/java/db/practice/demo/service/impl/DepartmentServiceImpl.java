package db.practice.demo.service.impl;

import db.practice.demo.dao.DepartmentDao;
import db.practice.demo.dto.Department;
import db.practice.demo.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    public List<Department> listAll() throws Exception {

        return departmentDao.listAll();
    }

//    @Transactional(value="DataSourceTransactionManager", rollbackFor = {Exception.class})
//    public void service() {
//        try {
//            insert();
//        } catch(Exception e) {
//            logger.error("");
//            throw e;
//        }
//    }


}
