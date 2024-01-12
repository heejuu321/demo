package db.practice.demo.contoller;

import db.practice.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch/dep")
public class BatchController {

    private DepartmentService departmentService;

    @Autowired
    private BatchController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    @RequestMapping(value="/list", method=RequestMethod.POST)
//    public List<Department> listAll() {
//
//    }

}