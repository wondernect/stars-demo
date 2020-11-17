package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentResponseDTO;
import com.wondernect.demo.stars.demo.excel.*;
import com.wondernect.elements.easyoffice.excel.ESExcelImportDataHandler;
import com.wondernect.elements.easyoffice.excel.ESExcelImportVerifyHandler;
import com.wondernect.elements.easyoffice.excel.ESExcelItem;
import com.wondernect.elements.easyoffice.excel.ESExcelItemHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 学生服务
 *
 * @author chenxun 2020-11-17 13:43:30
 **/
@Service
public class StudentService extends StudentAbstractService {

    public List<ESExcelItem> excelItemList() {
        return super.excelItemList(StudentResponseDTO.class);
    }

    public void excelDataExport(String templateId, ListStudentRequestDTO listStudentRequestDTO, HttpServletRequest request, HttpServletResponse response) {
        super.excelDataExport(templateId, StudentResponseDTO.class, list(listStudentRequestDTO), "学生信息导出", "学生信息导出", "学生信息导出", request, response);
    }

    public void excelDataImport(String templateId, InputStream fileInputStream, HttpServletRequest request, HttpServletResponse response) {
        super.excelDataImport(templateId, StudentResponseDTO.class, 1, 1, fileInputStream, "学生信息导入错误信息", request, response);
    }

    public void excelDataImportModel(String templateId, HttpServletRequest request, HttpServletResponse response) {
        super.excelDataExport(templateId, StudentResponseDTO.class, new ArrayList<>(), "学生信息导入", "学生信息导入", "学生信息导入模板", request, response);
    }

    @Override
    public List<ESExcelItemHandler> generateExcelItemHandlerList(String templateId) {
        switch (templateId) {
            default: {
                return Arrays.asList(
                        new StudentResponseDTONameHandler(2),
                        new StudentResponseDTOSexHandler(3),
                        new StudentResponseDTOAgeHandler(1)
                );
            }
        }
    }

    @Override
    public ESExcelImportDataHandler generateExcelImportDataHandler(String templateId) {
        return new StudentImportDataHandler();
    }

    @Override
    public ESExcelImportVerifyHandler generateExcelImportVerifyHandler(String templateId) {
        return new StudentImportVerifyHandler();
    }
}