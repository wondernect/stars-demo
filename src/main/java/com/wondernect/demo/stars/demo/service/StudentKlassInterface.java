package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListStudentKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageStudentKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveStudentKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentKlassResponseDTO;
import com.wondernect.elements.rdb.response.PageResponseData;

import java.util.List;

/**
 * 学生班级服务接口类
 *
 * @author chenxun 2020-06-29 19:14:38
 **/
public interface StudentKlassInterface {

    /**
     * 创建
     **/
    StudentKlassResponseDTO create(SaveStudentKlassRequestDTO saveStudentKlassRequestDTO);

    /**
     * 更新
     **/
    StudentKlassResponseDTO update(String id, SaveStudentKlassRequestDTO saveStudentKlassRequestDTO);

    /**
     * 删除
     **/
    void deleteById(String id);

    /**
     * 获取详细信息
     **/
    StudentKlassResponseDTO findById(String id);

    /**
     * 列表
     **/
    List<StudentKlassResponseDTO> list(ListStudentKlassRequestDTO listStudentKlassRequestDTO);

    /**
     * 分页
     **/
    PageResponseData<StudentKlassResponseDTO> page(PageStudentKlassRequestDTO pageStudentKlassRequestDTO);
}