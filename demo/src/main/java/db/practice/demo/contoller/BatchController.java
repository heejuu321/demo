package db.practice.demo.contoller;

import db.practice.demo.dto.Department;
import db.practice.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/batch/dep")
public class BatchController {

    private DepartmentService departmentService;

    @Autowired
    private BatchController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public List<Department> listAll() throws Exception {
        
        System.out.println("컨트롤러에서 찍어");

        return departmentService.listAll();

    }

}