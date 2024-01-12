package db.practice.demo.dao;

import db.practice.demo.dto.DepartmentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    List<DepartmentDto> selectAll() throws Exception;
}
