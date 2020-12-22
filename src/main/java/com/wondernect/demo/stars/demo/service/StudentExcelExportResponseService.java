package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentResponseDTO;
import com.wondernect.demo.stars.demo.excel.StudentResponseDTOSexHandler;
import com.wondernect.elements.easyoffice.excel.handler.*;
import com.wondernect.elements.easyoffice.excel.service.ESExcelExportResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2020, wondernect.com
 * FileName: UserService
 * Author: chenxun
 * Date: 2020-06-25 19:33
 * Description:
 */
@Service
public class StudentExcelExportResponseService extends ESExcelExportResponseService {

    private static final Logger logger = LoggerFactory.getLogger(StudentExcelExportResponseService.class);

    @Autowired
    private StudentService studentService;

    public void exportDataResponse(String templateId, ListStudentRequestDTO listStudentRequestDTO, HttpServletRequest request, HttpServletResponse response) {
        super.excelDataExport(templateId, StudentResponseDTO.class, studentService.list(listStudentRequestDTO), "学生信息导出", "学生信息导出", "学生信息导出", request, response);
    }

    @Override
    public List<ESExcelItemHandler> generateExcelItemHandlerList(String templateId) {
        List<ESExcelItemHandler> excelItemHandlerList = new ArrayList<>();
        // 导出时存在,导入时不可有
        excelItemHandlerList.add(
                new ESExcelStringItemHandler("id", "学生id", 0)
        );
        // 导出/导入均可存在
        excelItemHandlerList.add(
                new ESExcelStringItemHandler("name", "姓名", 1)
        );
        excelItemHandlerList.add(
                new StudentResponseDTOSexHandler("sex", "性别", 2)
        );
        excelItemHandlerList.add(
                new ESExcelIntegerItemHandler("age", "年龄", 3)
        );
        // 导出时存在,导入时不可有
        excelItemHandlerList.add(
                new ESExcelTimestampItemHandler("createTime", "创建时间", 4)
        );
        excelItemHandlerList.add(
                new ESExcelTimestampItemHandler("updateTime", "更新时间", 5)
        );
        return excelItemHandlerList;
    }
}
