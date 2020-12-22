package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.SaveStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentResponseDTO;
import com.wondernect.demo.stars.demo.excel.StudentImportDataHandler;
import com.wondernect.demo.stars.demo.excel.StudentImportVerifyHandler;
import com.wondernect.demo.stars.demo.excel.StudentResponseDTOSexHandler;
import com.wondernect.elements.common.utils.ESObjectUtils;
import com.wondernect.elements.easyoffice.excel.handler.*;
import com.wondernect.elements.easyoffice.excel.model.ESExcelItem;
import com.wondernect.elements.easyoffice.excel.service.ESExcelImportResponseService;
import com.wondernect.elements.easyoffice.excel.util.ESExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2020, wondernect.com
 * FileName: UserService
 * Author: chenxun
 * Date: 2020-06-25 19:33
 * Description:
 */
@Service
public class StudentExcelImportResponseService extends ESExcelImportResponseService {

    private static final Logger logger = LoggerFactory.getLogger(StudentExcelImportResponseService.class);

    @Autowired
    private StudentImportDataHandler studentImportDataHandler;

    @Autowired
    private StudentImportVerifyHandler studentImportVerifyHandler;

    @Autowired
    private StudentService studentService;

    public void importDataResponse(String templateId, InputStream fileInputStream, HttpServletRequest request, HttpServletResponse response) {
        super.excelDataImport(templateId, StudentResponseDTO.class, studentImportDataHandler, studentImportVerifyHandler, 1, 1, fileInputStream, "学生信息导入错误信息", request, response);
    }

    @Override
    public void saveExcelImportEntityData(Map<String, Object> map, List<ESExcelItem> excelItemList) {
        StudentResponseDTO studentResponseDTO = ESExcelUtils.getImportObject(StudentResponseDTO.class, map, excelItemList);
        if (ESObjectUtils.isNotNull(studentResponseDTO)) {
            studentService.create(
                    new SaveStudentRequestDTO(
                            studentResponseDTO.getName(),
                            studentResponseDTO.getSex(),
                            studentResponseDTO.getAge()
                    )
            );
        }
    }

    @Override
    public List<ESExcelItemHandler> generateExcelItemHandlerList(String templateId) {
        List<ESExcelItemHandler> excelItemHandlerList = new ArrayList<>();
        excelItemHandlerList.add(
                new ESExcelStringItemHandler("name", "姓名", 0)
        );
        excelItemHandlerList.add(
                new StudentResponseDTOSexHandler("sex", "性别", 1)
        );
        excelItemHandlerList.add(
                new ESExcelIntegerItemHandler("age", "年龄", 2)
        );
        return excelItemHandlerList;
    }
}
