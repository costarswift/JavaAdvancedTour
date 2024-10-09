package com.ddu.service;

import com.ddu.vo.DeptVO;
import com.ddu.vo.EmployeeVO;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * @Author Costar
 * @Date 周三 2024-10-09 23:40
 */
public class OptionalDemo1 {
    public static void main(String[] args) {
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setName("Costar");
        DeptVO deptVO = new DeptVO();
        deptVO.setDeptName("质量与流程IT");
        employeeVO.setDept(deptVO);
        String deptName = getDeptName(employeeVO);
        System.out.println(deptName);

        System.out.println(getDeptName(null));
    }

    private static String getDeptName(EmployeeVO emp) {
        return Optional.ofNullable(emp).map(EmployeeVO::getDept).map(DeptVO::getDeptName).filter(StringUtils::isNotBlank).
                orElse("Not set deptName");
    }
}
