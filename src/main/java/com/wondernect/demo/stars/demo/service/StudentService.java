package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentResponseDTO;
import com.wondernect.demo.stars.demo.excel.*;
import com.wondernect.demo.stars.demo.model.Student;
import com.wondernect.elements.easyoffice.excel.*;
import com.wondernect.elements.easyoffice.excel.handler.ESExcelIntegerItemHandler;
import com.wondernect.elements.easyoffice.excel.handler.ESExcelStringItemHandler;
import com.wondernect.elements.easyoffice.excel.handler.ESExcelTimestampItemHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

/**
 * 学生服务
 *
 * @author chenxun 2020-11-17 13:43:30
 **/
@Service
public class StudentService extends StudentAbstractService {

    @Autowired
    private StudentImportDataHandler studentImportDataHandler;

    @Autowired
    private StudentImportVerifyHandler studentImportVerifyHandler;

    public List<ESExcelItem> excelItemList() {
        return ESExcelUtils.getAllEntityExcelItem(StudentResponseDTO.class);
    }

    public void excelDataExport(String templateId, ListStudentRequestDTO listStudentRequestDTO, HttpServletRequest request, HttpServletResponse response) {
        super.excelDataExport(templateId, StudentResponseDTO.class, list(listStudentRequestDTO), "学生信息导出", "学生信息导出", "学生信息导出", request, response);
    }

    public void excelDataImport(String templateId, InputStream fileInputStream, HttpServletRequest request, HttpServletResponse response) {
        super.excelDataImport(templateId, StudentResponseDTO.class, studentImportDataHandler, studentImportVerifyHandler, 1, 1, fileInputStream, "学生信息导入错误信息", request, response);
    }

    public void excelDataImportModel(String templateId, HttpServletRequest request, HttpServletResponse response) {
        super.excelDataExport(templateId, StudentResponseDTO.class, new ArrayList<>(), "学生信息导入", "学生信息导入", "学生信息导入模板", request, response);
    }

    @Override
    public List<ESExcelItemHandler> generateExcelItemHandlerList(String templateId) {
        List<ESExcelItemHandler> excelItemHandlerList = new ArrayList<>();

        excelItemHandlerList.add(
                new ESExcelStringItemHandler("id", "学生id", 4)
        );

        excelItemHandlerList.add(
                new ESExcelStringItemHandler("name", "姓名", 2)
        );

        Map<Integer, String> dictionary = new HashMap<>();
        dictionary.put(1, "男");
        dictionary.put(2, "女");
        excelItemHandlerList.add(
                new StudentResponseDTOSexHandler(
                        "sex",
                        "性别",
                        1,
                        dictionary
                )
        );

        excelItemHandlerList.add(
                new ESExcelIntegerItemHandler("age", "年龄", 3)
        );

        // 导出时存在,导入时不可有
        excelItemHandlerList.add(
                new ESExcelTimestampItemHandler("createTime", "创建时间", 0)
        );

        return excelItemHandlerList;
    }

    @Override
    public void saveExcelEntityData(Map<String, Object> map, List<ESExcelItem> excelItemList) {
        StudentResponseDTO studentResponseDTO = ESExcelUtils.getImportObject(StudentResponseDTO.class, map, excelItemList);
        System.out.println(studentResponseDTO);
        super.saveEntity(
                new Student(
                        studentResponseDTO.getName(),
                        studentResponseDTO.getSex(),
                        studentResponseDTO.getAge()
                )
        );
    }
}