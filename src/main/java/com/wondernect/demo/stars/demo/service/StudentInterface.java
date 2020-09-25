package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentResponseDTO;
import com.wondernect.elements.easyoffice.excel.ESExcelItem;
import com.wondernect.elements.rdb.response.PageResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学生服务接口类
 *
 * @author chenxun 2020-09-25 12:13:14
 **/
public interface StudentInterface {

    /**
     * 创建
     **/
    StudentResponseDTO create(SaveStudentRequestDTO saveStudentRequestDTO);

    /**
     * 更新
     **/
    StudentResponseDTO update(String id, SaveStudentRequestDTO saveStudentRequestDTO);

    /**
     * 删除
     **/
    void deleteById(String id);

    /**
     * 获取详细信息
     **/
    StudentResponseDTO findById(String id);

    /**
     * 列表
     **/
    List<StudentResponseDTO> list(ListStudentRequestDTO listStudentRequestDTO);

    /**
     * 分页
     **/
    PageResponseData<StudentResponseDTO> page(PageStudentRequestDTO pageStudentRequestDTO);

    /**
     * 获取excel的所有可用列名、类型、描述、get方法、set方法
     **/
    List<ESExcelItem> excelItemList();

    /**
     * excel导出
     **/
    void excelDataExport(String exportServiceIdentifier, ListStudentRequestDTO listStudentRequestDTO, HttpServletRequest request, HttpServletResponse response);
}