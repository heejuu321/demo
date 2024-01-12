package db.practice.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Department {

    private String DepCode;
    private String DepParentCode;
    private String DepName;
    private String CreateDt;
    private String CreateId;
    private String UpdateDt;
    private String UpdateId;
}
