package com.ddu.vo;

import lombok.Data;

/**
 * @Author Costar
 * @Date 周三 2024-10-09 23:37
 */

@Data
public class EmployeeVO {

    private String name;
    private Integer age;

    private String accountNumber;
    private String email;

    private DeptVO dept;
}
