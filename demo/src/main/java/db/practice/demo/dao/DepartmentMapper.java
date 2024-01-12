package db.practice.demo.dao;

import db.practice.demo.dto.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    List<Department> selectAll() throws Exception;
}
