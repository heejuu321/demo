package db.practice.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentDto {

    private String DepCode;
    private String DepParentCode;
    private String DepName;
    private String CreateDt;
    private String CreateId;
    private String UpdateDt;
    private String UpdateId;
}
