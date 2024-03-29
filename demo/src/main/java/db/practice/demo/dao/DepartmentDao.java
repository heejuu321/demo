package db.practice.demo.dao;

import db.practice.demo.comn.OracleAbstarctMapper;
import db.practice.demo.dao.mapper.DepartmentMapper;
import db.practice.demo.dto.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao extends OracleAbstarctMapper {

    private DepartmentMapper departmentMapper;

    DepartmentDao(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public List<Department> listAll() throws Exception {

        return departmentMapper.selectAll();
    }

//    public List<YlTbApiCdPtInfEntity> selectListOrderByPointNameAsc(YlTbApiCdPtInfEntity entity) {
//        return getSqlSession().getMapper(YlTbApiCdPtInfMapper.class).selectListOrderByPointNameAsc(entity);
//    }
}
